package JavaNotes.heap;

import java.util.*;

public class DijkstraAlgo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of vertices
        int m = sc.nextInt(); // number of edges
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w)); // undirected
        }

        int source = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        int[] distTo = new int[n];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        distTo[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int prevNode = current.node;

            for (Pair edge : graph.get(prevNode)) {
                int next = edge.node;
                int nextDist = edge.distance;

                if (distTo[next] > distTo[prevNode] + nextDist) {
                    distTo[next] = distTo[prevNode] + nextDist;
                    pq.add(new Pair(next, distTo[next]));
                }
            }
        }

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " → " + distTo[i]);
        }
    }
}

class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
