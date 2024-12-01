/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
import java.util.Scanner;

public class Main {

    public static int produtos = 0;
    public static Produto produto[] = new Produto[100];

    //Método main
    public static void main(String[] args) {
        int temp;

        produto[produtos] = new Produto(12345, produtos, 0, "Default", "Default", 0);
        produtos++;

        do {
            System.out.println("Bem vindo ao gerenciador de produtos! \n");
            System.out.println("Que ação deseja realizar?");
            System.out.println("[1] Adicionar produtos");
            System.out.println("[2] Visualizar produtos");
            System.out.println("[3] Modificar produtos");
            System.out.println("[0] Encerrar sessão");

            do {
                temp = tryInt();
                if (temp < 0 || temp > 3) {
                    System.out.println("Por favor, insira uma opção válida.");
                }
            } while (temp < 0 || temp > 3);

            switch (temp) {
                case 0 -> {
                }
                case 1 ->
                    adicionarProdutos();
                case 2 ->
                    visualizarProdutos();
                case 3 ->
                    modificarProdutos();
                default ->
                    System.out.println("Esta função ainda está em desenvolvimento!\n");
            }
        } while (temp != 0);
    }

    //Métodos try
    public static int tryInt() {
        Scanner in = new Scanner(System.in);
        int temp = 0;
        boolean erro;

        do {
            erro = false;
            try {
                temp = in.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, insira um número inteiro.");
                erro = true;
            }
            in.nextLine();
        } while (erro == true);
        return temp;
    }

    public static float tryFloat() {
        Scanner in = new Scanner(System.in);
        float temp = 0;
        boolean erro;

        do {
            erro = false;
            try {
                temp = in.nextFloat();
            } catch (Exception e) {
                System.out.println("Por favor, insira um número válido.");
                erro = true;
            }
            in.nextLine();
        } while (erro == true);
        return temp;
    }

    public static double tryPositive(String type) {
        double temp = 0;

        do {

            try { // Verefica se o tipo de dado é válido
                if (!type.equals("int") && !type.equals("float")) {
                    throw new Exception("Invalid data type");
                }
            } catch (Exception e) {
            }

            switch (type) { // Pede um número de acordo com o tipo de dado
                case "int" -> {
                    temp = tryInt();
                }
                case "float" -> {
                    temp = tryFloat();
                }
            }

            if (temp < 0) { // verifica se o número é positivo
                System.out.println("Por favor, insira um número positivo.");
            }
        } while (temp < 0);

        return temp;
    }

    public static float tryPrice() {
        return ((float)((int)((float) tryPositive("float")  * 100))/100); // corta 2 zeros
    }

