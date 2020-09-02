package br.com.projetoIndividual;

public class CamisetasTime extends Itens {

    private String nomeTime;
    private String tamanhoCamisa; // P, M, G, GG etc.

    public CamisetasTime(Integer codigoProduto, Integer qtdProduto, Double valorProduto, String nomeTime, String tamanhoCamisa) {
        super(codigoProduto, qtdProduto, valorProduto);
        this.nomeTime = nomeTime;
        this.tamanhoCamisa = tamanhoCamisa;
    }

    @Override
    public Double getValorCompra() {
        return (super.getValorItem() * super.getQtdItem()) * 1.50;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getTamanhoCamisa() {
        return tamanhoCamisa;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                "\n CamisasTime: " +
                "\n Nome do time: " + nomeTime + '\'' +
                "\n Tamanho da camisa: " + tamanhoCamisa +
                "\n Valor de venda: " + String.format("R$ %.2f", getValorCompra());
    }
}
