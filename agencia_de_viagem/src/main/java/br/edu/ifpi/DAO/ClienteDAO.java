package br.edu.ifpi.DAO;

import br.edu.ifpi.Model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public void salvarReserva(br.edu.ifpi.Model.Reserva reserva) {
        try {
            em.getTransaction().begin();
            em.persist(reserva);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        try {
            String jpql = "SELECT c FROM Cliente c LEFT JOIN FETCH c.reservas WHERE c.cpf = :cpf";
            TypedQuery<Cliente> query = em.createQuery(jpql, Cliente.class);
            query.setParameter("cpf", cpf);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public java.util.List<br.edu.ifpi.Model.Reserva> listarTodasReservas() {
        try {
            String jpql = "SELECT r FROM Reserva r JOIN FETCH r.cliente";
            TypedQuery<br.edu.ifpi.Model.Reserva> query = em.createQuery(jpql, br.edu.ifpi.Model.Reserva.class);
            return query.getResultList();
        } catch (Exception e) {
            return new java.util.ArrayList<>();
        }
    }
}
