
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DEV-T1
 */
public class CD extends Produto {

    //Variáveis
    private String artista;
    private String gravadora;
    private int numeroDeMusicas;

    //Construtor
    public CD(int id, int index, float preco, String nome, int estoque, String artista, String gravadora, int numeroDeMusicas) {
        super(id, index, preco, nome, estoque);
        this.artista = artista;
        this.gravadora = gravadora;
        this.numeroDeMusicas = numeroDeMusicas;
    }

    //Getters
    public String getArtista() {
        return this.artista;
    }

    public String getGravadora() {
        return this.gravadora;
    }

    public int getNumeroDeMusicas() {
        return this.numeroDeMusicas;
    }

    //Setters
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    public void setNumeroDeMusicas(int numeroDeMusicas) {
        this.numeroDeMusicas = numeroDeMusicas;
    }

    // To string
    public String toString() {
        return ("ID: " + this.getId()
                + "\nÍndice: " + this.getIndex()
                + "\nNome: " + this.getNome()
                + "\nArtista: " + this.getArtista()
                + "\nGravadora: " + this.getGravadora()
                + "\nNúmero de Músicas: " + this.getNumeroDeMusicas()
                + "\nPreço: " + this.getPreco()
                + "\nEstoque: " + this.getEstoque()
                + "\nValor do estoque: " + 1.05 * (this.getEstoque() * this.getPreco())
                + "\nStatus: " + this.getAtivoString());
    }
    
    public static void adicionarProduto() {
        int tempId;
        int tempIndex;
        float tempPreco;
        String tempNome;
        String tempArtista;
        String tempGravadora;
        int tempNumeroDeMusicas;
        int tempEstoque;
        
        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome do CD:");
        tempNome = in.nextLine();

        System.out.println("Insira o artista do CD:");
        tempArtista = in.nextLine();
        
        System.out.println("Insira a gravadora do CD:");
        tempGravadora = in.nextLine();
        
        System.out.println("Insira o número de músicas do CD:");
        tempNumeroDeMusicas = (int) Main.tryPositive("int");

        System.out.println("Insira o preço do CD:");
        tempPreco = Main.tryPrice();

        System.out.println("Insira o ID do CD:");
        tempId = (int) Main.tryPositive("int");

        System.out.println("Insira a quantidade em estoque do CD:");
        tempEstoque = (int) Main.tryPositive("int");

        tempIndex = Main.produtos;
        Main.produtos++;

        Main.produto[tempIndex] = new CD(tempId, tempIndex, tempPreco, tempNome, tempEstoque, tempArtista, tempGravadora, tempNumeroDeMusicas);
    }
}
