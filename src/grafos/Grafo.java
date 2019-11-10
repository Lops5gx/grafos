package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    
    public class Vertice {
        String nome;
        List<Vertice> verticesAdjacentes;

        Vertice(String nome) {
            this.nome = nome;
            this.verticesAdjacentes = new ArrayList<>();
        }

        void addAdj(Vertice v) {
            this.verticesAdjacentes.add(v);
        }
    }
    
    List<Vertice> vertices;   
    
    public Grafo(){
        this.vertices = new ArrayList<>();  
    }
    
    public Vertice adicionarVertice(String nome) {
        Vertice v = new Vertice(nome);
        this.vertices.add(v);
        return v;
    }
    
    public void imprimir() {
        for (Vertice v : this.vertices) {
            System.out.print("\n" + v.nome + " -> "); 
            for (Vertice vAdj : v.verticesAdjacentes){
                System.out.print(vAdj.nome + ", ");
            }
        }
    }
    
    public void adicionarAresta(Vertice extremidadeUm, Vertice extremidadeDois){   
        extremidadeUm.verticesAdjacentes.add(extremidadeDois);
        if (!extremidadeUm.equals(extremidadeDois))
            extremidadeDois.verticesAdjacentes.add(extremidadeUm);
    } 
    
    private Vertice encontrarVertice(Vertice vertice){
        int index = this.vertices.indexOf(vertice);
        Vertice v = this.vertices.get(index);
        return v;
    }
    
    // Em dígrafos, retorna de o verticeUm "aponta" para o verticeDois
    public boolean eAdjacente(Vertice verticeUm, Vertice verticeDois ){
        Vertice v = encontrarVertice(verticeUm);        
        int index = v.verticesAdjacentes.indexOf(verticeDois);
        return (index != -1);
    } 
}
