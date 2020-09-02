package br.com.projetoIndividual;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<ItensVenda> carrinho;
    private Double total;

    public Carrinho() {
        this.carrinho = new ArrayList<>();
        this.total = 0.00;
    }

    public void adicionaItemVenda(ItensVenda item){
        carrinho.add(item);
    }

    public void excluirItemVenda(Integer codigo){
        carrinho.remove(codigo-1);
    }

    public void calculaTotalCompra(){
        for(ItensVenda item: carrinho){
            total += item.getValorCompra();
        }
    }

    public List<ItensVenda> exibeCarrinho(){
        return carrinho;
    }

    public ItensVenda recuperarItem(Integer id){
       return carrinho.get(id-1);
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
