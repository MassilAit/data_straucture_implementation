# Implementing data structures
In order to review the principal data structures and their associated algorithms, I decided to reimplement them in Java. Furthermore, it allows me to refamiliarize myself with the Java language.

## Graphs
I've implemented generic graphs using an adjacency list, it uses less memory than an adjacency matrix, even though it's more complex to implement. I also implemented the BFS and DFS algorithms, two graph traversal algorithms.

### BFS 

BFS stands for Breadth-First Search. It employs a Queue data structure to ensure a first-in, first-out order. In the BFS algorithm, a single vertex is chosen for visitation and marking at a time, and subsequently, its neighboring vertices are visited and placed into the queue. So the graph is visited transversally, first checking adjacent nodes and then digging deeper into the graph.

### DFS 

DFS stands for Depth First Search. It relies on the Stack data structure, it pushes visited vertices onto the stack and if there are no more vertices to visit, it pops previously visited vertices from the stack.So the graph is visited vertically, descending as far as possible from one node before moving on to the next.
