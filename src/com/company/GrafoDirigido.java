package com.company;

public class GrafoDirigido extends Grafo {

    @Override
    public void adicionarAresta(Vertice origem, Vertice destino){
        origem.verticesAdjacentes.add(destino);
    }

    // Método 14
    public int getGrauEntrada(Vertice v){
        String nomeVertice = v.nome;
        int grauEntrada = 0;
        for(Vertice vInd : this.vertices){
            for(Vertice vAdj : vInd.verticesAdjacentes){
                if(nomeVertice.equals(vAdj.nome)){
                    grauEntrada++;
                }
            }
        }
        return grauEntrada;
    }

    // Método 15

    // Método 16
    public Grafo getTransposto(){
        Grafo transposto = new GrafoDirigido();
        obterEstrutura(transposto);
        obterConexoesTranspostas(transposto);
        return transposto;
    }

    private void obterEstrutura(Grafo transposto){
        for(Vertice v : this.vertices){
            transposto.adicionarVertice(v.nome);
        }
    }

    private void obterConexoesTranspostas(Grafo transposto){
        for(Vertice vTransposto : transposto.vertices){
           for(Vertice vOriginal : this.vertices){
                for(Vertice vAdjOriginal : vOriginal.verticesAdjacentes){
                    if(vAdjOriginal.nome.equals(vTransposto.nome)){
                        vTransposto.addAdj(vOriginal.nome);
                    }
                 }
           }
        }
    }

    // Método 17

 // Método 17
    
    public boolean isFConexo() { 
    	for (Vertice vIndice : this.vertices){
            for (Vertice vAdjacente : vIndice.verticesAdjacentes){
            	if(percorrerGrafo(vIndice, vAdjacente))
            		return true;
            }
    	}
    	return false;
    }
    
    public boolean percorrerGrafo(Vertice o, Vertice d) {
    	int countVertice = o.verticesAdjacentes.size();
    	int qtdVertices = this.vertices.size();
    	for (Vertice vIndice : d.verticesAdjacentes){
        	for(Vertice v : o.verticesAdjacentes) {
        		if(vIndice != v) 
        			countVertice++;
        	}
        }
    	if(countVertice==qtdVertices)
    		return true;
    	else
    		return false;
    }
}