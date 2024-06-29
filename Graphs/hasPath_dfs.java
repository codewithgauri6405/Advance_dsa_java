package Advance_dsa_java.Graphs;

import java.awt.*;
import java.util.*;

public class hasPath_dfs {
    static class Edge {

        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 4, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));


    }
//    public static void dfs(ArrayList<Edge>graph[],int curr,boolean []visit){
//
//        visit[curr] = true;
//        System.out.print(curr+" ");
//
//        for (int i=0;i<graph[curr].size();i++){
//
//            Edge e = graph[curr].get(i);
//            if(!visit[e.dest]){
//                dfs(graph,e.dest,visit);
//            }
//        }


    public static boolean HasPath(ArrayList<Edge>[] graphs, int src, int dest, boolean[] visit) {

        if (src == dest) {
            return true;
        }
        visit[src] = true;

        for (int i = 0; i < graphs[src].size(); i++) {
            Edge e = graphs[src].get(i);

            if (!visit[e.dest] && HasPath(graphs, e.dest, dest, visit)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
//        dfs(graph,0,new boolean[7]);
        System.out.println(HasPath(graph, 0, 12, new boolean[V]));

    }
}