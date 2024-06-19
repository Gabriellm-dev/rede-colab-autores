import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {
    private Map<Autor, Set<Autor>> adjList;

    public Grafo() {
        this.adjList = new HashMap<>();
    }

    public void adicionarAutor(Autor autor){
        adjList.putIfAbsent(autor, new HashSet<>());
    }

    public void adicionarColaboracao(Autor autor1, Autor autor2) {
        adjList.putIfAbsent(autor1, new HashSet<>());
        adjList.putIfAbsent(autor2, new HashSet<>());
        adjList.get(autor1).add(autor2);
        adjList.get(autor2).add(autor1);
    }

    public Map<Autor, Set<Autor>> getAdjList() {
        return adjList;
    }

}
