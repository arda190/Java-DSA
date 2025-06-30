
public class DirectedGraph {
    int[][] matrix;
    int vertices;
    int INF=Integer.MAX_VALUE;

    public DirectedGraph(int vertices) {
        matrix = new int[vertices][vertices];
        this.vertices = vertices;
        for(int i=0; i<vertices; i++) {
            for(int j=0; j<vertices; j++) {
                matrix[i][j] = INF;
            }
        }

    }

    public void addEdge(int source,int destination,int weight){
        matrix[source][destination] = weight;
    }

    public void removeEdge(int source,int destination){
        matrix[source][destination] = INF;
    }

    public void printGraph(){
        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                if(matrix[i][j]==INF){
                    System.out.print("∞ ");
                }
                else{
                    System.out.print(matrix[i][j]+" ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 3, 9);
        graph.addEdge(2, 3, 1);
        graph.removeEdge(0,1);
        graph.printGraph();
    }




}
