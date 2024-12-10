
import java.util.Scanner;


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

    public Produto(int id, int index, float preco, String nome, int estoque) {
        this.id = id;
        this.index = index;
        this.nome = nome;
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
        return ("Produto:"
                +"\nID: " + this.getId()
                + "\nÍndice: " + this.getIndex()
                + "\nNome: " + this.getNome()
                + "\nMarca: " + this.getMarca()
                + "\nPreço: " + this.getPreco()
                + "\nEstoque: " + this.getEstoque()
                + "\nValor do estoque: " + this.getEstoque() * this.getPreco()
                + "\nStatus: " + this.getAtivoString());
    }

    public static void adicionarProduto() {
        int tempId;
        int tempIndex;
        float tempPreco;
        String tempNome;
        String tempMarca;
        int tempEstoque;
        
        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome do produto:");
        tempNome = in.nextLine();

        System.out.println("Insira a marca do produto:");
        tempMarca = in.nextLine();

        System.out.println("Insira o preço do produto:");
        tempPreco = Main.tryPrice();

        System.out.println("Insira o ID do produto:");
        tempId = (int) Main.tryPositive("int");

        System.out.println("Insira a quantidade em estoque do produto:");
        tempEstoque = (int) Main.tryPositive("int");

        tempIndex = Main.produtos;
        Main.produtos++;

        Main.produto[tempIndex] = new Produto(tempId, tempIndex, tempPreco, tempNome, tempMarca, tempEstoque);
    }
}
