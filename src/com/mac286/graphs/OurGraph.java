package com.mac286.graphs;

import java.util.*;

public class OurGraph <T>{
    private Hashtable<T, List<T>> adjacencyList;

    public OurGraph(){
        adjacencyList = new Hashtable<>();
    }
    public void addEdge(T src, T dst){
        if(src == null){
            return;
        }
        if(dst == null){
            //was src already discovered
            List<T> adjList = adjacencyList.get(src);
            if(adjList == null){
                //it does not exist, add the src to the hashTable and create
                //an adjacentcy lst for it.
                adjList = new LinkedList<>();
                adjacencyList.put(src, adjList);
            }
            //else src was already added, nothing to do.
            return;
        }
        //both src and dst are not null.
        //get the adjacency list of the src and check if dst was already there, if
        //not then add it.
        List<T> adjList = adjacencyList.get(src);
        if(adjList == null){
            //first time we discover src, create a list for it add dst to it and do the same for
            //dst if src was not in it's adjacency list then add it to it.
            adjList = new LinkedList<>();
            adjList.add(dst);
            adjacencyList.put(src, adjList);
            //check for dst if src was added as an adjacent node, if not then addit.
            List<T> dstList = adjacencyList.get(dst);
            if(dstList == null){
                dstList = new LinkedList<>();
                dstList.add(src);
                adjacencyList.put(dst, dstList);
            }else{
                if(!dstList.contains(src)){
                    dstList.add(src);
                }
                //if it's already there, do nothing
            }
        }else{
            if(!adjList.contains(dst)){
                adjList.add(dst);
            }
            //check if dst was discovered before, if not then add it
            List<T> dstList = adjacencyList.get(dst);
            if(dstList == null){
                dstList = new LinkedList<>();
                dstList.add(src);
                adjacencyList.put(dst, dstList);
            }else{
                if(!dstList.contains(src)){
                    dstList.add(src);
                }
                //if it's already there, do nothing
            }
        }
    }
    //TODO: implement a method deleteEdge(T src, T dst) so that if dst is null then
    //the method removes the vertex src and all links connecting that vertex to
    // other nodes and src should be removed from the hashtable.
    // if dst is not null, then just remove the dst from adjacency list of src and
    //src from adjacency list of dst.
    public void deleteEdge(T src, T dst){}

    //Depth First Search Algorithm
    public String DFS(T src){
        //create a string to return
        String sequence = "";
        //create a set for visited nodes
        Set<T> visited = new HashSet<>();
        Stack<T> S = new Stack<>();
        //push src into stack
        S.push(src);
        while(!S.isEmpty()){
            T n = S.pop();
            //if the node not visited
            if(!visited.contains(n)){
                visited.add(n);
                sequence += n +"\t";
                List<T> adjList = adjacencyList.get(n);
                //go thru all neibors and push anyone not visited
                for(T temp:adjList){
                    if(!visited.contains(temp)){
                        S.push(temp);
                    }
                }

            }

        }
        return sequence;
    }
    //Minimum Spanning Tree using Depth First Search Algorithm
    public String MinumumTreeDFS(T src){
        //create a string to return
        String sequence = "";
        //create a set for visited nodes
        Set<T> visited = new HashSet<>();
        Stack<T> S = new Stack<>();
        //push src into stack
        S.push(src);
        visited.add(src);
        while(!S.isEmpty()){
            T n = S.peek();
            //find an unvisited neighbor
            boolean allNeighborsVisited = true;
                List<T> adjList = adjacencyList.get(n);
                //go thru all neibors and push anyone not visited
                for(T temp:adjList){
                    if(!visited.contains(temp)){
                        S.push(temp);
                        visited.add(temp);
                        allNeighborsVisited = false;
                        //add the edge (n, temp) to the tree
                        sequence += "(" + n +", " + temp+")" + "\t";
                        break;
                    }
                }
                if(allNeighborsVisited){
                    S.pop();
                }

            }
        return sequence;
    }

    public String BFS(T src){
        //create a set for visited
        Set<T> visited = new HashSet<>();
        //create a queue
        Queue<T> Q = new LinkedList<>();
        //visit src and add it to queue
        visited.add(src);
        String sequence = src.toString() + "\t";
        Q.add(src);
        while(!Q.isEmpty()){
            T n = Q.remove();
            //go thru all neighbors, anyone not visited, visit it and add it to the queue
            List<T> adjList = adjacencyList.get(n);
            for(T temp : adjList){
                if(!visited.contains(temp)){
                    visited.add(temp);
                    sequence += temp.toString() + "\t";
                    Q.add(temp);
                }
            }
        }
        return sequence;
    }
    public String toString(){
        if(adjacencyList == null || adjacencyList.isEmpty()){
            return "[]";
        }
        String st = "";
        //get the set of keys
        Set<T> vertices = adjacencyList.keySet();
        //go through the set of keys and get the adjacency list and print it
        for(T vertex : vertices){
            List<T> adjList = adjacencyList.get(vertex);
            st += vertex.toString() + " -> " + adjList.toString() + "\n";
        }
        return st;
    }
}
