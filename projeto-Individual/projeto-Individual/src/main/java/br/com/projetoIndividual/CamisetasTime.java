package br.com.projetoIndividual;

public class CamisetasTime extends Itens {

    private String nomeTime;
    private String tamanhoCamiseta; // P, M, G, GG etc.

    public CamisetasTime(Integer codigoItem, Integer qtdItem, Double valorItem, String nomeTime, String tamanhoCamiseta) {
        super(codigoItem, qtdItem, valorItem);
        this.nomeTime = nomeTime;
        this.tamanhoCamiseta = tamanhoCamiseta;
    }

    @Override
    public Double getValorCompra() {
        return (super.getValorItem() * super.getQtdItem()) * 1.50;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getTamanhoCamiseta() {
        return tamanhoCamiseta;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                "\n CamisasTime: " +
                "\n Nome do time: " + nomeTime + '\'' +
                "\n Tamanho da camisa: " + tamanhoCamiseta +
                "\n Valor de venda: " + String.format("R$ %.2f", getValorCompra());
    }
}
