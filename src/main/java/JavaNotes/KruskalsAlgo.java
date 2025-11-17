package JavaNotes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge>{

    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt){
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    @Override
    public int compareTo(Edge other) {
        return this.wt - other.wt;
    }
}

class Dsu{

    int [] parent,rank;

    public Dsu(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findPar(int x){
        if(parent[x] ==x) return x;
        return parent[x] = findPar(parent[x]);
    }

    public void union(int x,int y){

        int u = findPar(x);
        int v = findPar(y);

        if(u == v) return;
        if(rank[u]>rank[v]){
            parent[v] = u;
            rank[u]+=1;
        }else{
            parent[u] = v;
            rank[v]+=1;
        }

    }
}
public class KruskalsAlgo {

    public static void main(String[] args) {

        int n=6;
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 4),
                new Edge(0, 2, 4),
                new Edge(1, 2, 2),
                new Edge(2, 3, 3),
                new Edge(2, 5, 2),
                new Edge(2, 4, 4),
                new Edge(3, 4, 3),
                new Edge(5, 4, 3)
        );

        Collections.sort(edges);
        List<Edge> mst = new ArrayList<>();
        Dsu  dsu = new Dsu(n);
        int totalWeight = 0;

        for(Edge edge:edges){
            int u = edge.src;
            int v = edge.dest;
            int w = edge.wt;

            if(dsu.findPar(u) != dsu.findPar(v)){
                dsu.union(u,v);
                totalWeight+=w;
                mst.add(edge);
            }
        }

        System.out.println("Weight of Minimum Spanning tree is: "+totalWeight);
        for (Edge edge:mst){

            System.out.println("src= "+edge.src+" dest= "+edge.dest+" wt= "+edge.wt);
        }

    }
}
