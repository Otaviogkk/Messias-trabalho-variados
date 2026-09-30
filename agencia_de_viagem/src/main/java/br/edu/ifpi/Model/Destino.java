package br.edu.ifpi.Model;
public class Destino {
    private String nome;
    private String pais;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public String getDescricao() {
        return "Destino: " + nome + ", Pai­s: " + pais;
    }
}
