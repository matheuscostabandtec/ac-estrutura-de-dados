package br.com.projetoIndividual;

public class Chuteiras extends Itens {

    private String marca;
    private Integer tamanho; // 40, 41, 42, 43 etc

    public Chuteiras(Integer codigoProduto, Integer qtdProduto, Double valorProduto, String marca, Integer tamanho) {
        super(codigoProduto, qtdProduto, valorProduto);
        this.marca = marca;
        this.tamanho = tamanho;
    }

    @Override
    public Double getValorCompra() {
        return (super.getValorItem() * super.getQtdItem()) * 1.20;
    }

    public String getMarcaChuteira() {
        return marca;
    }

    public Integer getTamanhoChuteira() {
        return tamanho;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\n Chuteiras: " +
                "\n Marca: " + marca +
                "\n Tamanho: " + tamanho +
                "\n Valor de venda: " + String.format("R$ %.2f", getValorCompra());
    }
}
