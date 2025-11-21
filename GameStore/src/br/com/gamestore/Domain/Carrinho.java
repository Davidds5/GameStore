package br.com.gamestore.Domain;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private final String id;
    private final Cliente cliente;
    private final List<ItemCarrinho> itens = new ArrayList<>();


    public Carrinho(String id, Cliente cliente){
        this.id = id;
        this.cliente = cliente;
    }
    public String getId(){
        return id;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public List<ItemCarrinho> getItens(){
        return itens;
    }
    // adiciona item(Produto, quantidade), argumento,
    public void adicionarItem(Produto produto, int qtd) {
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getCodigo().equalsIgnoreCase(produto.getCodigo())) {
                item.setQuantidade(item.getQuantidade() + qtd);
                return;
            }
        }

        itens.add(new ItemCarrinho(produto, qtd));
    }
    public void removerItem(int codigoProduto){
        itens.removeIf(item ->item.getProduto().getCodigo().equals(codigoProduto));
    }
    public double total(){
        return itens.stream().mapToDouble(ItemCarrinho::subTotal).sum();
    }
    public boolean estaVazio(){
      return itens.isEmpty();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("Carrinho: "+id+" - Cliente: "+cliente.getNome()+
                "\n");
        for(ItemCarrinho item : itens)sb.append(item).append("\n");
        sb.append(String.format("Total: R$%.2f", total()));
        return sb.toString();

    }

}
