package br.edu.ifpi.Model;
import br.edu.ifpi.*;

import java.time.LocalDate;

public class Voo implements ServicoContratavel {
    private String companhiaAerea;
    private String origem;
    private Destino destinoVoo;
    private double precoPassagem;
    private String nomeServico;
    private LocalDate dataIda;
    private LocalDate dataVolta;

    public void setDataIda(LocalDate dataIda) {
        this.dataIda = dataIda;
    }

    public LocalDate getDataIda() {
        return dataIda;
    }

    public void setDataVolta(LocalDate dataVolta) {
        this.dataVolta = dataVolta;
    }

    public LocalDate getDataVolta() {
        return dataVolta;
    }



    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Destino getDestinoVoo() {
        return destinoVoo;
    }

    public void setDestinoVoo(Destino destinoVoo) {
        this.destinoVoo = destinoVoo;
    }

    public double getPrecoPassagem() {
        return precoPassagem;
    }

    public void setPrecoPassagem(double precoPassagem) {
        this.precoPassagem = precoPassagem;
    }

    @Override
    public String servicoContratado(String nomeServico){
        return this.nomeServico = nomeServico; 
    }

    @Override
    public double getPreco() {
        return precoPassagem;
    }

    @Override
    public String getDescricaoServico() {
        return "Voo: " + origem + " para " + destinoVoo.getNome() + " (" + companhiaAerea + ")";
    }
}
