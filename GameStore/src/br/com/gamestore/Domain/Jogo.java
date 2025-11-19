package br.com.gamestore.Domain;

public class Jogo extends Produto{
    private String plataforma;

    public Jogo(String codigo, String nome, String descricao, double preco, int estoque, Categoria categoria, String plataforma) {
        super(codigo, nome, descricao, preco, estoque, categoria);
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public String toString(){
        return super.toString() + "(Jogo - "+ plataforma+ ")";
    }
}
