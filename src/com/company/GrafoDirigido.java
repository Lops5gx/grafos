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

}