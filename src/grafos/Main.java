package grafos;
import grafos.Grafo.Vertice;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Grafo simples (não dirigido):");
        GrafoSimples g = new GrafoSimples(); 
       
        Vertice s = g.adicionarVertice("s");
        Vertice t = g.adicionarVertice("t");
        Vertice u = g.adicionarVertice("u");
        Vertice v = g.adicionarVertice("v");
        Vertice x = g.adicionarVertice("x");
        
        g.adicionarAresta(v, s);        
        g.adicionarAresta(v, t);
        g.adicionarAresta(v, u);
        g.adicionarAresta(v, x);
        
        g.adicionarAresta(x, u);
        
        g.adicionarAresta(u, t); 
        
        g.adicionarAresta(u, u); 

        g.imprimir();
        
        boolean eAdj;
        eAdj = g.eAdjacente(s, v);
        System.out.println("\nOs vértices S e V são adjacentes? " + eAdj); // True
        
        eAdj= g.eAdjacente(x, t);   
        System.out.println("Os vértices X e T são adjacentes? " + eAdj); // False

        int grau = g.getGrau(v);
        System.out.println("O vértice V possui grau igual a: " + grau);
        
        boolean eRegular = g.eRegular();
        System.out.println("O grafo é regular? " + eRegular);
        
        boolean eNulo = g.eNulo();
        System.out.println("O grafo é nulo? " + eNulo);
        // -----------------------------------------------------------------// 
        
//        System.out.println("Grafo Dirigido:");
//        GrafoDirigido gD = new GrafoDirigido();         
//       
//        Vertice sD = gD.adicionarVertice("s");
//        Vertice tD = gD.adicionarVertice("t");
//        Vertice uD = gD.adicionarVertice("u");
//        Vertice vD = gD.adicionarVertice("v");
//        Vertice xD = gD.adicionarVertice("x");
//        
//        gD.adicionarAresta(v, s);        
//        gD.adicionarAresta(v, t);
//        gD.adicionarAresta(v, u);
//        gD.adicionarAresta(v, x);
//        
//        gD.adicionarAresta(x, u);
//        
//        gD.adicionarAresta(u, t); 
//        
//        gD.adicionarAresta(u, u); 
//
//        gD.imprimir();
//        
//        eAdj = g.eAdjacente(s, v);
//        System.out.println("\nO vértice S aponta para V? " + eAdj); // True
//        
//        eAdj= g.eAdjacente(x, t);
//        System.out.println("O vértice X aponta para T? " + eAdj); // False
//
//        grau = g.getGrau(v);
//        System.out.println("O vértice V possui grau de entrada igual a: " + grau);

    }
    
}
