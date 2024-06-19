import java.util.*;

public class Centralidade {
    private Grafo grafo;

    public Centralidade(Grafo grafo) {
        this.grafo = grafo;
    }

    public Map<Autor, Integer> calcularCentralidadeGrau() {
        Map<Autor, Integer> centralidadeGrau = new HashMap<>();
        for (Autor autor : grafo.getAdjList().keySet()) {
            centralidadeGrau.put(autor, grafo.getAdjList().get(autor).size());
        }
        return centralidadeGrau;
    }

    public Map<Autor, Double> calcularCentralidadeBetweenness() {
        Map<Autor, Double> centralidadeBetweenness = new HashMap<>();
        for (Autor autor : grafo.getAdjList().keySet()) {
            centralidadeBetweenness.put(autor, 0.0);
        }

        for (Autor s : grafo.getAdjList().keySet()) {
            Stack<Autor> stack = new Stack<>();
            Map<Autor, List<Autor>> predecessors = new HashMap<>();
            Map<Autor, Integer> sigma = new HashMap<>();
            Map<Autor, Integer> dist = new HashMap<>();
            Queue<Autor> queue = new LinkedList<>();

            for (Autor t : grafo.getAdjList().keySet()) {
                predecessors.put(t, new ArrayList<>());
                sigma.put(t, 0);
                dist.put(t, -1);
            }
            sigma.put(s, 1);
            dist.put(s, 0);
            queue.add(s);

            while (!queue.isEmpty()) {
                Autor v = queue.poll();
                stack.push(v);
                for (Autor w : grafo.getAdjList().get(v)) {
                    if (dist.get(w) < 0) {
                        queue.add(w);
                        dist.put(w, dist.get(v) + 1);
                    }
                    if (dist.get(w) == dist.get(v) + 1) {
                        sigma.put(w, sigma.get(w) + sigma.get(v));
                        predecessors.get(w).add(v);
                    }
                }
            }

            Map<Autor, Double> delta = new HashMap<>();
            for (Autor t : grafo.getAdjList().keySet()) {
                delta.put(t, 0.0);
            }

            while (!stack.isEmpty()) {
                Autor w = stack.pop();
                for (Autor v : predecessors.get(w)) {
                    delta.put(v, delta.get(v) + (sigma.get(v) / (double) sigma.get(w)) * (1 + delta.get(w)));
                }
                if (!w.equals(s)) {
                    centralidadeBetweenness.put(w, centralidadeBetweenness.get(w) + delta.get(w));
                }
            }
        }
        return centralidadeBetweenness;
    }

    public Map<Autor, Double> calcularCentralidadeCloseness() {
        Map<Autor, Double> centralidadeCloseness = new HashMap<>();
        for (Autor autor : grafo.getAdjList().keySet()) {
            double sumDist = 0;
            Map<Autor, Integer> dist = bfs(autor);
            for (int d : dist.values()) {
                sumDist += d;
            }
            if (sumDist > 0) {
                centralidadeCloseness.put(autor, (grafo.getAdjList().size() - 1) / sumDist);
            } else {
                centralidadeCloseness.put(autor, 0.0);
            }
        }
        return centralidadeCloseness;
    }

    private Map<Autor, Integer> bfs(Autor start) {
        Map<Autor, Integer> dist = new HashMap<>();
        Queue<Autor> queue = new LinkedList<>();
        for (Autor autor : grafo.getAdjList().keySet()) {
            dist.put(autor, -1);
        }
        dist.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Autor v = queue.poll();
            for (Autor w : grafo.getAdjList().get(v)) {
                if (dist.get(w) == -1) {
                    dist.put(w, dist.get(v) + 1);
                    queue.add(w);
                }
            }
        }
        return dist;
    }
}
