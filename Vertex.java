package inner.DataStrctures.Graphs.MainGraphImplementation;
import java.util.ArrayList;

public class Vertex {

    private String data;

    ArrayList<Edge> edges;

    Vertex(String data) {
        this.data = data;
        this.edges = new ArrayList<Edge>();
    }

    public String getData(){
        return this.data;
    }
    public void addEdge(Vertex endVertex, Integer weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEndVertex().equals(endVertex));
    }
    public ArrayList<Edge> getEdges(){
//        System.out.println(this.edges.toString());
        return this.edges;
    }
    public void printVertex(boolean showWeight){
        String message = "";

        if (this.edges.size() == 0) {
            System.out.println(this.data + " -->");
            return;
        }

        for(int i = 0; i < this.edges.size(); i++) {
            if (i == 0) {
                message += this.edges.get(i).getStartVertex().data + " -->  ";
            }

            message += this.edges.get(i).getEndVertex().data;

            if (showWeight) {
                message += " (" + this.edges.get(i).getWeight() + ")";
            }

            if (i != this.edges.size() - 1) {
                message += ", ";
            }
        }
        System.out.println(message);
        }
    }

