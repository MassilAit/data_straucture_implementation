package org.example;
import datastructures.Graph;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(1,2,true);
        graph.addEdge(1,3,true);
        graph.addEdge(2, 4,true);
        graph.addEdge(2,5,true);
        graph.addEdge(3,6,true);
        graph.addEdge(3,7,true);
        graph.addEdge(6,2,true);
        graph.DFS(1);
        System.out.println(graph.getEdgeCount());
        System.out.println(graph.getVertexCount());
    }
}