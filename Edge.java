package inner.DataStrctures.Graphs.MainGraphImplementation;
import java.util.ArrayList;

public class Edge {

    private  Vertex startVertex;
    private  Vertex EndVertex;

    private  Integer Weight;

    Edge(Vertex startVertex,Vertex endVertex,Integer weight){
        this.startVertex = startVertex;
        this.EndVertex = endVertex;
        this.Weight = weight;
    }

    public Vertex getStartVertex(){
        return this.startVertex;
    }
    public Integer getWeight(){
        return this.Weight;
    }
    public Vertex getEndVertex(){
        return this.EndVertex;
    }
    public void getEdge(){
        System.out.println(this.toString());
    }


}
