
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author USER
 */
public class Produto {

    // Variáveis
    private int id;
    private int index;
    private String nome;
    private String marca;
    private float preco;
    private int estoque;
    private boolean ativo;

    // Construtores
    public Produto() {
    }

    public Produto(int id, int index, float preco, String nome, String marca, int estoque) {
        this.id = id;
        this.index = index;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.estoque = estoque;
        this.ativo = true;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public float getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public String getAtivoString() {
        return ativo ? "Ativo" : "Descontinuado";
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(float preco) {
        this.preco = ((float) ((int) ((float) preco * 100)) / 100);
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // To string
    public String toString() {
        return ("ID: " + this.getId()
                + "\nÍndice: " + this.getIndex()
                + "\nNome: " + this.getNome()
                + "\nMarca: " + this.getMarca()
                + "\nPreço: " + this.getPreco()
                + "\nEstoque: " + this.getEstoque()
                + "\nValor do estoque: " + this.getEstoque() * this.getPreco()
                + "\nStatus: " + this.getAtivoString());
    }
}
