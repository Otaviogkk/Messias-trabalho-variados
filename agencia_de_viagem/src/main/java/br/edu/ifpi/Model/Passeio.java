package br.edu.ifpi.Model;

public class Passeio implements ServicoContratavel {
    private String nomePasseio;
    private double precoPasseio;
    private String nomeServico;

    public Passeio() {
    }

    public Passeio(String nomePasseio, double precoPasseio) {
        this.nomePasseio = nomePasseio;
        this.precoPasseio = precoPasseio;
    }

    public String getNomePasseio() {
        return nomePasseio;
    }

    public void setNomePasseio(String nomePasseio) {
        this.nomePasseio = nomePasseio;
    }

    public double getPrecoPasseio() {
        return precoPasseio;
    }

    public void setPrecoPasseio(double precoPasseio) {
        this.precoPasseio = precoPasseio;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    @Override
    public String servicoContratado(String nomeServico) {
        this.nomeServico = nomeServico;
        return this.nomeServico;
    }

    @Override
    public double getPreco() {
        return precoPasseio;
    }

    @Override
    public String getDescricaoServico() {
        return "Passeio: " + (nomePasseio != null ? nomePasseio : "");
    }
}
