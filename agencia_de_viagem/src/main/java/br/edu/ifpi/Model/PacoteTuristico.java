package br.edu.ifpi.Model;
import br.edu.ifpi.*;

import java.util.ArrayList;
import java.util.List;

public class PacoteTuristico {
    private String nomePacote;
    private List<ServicoContratavel> servicos = new ArrayList<>();
    
    public void setNomePacote(String nomePacote) {
        this.nomePacote = nomePacote;
    }
    public void adicionarServico(ServicoContratavel servico) {
        servicos.add(servico);
    }
    public String getNomePacote() {
        return nomePacote;
    }
    public void setServicos(List<ServicoContratavel> servicos) {
        this.servicos = servicos;
    }
    public List<ServicoContratavel> getServicos() {
        return servicos;
    }
    public double getPrecoTotal() {
        double total = 0;
        for (ServicoContratavel servico : servicos) {
            total += servico.getPreco();
        }
        return total;
    }
    public String getDescricao() {
        String descricao = "Pacote: " + nomePacote + "\n";
        for (ServicoContratavel servico : servicos) {
            descricao += "- " + servico.getDescricaoServico() + "\n";
        }
        descricao += "Preço Total: R$ " + getPrecoTotal();
        return descricao;
    }
}
