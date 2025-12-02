package com.mac286.graphs;

public class GraphTester {
    public static void main(String[] args) {
        OurGraph<String> graph = new OurGraph<>();
        graph.addEdge("A", "B");
        graph.addEdge("A", "E");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("C", "D");
        graph.addEdge("D", "B");
        graph.addEdge("E", "A");
        graph.addEdge("E", "C");
        graph.addEdge("F", "G");
        graph.addEdge("H", null);
        graph.addEdge(null, "Z");
        System.out.println(graph);



    }
}
