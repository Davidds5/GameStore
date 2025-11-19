package br.com.gamestore.Domain;

public class Acessorio extends Produto {
    private String tipo;

    public Acessorio(String codigo, String nome, String descricao, double preco, int estoque, Categoria categoria, String tipo) {
        super(codigo, nome, descricao, preco, estoque, categoria);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String toString(){
        return super.toString()+"(Acessorio - "+tipo+")";
    }

}
