package br.edu.ifpi.Model;

import br.edu.ifpi.*;

import java.time.LocalDate;

public class Hospedagem implements ServicoContratavel {
    private String hotel;
    private int diarias;
    private double precoPorNoite;
    private LocalDate dataCheckin;
    private LocalDate dataCheckout;

    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckout(LocalDate dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public LocalDate getDataCheckout() {
        return dataCheckout;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }

    public void setPrecoPorNoite(double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    @Override
    public String servicoContratado(String nomeServico) {
        return nomeServico;
    }

    @Override
    public double getPreco() {
        return diarias * precoPorNoite;
    }

    @Override
    public String getDescricaoServico() {
        return "Hospedagem no " + hotel + " (" + diarias + " diarias)";
    }
}
