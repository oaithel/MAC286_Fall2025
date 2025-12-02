package com.mac286.graphs;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
