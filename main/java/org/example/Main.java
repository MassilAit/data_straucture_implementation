package org.example;
import datastructures.Graph;
import datastructures.LinkedList_;
import datastructures.WeightedGraph;

public class Main {
    public static void main(String[] args) {
        LinkedList_<Integer> l=new LinkedList_<>();
        l.add(2);
        l.add(3);
        l.add(14);
        l.add(15);
        l.add(8,2);
        System.out.println(l);
        System.out.println(l.size());
        l.removeIndex(5);
        System.out.println(l);
        System.out.println(l.size());

    }
}