package com.company;

public class GrafoSimples extends Grafo {

    private Vertice encontrarVertice(Vertice vertice){
        int index = this.vertices.indexOf(vertice);
        Vertice v = this.vertices.get(index);
        return v;
    }

    public int getGrau(Vertice vertice){
        int contGrau = 0;
        Vertice v = encontrarVertice(vertice);
        for (Vertice vAdj : v.verticesAdjacentes){
            contGrau++;
        }
        return contGrau;
    }

    public boolean ePendente(Vertice vertice){
        int grau = getGrau(vertice);
        return (grau == 1);
    }

    // Verifica se todos os vértices possuem o grau igual ao do parâmetro
    private boolean verificarIgualdadeGrau(int grauBase){
        int grau, cont = 0;

        do{
            grau = this.getGrau(this.vertices.get(cont++));
        }while(grauBase == grau && cont < this.vertices.size());

        return (grauBase == grau);
    }

    public boolean eRegular(){
        return verificarIgualdadeGrau(this.getGrau(this.vertices.get(0)));
    }

    public boolean eNulo(){
        return verificarIgualdadeGrau(0);
    }

    // Melhorar esse código
    public boolean eCompleto(){
        boolean adjacente, completo = false;
        if (this.eRegular()){
            completo = true;

            for (Vertice v : this.vertices){
                if(completo){
                    for(Vertice vAdj : this.vertices){
                        adjacente = super.eAdjacente(v, vAdj);
                        if(!adjacente){
                            completo = false;
                        }
                    }
                }
            }
        }
        return completo;
    }
}
