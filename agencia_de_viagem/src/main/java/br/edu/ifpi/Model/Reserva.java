package br.edu.ifpi.Model;

import jakarta.persistence.*;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private int codigoReserva;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Transient
    private PacoteTuristico pacote;

    @Transient
    private MetodoPagamento metodoPagamento;

    @Enumerated(EnumType.STRING)
    private StatusReserva status = StatusReserva.AGUARDANDO_PAGAMENTO;

    @Column(length = 2000)
    private String detalhesPacote;
    private double valorTotal;
    private String detalhesPagamento;

    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setPacote(PacoteTuristico pacote) { this.pacote = pacote; }
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) { this.metodoPagamento = metodoPagamento; }

    public void confirmarReserva() {
        double valorCobrado = pacote.getPrecoTotal();
        
        // Salva as informacoes resumidas para o banco
        this.detalhesPacote = pacote.getDescricao();
        this.valorTotal = valorCobrado;
        this.detalhesPagamento = metodoPagamento.getDescricao();

        if (metodoPagamento.processarPagamento(valorCobrado)) {
            this.status = StatusReserva.CONFIRMADA;
            System.out.println("Reserva confirmada!");
            System.out.println(pacote.getDescricao());
        } else {
            this.status = StatusReserva.CANCELADA;
            System.out.println("Pagamento recusado. Reserva cancelada.");
        }
    }
    
    public StatusReserva getStatus() { return status; }
    public Long getId() { return id; }
    public PacoteTuristico getPacote() { return pacote; }
    public MetodoPagamento getMetodoPagamento() { return metodoPagamento; }
    public Cliente getCliente(){ return this.cliente; }
    public String getDetalhesPacote() { return detalhesPacote; }
    public double getValorTotal() { return valorTotal; }
    public String getDetalhesPagamento() { return detalhesPagamento; }
}
