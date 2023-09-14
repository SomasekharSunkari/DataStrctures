package inner.DataStrctures.Graphs.MainGraphImplementation;
import java.util.ArrayList;
public class Graph {

    ArrayList<Vertex> vertices;
    private  boolean isWeighted;
    private boolean isDirected;

    Graph(boolean isDirected,boolean isWeighted){
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        this.vertices = new ArrayList<Vertex>();
    }

    public Vertex addVertex(String data){
        Vertex newVertex  = new Vertex(data);
        vertices.add(newVertex);
        return newVertex;
    }

    public void AddEdge(Vertex vertex1, Vertex vertex2, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }

        if (!hasEdge(vertex1, vertex2)) {
            vertex1.addEdge(vertex2, weight);
            if (!this.isDirected) {
                vertex2.addEdge(vertex1, weight);
            }
        } else {
            System.out.println("Edge between " + vertex1.getData() + " and " + vertex2.getData() + " already exists.");
        }
    }

    private boolean hasEdge(Vertex vertex1, Vertex vertex2) {
        for (Edge edge : vertex1.getEdges()) {
            if (edge.getEndVertex() == vertex2) {
                return true;
            }
        }
        return false;
    }
//    Here's what's changed:
//
//    We added a hasEdge private method to check whether an edge between vertex1 and vertex2 already exists in the edges list of vertex1. This method iterates through the edges of vertex1 and checks if the end vertex of any edge matches vertex2.
//
//    In the AddEdge method, before adding the edge, we call hasEdge to check if the edge already exists. If it does, we print a message indicating that the edge already exists, and we don't add the edge again.
//
//    This modification ensures that you won't add duplicate edges between the same vertices in your graph.
//
//
//
//
//
//
    public void removeEdge(Vertex vertex1,Vertex vertex2){
        vertex1.removeEdge(vertex2);
        if(!this.isDirected){
            vertex2.removeEdge(vertex1);
        }
    }
    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex);
    }

    public Vertex getVertexByvalue(String data){

        for (Vertex v:this.vertices) {

            if(v.getData() == data){
                return v;
            }

        }
        return null;

    }
//    public void PrintGraph(){
//        String message = "";
//
//        for (Vertex node:this.vertices) {
//
//            for (Edge e: node.edges) {
//
//               message += e.getStartVertex();
//
//
//
//            }
//
//
//        }
//    }

    public void pringGraph(){

        for (Vertex v:vertices) {
            v.printVertex(false);

        }
//        System.out.println((this.vertices).toString());
    }
    public static void main(String[] args) {

        Graph graph = new Graph(true,true);
        Vertex sekhar =   graph.addVertex("Sekhar");
        Vertex anojRao = graph.addVertex("Anoj rao");
        graph.AddEdge(sekhar,anojRao,100);
        Vertex murali =   graph.addVertex("Murali");
        Vertex manoj = graph.addVertex("Manoj");
        Vertex bka = graph.addVertex("Bharat");
        Vertex ragava = graph.addVertex("Ragu Abt");
        graph.AddEdge(sekhar,ragava,1000);
        graph.AddEdge(sekhar,murali,2000);
        graph.AddEdge(sekhar,manoj,3000);
        graph.AddEdge(sekhar,bka,4000);
        graph.AddEdge(sekhar,anojRao,3000);
        graph.AddEdge(anojRao,sekhar,100);
        graph.AddEdge(murali,sekhar,3000);
        graph.AddEdge(murali,manoj,30004);
        graph.AddEdge(murali,bka,10000);
        graph.AddEdge(bka,murali,12);
        graph.AddEdge(bka,sekhar,10);
        graph.AddEdge(bka,manoj,239);
        graph.removeEdge(sekhar,ragava);

        graph.AddEdge(ragava,sekhar,1);

        graph.pringGraph();


    }
}
