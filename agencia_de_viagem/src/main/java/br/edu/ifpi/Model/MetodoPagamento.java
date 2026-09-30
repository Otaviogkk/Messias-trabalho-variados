package br.edu.ifpi.Model;
public interface MetodoPagamento {
    boolean processarPagamento(double valor);
    boolean validarPagamento();
    String getDescricao();
}
