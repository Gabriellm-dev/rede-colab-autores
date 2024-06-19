import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Grafo grafo = new Grafo();
    private Centralidade centralidade = new Centralidade(grafo);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Explicação do projeto");
            System.out.println("2 - Adicionar autor");
            System.out.println("3 - Visualizar autores");
            System.out.println("4 - Adicionar colaboração");
            System.out.println("5 - Calcular medidas de centralidade BETWEENNESS");
            System.out.println("6 - Calcular medidas de centralidade CLOSENESS");
            System.out.println("7 - Calcular medidas de centralidade DEGREE");
            System.out.println("8 - Visualizar rede de colaboração (texto)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    explicarProjeto();
                    break;
                case 2:
                    adicionarAutor();
                    break;
                case 3:
                    visualizarAutores();
                    break;
                case 4:
                    adicionarColaboracao();
                    break;
                case 5:
                    calcularCentralidadeBetweenness();
                    break;
                case 6:
                    calcularCentralidadeCloseness();
                    break;
                case 7:
                    calcularCentralidadeDegree();
                    break;
                case 8:
                    visualizarRedeColaboracao();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void visualizarRedeColaboracao() {
        System.out.println("Rede de Colaboração:");
        for (Map.Entry<Autor, Set<Autor>> entry : grafo.getAdjList().entrySet()) {
            Autor autor = entry.getKey();
            Set<Autor> colaboradores = entry.getValue();

            System.out.print("- " + autor.getNome() + ": ");
            if (colaboradores.isEmpty()) {
                System.out.println("Não colabora com ninguém.");
            } else {
                List<String> nomesColaboradores = colaboradores.stream()
                        .map(Autor::getNome)
                        .collect(Collectors.toList());
                System.out.println("Colabora com " + String.join(", ", nomesColaboradores));
            }
        }
    }


    private void explicarProjeto() {
        System.out.println("Este projeto utiliza grafos para representar uma rede de colaboração entre autores. ...");
    }

    private void adicionarAutor() {
        System.out.print("Nome do autor: ");
        String nome = scanner.nextLine();
        Autor autor = new Autor(nome);
        grafo.adicionarAutor(autor);
        System.out.println("Autor " + nome + " adicionado.");
    }

    private void visualizarAutores() {
        Set<Autor> autores = grafo.getAutores();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
        } else {
            System.out.println("Autores cadastrados:");
            for (Autor autor : autores) {
                System.out.println("- " + autor.getNome());
            }
        }
    }

    private void adicionarColaboracao() {
        System.out.print("Nome do autor 1: ");
        String nome1 = scanner.nextLine();
        System.out.print("Nome do autor 2: ");
        String nome2 = scanner.nextLine();

        Autor autor1 = null;
        Autor autor2 = null;
        for (Autor autor : grafo.getAutores()) {
            if (autor.getNome().equals(nome1)) {
                autor1 = autor;
            }
            if (autor.getNome().equals(nome2)) {
                autor2 = autor;
            }
        }

        if (autor1 != null && autor2 != null) {
            grafo.adicionarColaboracao(autor1, autor2);
            System.out.println("Colaboração adicionada entre " + nome1 + " e " + nome2);
        } else {
            System.out.println("Um ou ambos os autores não foram encontrados.");
        }
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
