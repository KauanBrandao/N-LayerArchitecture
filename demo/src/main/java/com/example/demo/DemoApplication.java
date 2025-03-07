package com.example.demo;

import com.example.demo.applications.LancheApplication;
import com.example.demo.entities.Lanche;
import com.example.demo.facade.LancheFacade;
import com.example.demo.repositories.LancheRepository;
import com.example.demo.services.LancheService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
    private static LancheRepository lancheRepository;
    private static LancheService lancheService;
    private static LancheApplication lancheApplication;
    private static LancheFacade lancheFacade;

    private static void injetarDependencias() {
        lancheRepository = new LancheRepository();
        lancheService = new LancheService();
        lancheApplication = new LancheApplication(lancheService, lancheRepository);
        lancheFacade = new LancheFacade(lancheApplication);
    }

    public static void main(String[] args) {
        injetarDependencias();
        Scanner scanner = new Scanner(System.in);
        int codigo = 1;
        boolean quit = false;

        while (!quit) {
            System.out.println("""
                    1 - Cadastrar lanche
                    2 - Atualizar lanche
                    3 - Excluir lanche
                    4 - Listar lanches
                    5 - Comprar lanche
                    6 - Sair
                    Escolha uma opção:""");

            int op = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (op) {
                case 1 -> {
                    System.out.println("Nome do lanche:");
                    String nome = scanner.nextLine();
                    System.out.println("Preço:");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.println("URL da imagem:");
                    String imgUrl = scanner.nextLine();

                    lancheFacade.cadastrar(new Lanche(codigo++, nome, preco, imgUrl));
                    System.out.println("Lanche cadastrado com sucesso!\n");
                }

                case 2 -> {
                    System.out.println("Digite o código do lanche a ser atualizado:");
                    int cod = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Novo nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Novo preço:");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Nova URL da imagem:");
                    String novaImagem = scanner.nextLine();

                    Lanche novoLanche = new Lanche(cod, nome, preco, novaImagem);
                    lancheFacade.atualizar(cod, novoLanche);
                    System.out.println("Lanche atualizado com sucesso!\n");
                }

                case 3 -> {
                    System.out.println("Digite o código do lanche a ser excluído:");
                    int cod = scanner.nextInt();
                    scanner.nextLine();

                    Lanche lanche = lancheFacade.buscarPorCodigo(cod);
                    if (lanche != null) {
                        lancheFacade.excluir(cod);
                        System.out.println("Lanche excluído com sucesso!\n");
                    } else {
                        System.out.println("Lanche não encontrado!\n");
                    }
                }

                case 4 -> {
                    System.out.println("--------------------------------------");
                    System.out.println("CÓDIGO\tNOME\t\tPREÇO");
                    System.out.println("--------------------------------------");
                    List<Lanche> lanches = lancheFacade.buscar();
                    for (Lanche l : lanches) {
                        System.out.println(l.getCodigo() + "\t\t" + l.getNome() + "\t\t" + l.getPreco());
                    }
                    System.out.println();
                }

                case 5 -> {
                    System.out.println("Digite o código do lanche:");
                    int cod = scanner.nextInt();
                    System.out.println("Digite a quantidade:");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();

                    Lanche lanche = lancheFacade.buscarPorCodigo(cod);
                    if (lanche != null) {
                        double total = lancheFacade.calcularLanche(lanche, qtd);
                        System.out.printf("Total: R$ %.2f\n\n", total);
                    } else {
                        System.out.println("Lanche não encontrado!\n");
                    }
                }

                case 6 -> quit = true;

                default -> System.out.println("Opção inválida! Tente novamente.\n");
            }
        }
        scanner.close();
    }
}
