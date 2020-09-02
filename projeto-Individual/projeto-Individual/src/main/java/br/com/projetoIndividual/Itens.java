package br.com.projetoIndividual;

public abstract class Itens implements ItensVenda {

    private Integer codigoItem;
    private Double valorItem;
    private Integer qtdItem;

    public Itens(Integer codigoItem, Integer qtdItem, Double valorItem) {
        this.codigoItem = codigoItem;
        this.qtdItem = qtdItem;
        this.valorItem = valorItem;
    }
    public Integer getCodigoItem() {
        return codigoItem;
    }

    public Integer getQtdItem() {
        return qtdItem;
    }

    public Double getValorItem() {
        return valorItem;
    }

    @Override
    public String toString() {
        return "\n Produto: " +
                "\n Codigo do produto: " + codigoItem +
                "\n Qtd do produto: " + qtdItem +
                "\n Preço: " + valorItem;
    }
}
