package org.example;
import datastructures.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<Integer> l=new ArrayList<>(List.of(1,56,8,-3,4,8,2,3,5,13));
        Sort.QuickSort(l);
        System.out.println(l);

    }
}