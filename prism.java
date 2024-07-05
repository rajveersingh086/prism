package pattern;

import java.util.*;
//Rajveer singh
//22SCSE1011341
class Graph {
    private int V; 
    private int[][] graph; 

    public Graph(int V) {
        this.V = V;
        this.graph = new int[V][V];
    }

    public void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
        graph[dest][src] = weight; 
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public void primMST() {
        int[] parent = new int[V]; 
        int[] key = new int[V]; 
        boolean[] mstSet = new boolean[V]; 

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; 
        parent[0] = -1; 

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent);
    }

    private void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }
}

public class prism {
    public static void main(String[] args) {
        int V = 5;
        Graph g = new Graph(V);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        g.primMST();
        System.out.println("\n"+"RAJVEER SINGH "  );
        System.out.println("22SCSE10341 ");
    }
}
