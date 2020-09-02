package br.com.projetoIndividual;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {


    Carrinho carrinho = new Carrinho();

    @GetMapping("/inicio")
    public String exibirInfoLoja(){
        return "Olá, bem vindo a Loja de esportes do Matheus! Aqui temos produtos como " +
               "camisas de time, chuteiras, equipamentos esportivos e ainda contamos "   +
               "com um serviço de personais trainers! Acesse os endpoints abaixo, "      +
               "e compre o que desejar! \n" +
               "- Comprar camisetas de time: /comprar/camisetas \n" +
               "- Comprar chuteiras: /comprar/cuteiras \n" +
               "- Comprar equipamentos esportivos: /comprar/equipamentos \n" +
               "- Contratar serviço de personal trainer: /contratar/personalTrainer \n" +
               "- Exibir um item específico da lista: /verItem/{id} \n" +
               "- Exibir lista das compras: /lista \n" +
               "- Exibir total da compra: /total \n" +
               "- Excluir algum item do carrinho: /excluir/{id} \n";

    }

    @PostMapping("/comprar/camisetas")
    public String addItemCompra(@RequestBody CamisetasTime camiseta){
        carrinho.adicionaItemVenda(camiseta);
        return "Camiseta do time " + camiseta.getNomeTime() + " adiconada ao carrinho com sucesso!";
    }

    @PostMapping("/comprar/chuteiras")
    public String addItemCompra(@RequestBody Chuteiras chuteira){
        carrinho.adicionaItemVenda(chuteira);
        return "Chuteira da marca " +chuteira.getMarcaChuteira() + " adicionada ao carrinho com sucesso!";
    }

    @PostMapping("/comprar/equipamento")
    public String addItemCompra(@RequestBody EquipamentoEsportivo eqEsportivo){
        carrinho.adicionaItemVenda(eqEsportivo);
        return  eqEsportivo.getNomeEquipamento() + " adicionado ao carrinho com sucesso!";
    }

    @PostMapping("/contratar/personalTrainer")
    public String addItemCompra(@RequestBody PersonalTrainer personal){
        carrinho.adicionaItemVenda(personal);
        return  "Serviço do personal " + personal.getNomePersonal() + " adicionado ao carrinho com sucesso!";
    }

    @GetMapping("/verItem/{id}")
    public ItensVenda exibirItemSeparado(@PathVariable Integer id){
        return carrinho.recuperarItem(id);
    }

    @GetMapping("/lista")
    public List<ItensVenda> exibirItensCarrinho(){
        return carrinho.exibeCarrinho();
    }

    @GetMapping("/total")
    public String exibeTotalCompra(){
        carrinho.setTotal(0.00);
        carrinho.calculaTotalCompra();
        return  String.format("O total da sua compra foi de: R$ %.2f", carrinho.getTotal());
    }

    @DeleteMapping("/excluirItem/{id}")
    public void excluirItemLista(@PathVariable Integer id){
        carrinho.excluirItemVenda(id);
        carrinho.setTotal(0.00);
    }





}
