package datastructures;

public class LinkedList_<T> {
    static class Node<T>{
        protected T element;
        protected Node<T> prev;
        protected Node<T> next;


        public boolean equal(T el){
            return element==el;
        }

        public Node(T element) {
            this.element=element;
            prev=null;
            next=null;
        }

        public Node(T element, Node<T> prev, Node<T> next){
            this.element=element;
            this.prev=prev;
            this.next=next;
        }

        public String toString(){
            StringBuilder sb=new StringBuilder();
            if (prev==null){
                sb.append("NULL -> ");
            }

            sb.append(element+" -> ");

            if (next==null){
                sb.append("NULL");
            }
            return sb.toString();
        }
    }

    private Node<T> f;
    private Node<T> l;

    private int n=0;

    public LinkedList_(){
        f=null;
    }

    public T get(int index){
        if (index<0 || index >=n){
            return null;
        }
        Node<T> current =f;
        for(int i=0; i<index;i++){
            current=current.next;
        }
        return current.element;
    }

    //O(1) because we keep in memory the last node
    public void add(T element){
        if( f==null){
            f=new Node<>(element);
            l=f;
            n++;
            return;
        }

        Node<T> el=new Node<>(element,l,null);
        l.next=el;
        l=el;
        n++;

    }

    public void add(T element, int index){
        if (index>=n){
            add(element);
            return;
        }

        Node<T> current = f;
        for(int i=1;i<index;i++){
            current = current.next;
        }
        Node<T> el=new Node<>(element,current,current.next);
        current.next.prev=el;
        current.next=el;
        n++;

    }

    public T remove(T element){
        Node<T> current =f;
        while(current!=null){
            if (current.equal(element)){
                if (current.next==null){
                    T el= current.element;
                    l=l.prev;
                    l.next=null;
                    n--;
                    return el;
                }

                if (current.prev==null){
                    T el=f.element;
                    f=f.next;
                    f.prev=null;
                    n--;
                    return el;
                }
                current.prev.next=current.next;
                current.next.prev=current.prev;
                n--;
                return current.element;
            }
            current=current.next;
        }

        return null;
    }

    public T removeIndex(int index){
        if (index>=n || index<0){
            return null;
        }

        if (index==0){
            T el=f.element;
            f=f.next;
            f.prev=null;
            n--;
            return el;
        }

        if (index==n-1){
            T el= l.element;
            l=l.prev;
            l.next=null;
            n--;
            return el;
        }

        Node<T> current = f;
        for (int i=0; i<index; i++){
            current=current.next;
        }

        current.prev.next=current.next;
        current.next.prev=current.prev;
        n--;

        return current.element;

    }

    public int size(){
        return n;
    }

    public String toString(){
        Node<T> el=f;
        StringBuilder sb =new StringBuilder();
        while (el!=null){
            sb.append(el);
            el=el.next;

        }

        return sb.toString();
    }

}
