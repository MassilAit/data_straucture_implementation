package datastructures;
import java.util.*;

// Graph class using the adjacent list implementation
public class Graph<T> {

    private Map<T, List<T>> map =new HashMap<>();
    private int v=0;
    private int e=0;

    public void addVertex(T vertex){
        map.put(vertex, new LinkedList<>());
        v++;
    }

    public void addEdge(T source, T destination, boolean isDirected){
        if (!map.containsKey(source)){
            addVertex(source);
        }
        if (!map.containsKey(destination)){
            addVertex(destination);
        }

        if (!map.get(source).contains(destination)){
            map.get(source).add(destination);
            e++;
        }
        if (!isDirected){
            if (!map.get(destination).contains(source)){
                map.get(destination).add(source);
                e++;
            }
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
            for (T edge:map.get(key)){
                sb.append(edge.toString()+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void BFS(T s){
        Queue<T> q = new PriorityQueue<>();
        Set<T> visited = new HashSet<>();

        if (!map.containsKey(s)){
            return;
        }
        q.add(s);
        while (!q.isEmpty()){
            T vertex=q.remove();
            if (!visited.contains(vertex)){
                System.out.print(vertex.toString() + " ");
                visited.add(vertex);
                q.addAll(map.get(vertex));
            }

        }
        System.out.println();

    }

    public void DFS(T s){
        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();

        if (!map.containsKey(s)){
            return;
        }
        stack.push(s);
        while (!stack.isEmpty()){
            T vertex=stack.pop();
            if (!visited.contains(vertex)){
                System.out.print(vertex.toString() + " ");
                visited.add(vertex);
                for(T adj:map.get(vertex)){
                    stack.push(adj);
                }
            }

        }
        System.out.println();
    }
}