    //Gerenciador de produtos
    public static void adicionarProdutos() {
        int tempId;
        int tempIndex;
        float tempPreco;
        String tempNome;
        String tempMarca;
        int tempEstoque;
        int quantidade;

        Scanner in = new Scanner(System.in);

        System.out.println("Quantos produtos deseja inserir?");

        do {
            quantidade = tryInt();
            if (quantidade < 0) {
                System.out.println("Insira um número válido.");
            }
        } while (quantidade < 0);

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Insira o nome do produto:");
            tempNome = in.nextLine();

            System.out.println("Insira a marca do produto:");
            tempMarca = in.nextLine();

            System.out.println("Insira o preço do produto:");
            tempPreco = tryPrice();

            System.out.println("Insira o ID do produto:");
            tempId = (int) tryPositive("int");

            System.out.println("Insira a quantidade em estoque do produto:");
            tempEstoque = (int) tryPositive("int");

            tempIndex = produtos;
            produtos++;

            produto[tempIndex] = new Produto(tempId, tempIndex, tempPreco, tempNome, tempMarca, tempEstoque);

            System.out.println(produto[tempIndex].toString());

            System.out.println();
        }
    }

    public static void visualizarProdutos() {
        String resposta;
        int index;
        boolean erro;

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\nDigite o índice do produto que deseja visualizar:");
            System.out.println("(Digite \"sair\" para retornar ao gerenciador de produtos).");
            do {
                resposta = in.nextLine().toUpperCase();
                erro = false;
                if (!resposta.equals("SAIR")) {
                    try {
                        index = Integer.parseInt(resposta);
                        System.out.println("\n" + produto[index].toString());
                    } catch (Exception e) {
                        System.out.println("Não existe um produto com este índice.");
                        erro = true;
                    }
                }
            } while (erro == true);
        } while (!resposta.equals("SAIR"));
    }

    public static void modificarProdutos() {
        String resposta, resposta2, resposta4;
        int resposta3 = -1;
        int index;
        boolean erro;

        Scanner in = new Scanner(System.in);

        do {
            do {
                System.out.println("\nDigite o índice do produto que deseja modificar:"); // Pergunta qual produto deseja modificar
                System.out.println("(Digite \"sair\" para retornar ao gerenciador de produtos).\n");
                resposta = in.nextLine().toUpperCase();
                erro = false;

                if (!resposta.equals("SAIR")) { // indica um produto para modificar

                    try {
                        index = Integer.parseInt(resposta);

                        System.out.println("\n" + produto[index].toString() + "\nDeseja modificar esse produto? (s/n):"); // pergunta se haverá modificação

                        do {
                            resposta2 = in.nextLine().toUpperCase();
                            switch (resposta2) {
                                case "S" -> { // Caso confirme que haverá modificação

                                    System.out.println("\nOque deseja modificar neste produto?" // Pergunta oque será modificado
                                            + "\n[0] Nada"
                                            + "\n[1] ID"
                                            + "\n[2] Nome"
                                            + "\n[3] Marca"
                                            + "\n[4] Preco"
                                            + "\n[5] Estoque"
                                            + "\n[6] Status");

                                    do {    // Verifica se é uma resposta válida
                                        try {
                                            resposta3 = tryInt();
                                        } catch (Exception e) {
                                            System.out.println("\nPor favor, insira um número inteiro.\n");
                                        }
                                        if (resposta3 != 0 && resposta3 != 1 && resposta3 != 2 && resposta3 != 3
                                                && resposta3 != 4 && resposta3 != 5 && resposta3 != 6) {
                                            System.out.println("\nPor favor, insira uma resposta válida.\n");
                                        }
                                    } while (resposta3 != 0 && resposta3 != 1 && resposta3 != 2 && resposta3 != 3
                                            && resposta3 != 4 && resposta3 != 5 && resposta3 != 6);

                                    if (resposta3 == 0) { // Realiza a ação dependendo da resposta
                                        System.out.println("\nNada foi alterado!");
                                    } else {
                                        System.out.println("\nInsira o valor da alteração:");
                                        switch (resposta3) {
                                            case 1 -> { // Alterar ID
                                                produto[index].setId((int) tryPositive("int"));

                                            }
                                            case 2 -> { // Alterar Nome
                                                produto[index].setNome(in.nextLine());

                                            }
                                            case 3 -> { // Alterar Marca
                                                produto[index].setMarca(in.nextLine());

                                            }
                                            case 4 -> { // Alterar Preço
                                                produto[index].setPreco(tryPrice());

                                            }
                                            case 5 -> { // Alterar Estoque
                                                produto[index].setEstoque((int) tryPositive("int"));

                                            }
                                            case 6 -> { // Alterar Status
                                                System.out.println("(ativo / descontinuado)");
                                                do { // Verifica se a resposta é válida
                                                    resposta4 = in.nextLine().toUpperCase();
                                                    if (!resposta4.equals("ATIVO") && !resposta4.equals("DESCONTINUADO")) {
                                                        System.out.println("Por favor, insira uma resposta válida.");
                                                    }
                                                } while (!resposta4.equals("ATIVO") && !resposta4.equals("DESCONTINUADO"));

                                                if (resposta4.equals("ATIVO")) {
                                                    produto[index].setAtivo(true);
                                                } else {
                                                    produto[index].setAtivo(false);
                                                }
                                            }
                                        }
                                        System.out.println("\nProduto alterado com sucesso!");
                                    }
                                    resposta2 = "N";
                                }

                                case "N" -> { // Caso não tenha modificação
                                }
                                default -> // Caso seja uma reposta inválida
                                    System.out.println("Por favor, insira uma resposta válida.");
                            }
                        } while (!resposta2.equals("N"));
                    } catch (Exception e) { // Caso seja uma resposta errada
                        System.out.println("Não existe um produto com este índice.");
                        erro = true;
                    }
                }
            } while (erro == true);
        } while (!resposta.equals("SAIR"));
    }
}
