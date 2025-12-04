package com.mac286.graphs;

public class GraphTester {
    public static void main(String[] args) {
        OurGraph<String> graph = new OurGraph<>();
        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "D");
        graph.addEdge("E", "F");
        graph.addEdge("E", "G");
        System.out.println(graph);
        System.out.println("DFS: " + graph.DFS("C"));
        System.out.println("BFS: " + graph.BFS("C"));
        System.out.println("MinimumSpanningTreeDFS: " + graph.MinumumTreeDFS("A"));


    }
}
