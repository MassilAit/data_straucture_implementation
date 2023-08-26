package org.example;
import datastructures.Graph;
import datastructures.WeightedGraph;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<Character> graph=new WeightedGraph<>();
        graph.addEdge('A','B',2,false);
        graph.addEdge('A','D',8,false);
        graph.addEdge('B','D',5,false);
        graph.addEdge('B','E',6,false);
        graph.addEdge('D','E',3,false);
        graph.addEdge('D','F',2,false);
        graph.addEdge('E','C',9,false);
        graph.addEdge('E','F',1,false);
        graph.addEdge('F','C',3,false);

        System.out.println(graph.dijkstra('A'));


    }
}