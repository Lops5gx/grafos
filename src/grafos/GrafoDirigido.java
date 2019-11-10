package grafos;

public class GrafoDirigido extends Grafo {
  
    @Override
    public void adicionarAresta(Vertice origem, Vertice destino){   
        origem.verticesAdjacentes.add(destino);
    }            
}
