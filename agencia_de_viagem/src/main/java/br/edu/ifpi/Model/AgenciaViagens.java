package br.edu.ifpi.Model;
import java.util.ArrayList;
import java.util.List;

public class AgenciaViagens {
    private List<Cliente> clientes;
    private List<Reserva> reservas;

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Cliente> getClientes() {
        if (clientes == null) {
            clientes = new ArrayList<>();
        }
        return clientes;
    }

    public List<Reserva> getReservas() {
        if (reservas == null) {
            reservas = new ArrayList<>();
        }
        return reservas;
    }

    public void adicionarReserva(Reserva reserva) {
        getReservas().add(reserva);
        if (!getClientes().contains(reserva.getCliente())) {
            getClientes().add(reserva.getCliente());
        }
    }

    public void listarReservas() {
        System.out.println("\n=== LISTA DE RESERVAS ===");
        if (getReservas().isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }
        for (int i = 0; i < getReservas().size(); i++) {
            Reserva r = getReservas().get(i);
            System.out.println("Reserva [" + (i + 1) + "] - Status: " + r.getStatus());
            System.out.println("Cliente: " + r.getCliente().getNome());
            System.out.println("Destino: " + r.getPacote().getNomePacote());
            System.out.println("-------------------------");
        }
    }
}
