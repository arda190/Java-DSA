public class UndirectedGraph {
    int[][] matrix;
    int vertices;
    int INF=Integer.MAX_VALUE;
    public UndirectedGraph(int vertices) {
        matrix = new int[vertices][vertices];
        this.vertices = vertices;
        for(int i=0; i<vertices; i++) {
            for(int j=0; j<vertices; j++) {
                matrix[i][j] = INF;
            }
        }
    }
    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight;
    }
    public void removeEdge(int source, int destination) {
        matrix[source][destination] =INF;
    }

    public int getWeight(int source, int destination) {
        return matrix[source][destination];
    }
    public void printGraph() {
        for(int i=0; i<vertices; i++) {
            for(int j=0; j<vertices; j++) {
                if(matrix[i][j]==INF) {
                    System.out.print("∞ ");
                }
                else{
                    System.out.print(matrix[i][j]+" ");
                }
            }
            System.out.println();
        }
    }


}
