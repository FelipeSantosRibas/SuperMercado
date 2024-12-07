/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DEV-T1
 */

import java.util.Scanner;

public class DVD extends Produto{
    //Variáveis
    private int duracao;
    private int faixaEtaria;
    
    //Construtor
    public DVD(int id, int index, float preco, String nome, String marca, int estoque, int duracao, int faixaEtaria){
        super(id, index, preco, nome, marca, estoque);
        this.duracao = duracao;
        this.faixaEtaria = faixaEtaria;
    }
    
    //Getters
    public int getDuracao(){
        return this.duracao;
    }
    public int getFaixaEtaria(){
        return this.faixaEtaria;
    }
    public String getEstudio(){
        return this.getMarca();
    }
    
    //Setters
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }
    public void setFaixaEtaria(int faixaEtaria){
        this.faixaEtaria = faixaEtaria;
    }
    public void setEstudio(String Marca){
        this.setMarca(Marca);
    }
    
    // To string
    public String toString() {
        return ("ID: " + this.getId()
                + "\nÍndice: " + this.getIndex()
                + "\nNome: " + this.getNome()
                + "\nEstúdio: " + this.getMarca()
                + "\nDuração (minutos): " + this.getDuracao()
                + "\nFaixa etária: " + this.getFaixaEtaria()
                + "\nPreço: " + this.getPreco()
                + "\nEstoque: " + this.getEstoque()
                + "\nValor do estoque: " + this.getEstoque() * this.getPreco()
                + "\nStatus: " + this.getAtivoString());
    }
    
    public static void adicionarProduto() {
        int tempId;
        int tempIndex;
        int tempDuracao;
        int tempFaixaEtaria;
        float tempPreco;
        String tempNome;
        String tempMarca;
        int tempEstoque;
        
        Scanner in = new Scanner(System.in);

        System.out.println("Insira o nome do DVD:");
        tempNome = in.nextLine();

        System.out.println("Insira o estúdio do DVD:");
        tempMarca = in.nextLine();
        
        System.out.println("Insira a duração do DVD (minutos):");
        tempDuracao = (int) Main.tryPositive("int");
        
        System.out.println("Insira a faixa etária do DVD:");
        do{
            tempFaixaEtaria = (int) Main.tryPositive("int");
            if ( tempFaixaEtaria > 18){
                 System.out.println("Por favor, insira uma faixa etária válida!");
            }
        } while( tempFaixaEtaria > 18);

        System.out.println("Insira o preço do DVD:");
        tempPreco = Main.tryPrice();

        System.out.println("Insira o ID do DVD:");
        tempId = (int) Main.tryPositive("int");

        System.out.println("Insira a quantidade em estoque do DVD:");
        tempEstoque = (int) Main.tryPositive("int");

        tempIndex = Main.produtos;
        Main.produtos++;

        Main.produto[tempIndex] = new DVD(tempId, tempIndex, tempPreco, tempNome, tempMarca, tempEstoque, tempDuracao, tempFaixaEtaria);
    }
}
