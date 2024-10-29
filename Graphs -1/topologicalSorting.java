/*
    *Topological Sorting  O(V+E)
        Directed Acyclic Graph(DAG) is a directed graph with no cycles.
        Topological sorting is used only for DAGS (not for non-DAGs)
        It is a linear order of vertices such that every directed edge u -> v,
        the vertex u comes before v in the order.
 */

import java.util.*;
public class topologicalSorting{
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    public static void topologicalSort(ArrayList<Edge> graph[]){ // USING DFS
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                topologicalSortUtil(graph,i,visit,s); // this is basically the modified dfs
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topologicalSortUtil(ArrayList<Edge> graph[],int curr,boolean visit[],Stack<Integer> s){
        visit[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]){
                topologicalSortUtil(graph, e.dest, visit, s);
            }
        }
        s.push(curr);
    }
    // USING BFS
    public static void calcIndeg(ArrayList<Edge> graph[],int indeg[]){
        for(int i=0;i<graph.length;i++){
            int v = i;
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topoSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    // ALL PATH FROM SOURCE TO TAGGET

    public static void printAllPath(ArrayList<Edge> graph[],int src,int dest,String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src);
        }
    }
    public static void main (String args[]){
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        topologicalSort(graph);
        System.out.println();
        topoSort(graph);

        int src = 5,dest=1;
        String path;
        printAllPath(graph, src, dest,path="");
    }
}