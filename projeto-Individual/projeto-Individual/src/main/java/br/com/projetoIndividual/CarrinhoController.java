package br.com.projetoIndividual;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CarrinhoController {


    Carrinho carrinho = new Carrinho();

    @GetMapping("/inicio")
    public ResponseEntity exibirInfoLoja(){
        return ResponseEntity.ok(
                "Olá, bem vindo a Loja de esportes do Matheus! Aqui temos produtos como " +
               "camisas de time, chuteiras, equipamentos esportivos e ainda contamos "   +
               "com um serviço de personais trainers! Acesse os endpoints abaixo, "      +
               "e compre o que desejar! \n" +
               "- Exibir lista das compras; \n" +
               "- Comprar camisetas de time: /camisetas \n" +
               "- Comprar chuteiras: /chuteiras \n" +
               "- Comprar equipamentos esportivos: /equipamentos \n" +
               "- Contratar serviço de personal trainer: /personalTrainers \n" +
               "- Exibir um item específico da lista: /{id} \n" +
               "- Excluir algum item do carrinho: /{id} \n" +
               "- Exibir total da compra: /total \n"
        );

    }
    @GetMapping
    public ResponseEntity exibirItensCarrinho(){
        return ResponseEntity.ok(carrinho.getCarrinho());
    }

    @PostMapping("/camisetas")
    public ResponseEntity comprarCamiseta(@RequestBody CamisetasTime camiseta){
        carrinho.adicionaItemVenda(camiseta);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/chuteiras")
    public ResponseEntity comprarChuteira(@RequestBody Chuteiras chuteira){
        carrinho.adicionaItemVenda(chuteira);
        System.out.println(chuteira.getMarcaChuteira());
        System.out.println(chuteira.getTamanhoChuteira());
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/equipamentos")
    public ResponseEntity comprarEquipamentoEsportivo(@RequestBody EquipamentoEsportivo eqEsportivo){
        carrinho.adicionaItemVenda(eqEsportivo);
        return  ResponseEntity.status(201).build();
    }

    @PostMapping("/personalTrainers")
    public ResponseEntity contratarPersonal(@RequestBody PersonalTrainer personal){
        carrinho.adicionaItemVenda(personal);
        return  ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity exibirItemEspecifico(@PathVariable Integer id){
        return (carrinho.getCarrinho().size() >= id) ?
                ResponseEntity.ok(carrinho.getItem(id))  :  ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirItemLista(@PathVariable Integer id){
        if(carrinho.getCarrinho().size() >= id) {
            carrinho.excluirItemVenda(id);
            carrinho.setTotal(0.00);
            return ResponseEntity.status(200).build();
        } else {
            System.out.println(carrinho.getCarrinho().size());
            return ResponseEntity.status(404).build();

        }
    }

    @GetMapping("/total")
    public ResponseEntity exibeTotalCompra(){
        carrinho.setTotal(0.00);
        carrinho.calculaTotalCompra();
        return ResponseEntity.ok(String.format("O total da sua compra foi de: R$ %.2f", carrinho.getTotal()));
    }

}
