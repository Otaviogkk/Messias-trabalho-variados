package br.edu.ifpi.Model;



import java.time.LocalDate;

public class TransferenciaBancaria implements MetodoPagamento {
    private String chavepix;
    private String descricao;
    
    public String getChavePix() {
        return this.chavepix;
    }
    public String getDescricao() {
        return "Pix - Chave: " + this.chavepix;
    }
    
    @Override
    public boolean validarPagamento() {
        if (chavepix == null || chavepix.trim().isEmpty()) {
            System.out.println("Erro: Chave Pix invalido.");
            return false;
        }
        return true;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (!validarPagamento()) {
            System.out.println("Falha ao processar pagamento: Chave Pix invalido.");
            return false;
        }
        System.out.println("Pagamento de R$ " + valor + " realizado via Pix com a chave " + chavepix);
        return true;
    }
    
    public void setChavepix(String chavepix) {
        this.chavepix = chavepix;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
