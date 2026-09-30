package br.edu.ifpi.Model;




public class CartaoCredito implements MetodoPagamento {
  private String numeroCartao;
  private String nomeTitular;

  public String getNumeroCartao() {
    return numeroCartao;
  }
  public void setNumeroCartao(String numeroCartao) {
    this.numeroCartao = numeroCartao;
  }
  public String getNomeTitular() {
    return nomeTitular;
  }
  public void setNomeTitular(String nomeTitular) {
    this.nomeTitular = nomeTitular;
  }

  @Override
  public boolean validarPagamento() {
    if (numeroCartao == null || numeroCartao.length() != 16) {
      System.out.println("Erro: O nÃºmero do Cartão deve conter exatamente 16 digito.");
      return false;
    }
    if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
      System.out.println("Erro: O nome do titular do Cartão não pode estar vazio.");
      return false;
    }
    return true;
  }

  @Override
  public boolean processarPagamento(double valor) {
    if (!validarPagamento()) {
      System.out.println("Falha ao processar pagamento: Dados do cartão invalido.");
      return false;
    }
    System.out.println("Pagamento de R$ " + valor + " realizado com Cartão de Credito com final " + numeroCartao.substring(numeroCartao.length() -4));
    return true;
  }

  @Override
  public String getDescricao() {
    return "Cartão de Credito - Titular: " + this.nomeTitular;
  }
}
