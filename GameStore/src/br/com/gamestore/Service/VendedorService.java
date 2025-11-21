package br.com.gamestore.Service;

import br.com.gamestore.Domain.Carrinho;
import br.com.gamestore.Domain.ItemCarrinho;
import br.com.gamestore.Domain.Produto;
import br.com.gamestore.Exceptions.EstoqueInsuficiente;
import br.com.gamestore.Exceptions.ProdutoNaoEncotrado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VendedorService {
    private final ProdutoService produtoService;
    private final List<String> vendas = new ArrayList<>();

    public VendedorService(ProdutoService produtoService){
        this.produtoService = produtoService;
    }
    public String finalizarVendas(Carrinho carrinho)throws ProdutoNaoEncotrado, EstoqueInsuficiente {
        if (carrinho.estaVazio())throw new IllegalArgumentException("Carringo vazio");

        for (ItemCarrinho itemCarrinho : carrinho.getItens()){
            Produto p = produtoService.buscaProduto(itemCarrinho.getProduto().getCodigo());
            p.reduzirEstoque(itemCarrinho.getQuantidade());

            String nota = gerarNota(carrinho);
            vendas.add(nota);

            carrinho.getCliente().adicionarHistorico(nota);
            return nota;
        }
        private String geraNota(Carrinho carrinho){
            String idVenda = UUID.randomUUID().toString().substring(0,8);
            StringBuilder sb = new StringBuilder();
            sb.append("===NOTA DE VENDA===");
            sb.append("ID Venda: ").append(idVenda).append("\n");
            sb.append("Cliente: ").append(carrinho.getCliente().getNome()).append("\n");
            sb.append("Data: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyy-MM-ddHH:mm"))).append("\n");
            sb.append("-----------------------------------------------------------\n");
            for (ItemCarrinho item : carrinho.getItens()){
                sb.append(item.getProduto().getNome()).append("x").append(item.getQuantidade()).append("= R$").append(String.format("%.2f", item.subTotal())).append("\n");

                sb.append("_______________________________________________________________\n");
                return sb.toString();
                
            }
            public List<String > getHistoricoVendas(){
                return vendas;
            }
        }

    }
}
