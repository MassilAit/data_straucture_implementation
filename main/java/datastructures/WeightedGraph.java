package datastructures;

import java.util.*;

class Edge<T>{
    T vertex;
    int weight;

    public Edge(T v, int w){
        vertex=v;
        weight=w;
    }

    public String toString(){
        return "("+vertex+" ,"+weight+")";
    }
}

public class WeightedGraph<T> {
    private Map<T, List<Edge<T>>> map=new HashMap<>();
    private int v=0;
    private int e=0;

    private boolean contains(List<Edge<T>> l, T v){
        for (Edge<T> edge:l){
            if (edge.vertex==v){
                return true;
            }
        }
        return false;
    }

    public void addVertex(T vertex){
        map.put(vertex, new LinkedList<>());
        v++;
    }

    public T removeVertex(T v){
        if (!map.containsKey(v)){
            return null;
        }

        int i=map.get(v).size();
        e-=i;

        map.remove(v);
        this.v--;

        for (T key :map.keySet()){
            if(map.get(key).removeIf(e->(e.vertex==v))){
                e--;
            }
        }
        return v;
    }



    public void addEdge(T source, T destination, int weight, boolean isDirected){
        if (!map.containsKey(source)){
            addVertex(source);
        }
        if (!map.containsKey(destination)){
            addVertex(destination);
        }

        if (!contains(map.get(source),destination)){
            map.get(source).add(new Edge<>(destination, weight));
            e++;
        }

        if(!isDirected){
            if (!contains(map.get(destination),source)){
                map.get(destination).add(new Edge<>(source, weight));
                e++;
            }

        }

    }

    public void removeEdge(T source, T destination){
        if(map.get(source).removeIf(e->(e.vertex==destination))){
            e--;
        }
    }

    public int getEdgeCount(){
        return e;
    }

    public int getVertexCount(){
        return v;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();

        for (T key :map.keySet()){
            sb.append(key.toString()+" : ");
            for (Edge<T> edge:map.get(key)){
                sb.append(edge.toString()+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private T findMinDistance( Map<T,Edge<T>> prev,Set<T> visited){
        int min=Integer.MAX_VALUE;
        T v=null;
        for (T key : prev.keySet()){
            if(prev.get(key).weight<=min && !visited.contains(key)){
                min=prev.get(key).weight;
                v=key;
            }

        }

        return v;
    }

    private  Map<T,List<T>> findPath(Map<T,Edge<T>> prev){
        Map<T,List<T>> r=new HashMap<>();

        for (T key:prev.keySet()){
            r.put(key,new ArrayList<>());
            r.get(key).add(key);
            T nxt=prev.get(key).vertex;
            r.get(key).add(nxt);
            while (nxt!=null){
                nxt=prev.get(nxt).vertex;
                r.get(key).add(nxt);
            }
            r.get(key).remove(r.get(key).size()-1);
            Collections.reverse(r.get(key));
        }

        return r;
    }

    public Map<T,List<T>> dijkstra(T source){
        Map<T,Edge<T>> prev =new HashMap<>();
        Set<T> visited=new HashSet<>();
        Set<T> unvisited=new HashSet<>();

        for (T key:map.keySet()){
            prev.put(key,new Edge<>(null,Integer.MAX_VALUE));
            unvisited.add(key);
        }

        prev.put(source,new Edge<>(null,0)) ;

        while (!unvisited.isEmpty()){
            T v=findMinDistance(prev,visited);
            visited.add(v);
            unvisited.remove(v);

            for (Edge<T> neighbor:map.get(v)){
                if(prev.get(v).weight+neighbor.weight<prev.get(neighbor.vertex).weight){

                    prev.put(neighbor.vertex,new Edge<>(v,prev.get(v).weight+neighbor.weight));

                }

            }

        }


        return findPath(prev);
    }


}
