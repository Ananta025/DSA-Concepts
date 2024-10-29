/*
    *Bipartite Graph:
        A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge
        (u, v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either u
        belongs to U and v to V, or u belongs to V and v to U. We can also say that there is no edge that connects vertices of
        same set.

    Bipartite Graph
        Acyclic                                        TRUE
        Even Cycle(Even number of nodes/vertices)      TRUE
        Odd Cycle(Even number of nodes/vertices)       FALSE

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteGraph{
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new  ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }
    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for(int i=0;i<color.length;i++){
            color[i] = -1; // No color
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i] == -1){
                q.add(i);
                color[i] = 0; // Yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        Edge e = graph[curr].get(j);
                        if(color[e.dest] == -1){
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        }else if(color[e.dest] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}