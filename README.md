# Implementing data structures
In order to review the principal data structures and their associated algorithms, I decided to reimplement them in Java. Furthermore, it allows me to refamiliarize myself with the Java language.

## Graphs
I've implemented generic weighted and unweighted graphs using an adjacency list, it uses less memory than an adjacency matrix, even though it's more complex to implement. Both types of graphs can be directed or not. I implemented the BFS, DFS and shortest path algorithms for unweighted graphs and Dijkstra's algorithm for weighted graph.  

### Unweighted Graphs
#### BFS 

BFS stands for Breadth-First Search. It employs a Queue data structure to ensure a first-in, first-out order. In the BFS algorithm, a single vertex is chosen for visitation and marking at a time, and subsequently, its neighboring vertices are visited and placed into the queue. So the graph is visited transversally, first checking adjacent nodes and then digging deeper into the graph.

#### DFS 

DFS stands for Depth First Search. It relies on the Stack data structure, it pushes visited vertices onto the stack and if there are no more vertices to visit, it pops previously visited vertices from the stack.So the graph is visited vertically, descending as far as possible from one node before moving on to the next.

#### Shortest path

The shortest path algorithm is a modified version of BFS. In addition to traversing the graph, the algorithm remembers the preceding vertex during the traversal. Once the graph has been traversed, it is possible to determine the shortest path between a point and the source by descending the list of preceding vertices.

### Weighted Graphs
#### Dijkstra 
Dijkstra's algorithm is a shortest-path algorithm used to find the shortest path from a starting node to all other nodes in a weighted graph. It maintains a set of unvisited nodes and continually selects the node with the smallest known distance, updating the distances to its neighbors. This process continues until all nodes have been visited, resulting in the shortest paths from the starting node to all others.

## Linked List

A linked list is a linear data structure comprising a series of elements, known as nodes. Each node contains data and a reference to the next node (optionally a reference to the previous node), forming a chain-like sequence. Linked lists offer efficient insertions and deletions at any point within the list. I implemented a  doubly linked lists, that is nodes point to both the next and previous elements.

