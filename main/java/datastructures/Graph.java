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

    public T removeVertex(T v){
        if (!map.containsKey(v)){
            return null;
        }

        int i=map.get(v).size();
        e-=i;

        map.remove(v);
        this.v--;

        for (T key :map.keySet()){
           if(map.get(key).remove(v)){
               e--;
           };
        }
        return v;
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

    public void removeEdge(T source, T destination){
        if(map.get(source).remove(destination)){
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
            for (T edge:map.get(key)){
                sb.append(edge.toString()+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void BFS(T s){
        Queue<T> q = new LinkedList<>();
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

    public List<T> shortestPath(T source, T destination){
        Map<T,Integer> dist=new HashMap<>();
        Map<T,T> prev=new HashMap<>();
        Queue<T> q=new LinkedList<>();
        Set<T> visited = new HashSet<>();

        for (T key :map.keySet()){
            dist.put(key,Integer.MAX_VALUE);
            prev.put(key,null);
        }

        q.add(source);
        dist.put(source,0);

        while (!q.isEmpty()){
            T vertex= q.remove();
            if (!visited.contains(vertex)){
                visited.add(vertex);

                for (T neighbor :map.get(vertex)){

                    if (!visited.contains(neighbor) && !q.contains(neighbor)){
                        q.add(neighbor);
                        dist.put(neighbor,dist.get(vertex)+1);
                        prev.put(neighbor,vertex);
                    }

                }

            }

        }

        List<T> path =new ArrayList<>();
        path.add(destination);
        if (prev.get(destination)==null){
            return path;
        }

        T p =prev.get(destination);

        while (p !=null){
            path.add(p);
            p=prev.get(p);
        }

        Collections.reverse(path);
        return path;


    }


}


