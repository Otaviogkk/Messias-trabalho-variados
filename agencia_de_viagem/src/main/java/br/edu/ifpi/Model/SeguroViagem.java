package br.edu.ifpi.Model;
import br.edu.ifpi.*;


public class SeguroViagem implements ServicoContratavel {
    private String seguradora;
    private String tipoCobertura;
    private double preco;
    private String nomeServico;

    public void setSeguradora(String seguradora) {
        this.seguradora = seguradora;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String servicoContratado(String nomeServico) {
        this.nomeServico = nomeServico;
        return this.nomeServico;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricaoServico() {
        return "Seguro Viagem (" + tipoCobertura + ") - Seguradora: " + seguradora;
    }
}
