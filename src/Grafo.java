import java.util.*;

public class Grafo {
    private Map<Autor, Set<Autor>> adjList;

    public Grafo() {
        this.adjList = new HashMap<>();
    }

    public void adicionarAutor(Autor autor) {
        adjList.putIfAbsent(autor, new HashSet<>());
    }

    public void adicionarColaboracao(Autor autor1, Autor autor2) {
        if (adjList.containsKey(autor1) && adjList.containsKey(autor2)) {
            adjList.get(autor1).add(autor2);
            adjList.get(autor2).add(autor1);
        } else {
            System.out.println("Um ou ambos os autores não existem.");
        }
    }

    public Set<Autor> getAutores() {
        return adjList.keySet();
    }

    public Map<Autor, Set<Autor>> getAdjList() {
        return adjList;
    }
}
