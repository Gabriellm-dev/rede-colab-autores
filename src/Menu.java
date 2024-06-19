import java.util.*;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Grafo grafo = new Grafo();
    private Centralidade centralidade = new Centralidade(grafo);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Explicação do projeto");
            System.out.println("2 - Adicionar autores");
            System.out.println("3 - Calcular medidas de centralidade BETWEENNESS");
            System.out.println("4 - Calcular medidas de centralidade CLOSENESS");
            System.out.println("5 - Calcular medidas de centralidade DEGREE");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    explicarProjeto();
                    break;
                case 2:
                    adicionarAutores();
                    break;
                case 3:
                    calcularCentralidadeBetweenness();
                    break;
                case 4:
                    calcularCentralidadeCloseness();
                    break;
                case 5:
                    calcularCentralidadeDegree();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void explicarProjeto() {
        System.out.println("Este projeto utiliza grafos para representar uma rede de colaboração entre autores. ...");
    }

    private void adicionarAutores() {
        System.out.print("Nome do autor 1: ");
        String nome1 = sc.nextLine();
        System.out.print("Nome do autor 2: ");
        String nome2 = sc.nextLine();

        Autor autor1 = new Autor(nome1);
        Autor autor2 = new Autor(nome2);

        grafo.adicionarAutor(autor1);
        grafo.adicionarAutor(autor2);
        grafo.adicionarColaboracao(autor1, autor2);

        System.out.println("Colaboração adicionada entre " + nome1 + " e " + nome2);
    }

    private void calcularCentralidadeBetweenness() {
        Map<Autor, Double> centralidadeBetweenness = centralidade.calcularCentralidadeBetweenness();
        System.out.println("Centralidade Betweenness:");
        for (Map.Entry<Autor, Double> entry : centralidadeBetweenness.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue());
        }
    }

    private void calcularCentralidadeCloseness() {
        Map<Autor, Double> centralidadeCloseness = centralidade.calcularCentralidadeCloseness();
        System.out.println("Centralidade Closeness:");
        for (Map.Entry<Autor, Double> entry : centralidadeCloseness.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue());
        }
    }

    private void calcularCentralidadeDegree() {
        Map<Autor, Integer> centralidadeGrau = centralidade.calcularCentralidadeGrau();
        System.out.println("Centralidade Degree:");
        for (Map.Entry<Autor, Integer> entry : centralidadeGrau.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue());
        }
    }
}
