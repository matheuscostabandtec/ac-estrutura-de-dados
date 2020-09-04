package br.com.projetoIndividual;

public class Chuteiras extends Itens {

    private String marcaChuteira;
    private Integer tamanhoChuteira; // 40, 41, 42, 43 etc

    public Chuteiras(Integer codigoItem, Integer qtdItem, Double valorItem, String marcaChuteira, Integer tamanhoChuteira) {
        super(codigoItem, qtdItem, valorItem);
        this.marcaChuteira = marcaChuteira;
        this.tamanhoChuteira = tamanhoChuteira;
    }

    @Override
    public Double getValorCompra() {
        return (super.getValorItem() * super.getQtdItem()) * 1.20;
    }

    public String getMarcaChuteira() {
        return marcaChuteira;
    }

    public Integer getTamanhoChuteira() {
        return tamanhoChuteira;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\n Chuteiras: " +
                "\n Marca: " + marcaChuteira +
                "\n Tamanho: " + tamanhoChuteira +
                "\n Valor de venda: " + String.format("R$ %.2f", getValorCompra());
    }
}
