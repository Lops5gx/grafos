package com.company;

import java.util.ArrayList;
import java.util.List;

import com.company.Grafo.Vertice;

public class GrafoSimples extends Grafo {

    private Vertice encontrarVertice(Vertice vertice){
        int index = this.vertices.indexOf(vertice);
        Vertice v = this.vertices.get(index);
        return v;
    }

    private boolean temLoop(){
        boolean temLoop = false;
        for (Vertice vIndice : this.vertices){
            for (Vertice vAdjacente : this.vertices){
                if (vIndice.nome.equals(vAdjacente.nome)){
                    temLoop = true;
                }
            }
        }
        return temLoop;
    }

    // Método 2
    public int getGrau(Vertice vertice){
       return vertice.verticesAdjacentes.size();
    }

    // Método 3
    public boolean eRegular(){
        return verificarIgualdadeGrau(this.getGrau(this.vertices.get(0)));
    }

    // Método 4
    public boolean eIsolado(Vertice vertice){
        return this.getGrau(vertice) == 0;
    }

    // Método 5
    public boolean ePendente(Vertice vertice){
        return this.getGrau(vertice) == 1;
    }

    // Método 6
    public boolean eNulo(){
        return verificarIgualdadeGrau(0);
    }

    // Método 7
    public boolean eCompleto(){
        if(!this.temLoop()){
            return verificarIgualdadeGrau(this.vertices.size() - 1);
        } else {
            return false;
        }
    }
    private boolean verificarIgualdadeGrau(int grauBase){
        int qtdVertices = this.vertices.size();
        int grau, cont = 0;

        do {
            grau = this.getGrauSemLoop(this.vertices.get(cont++));
        }while (grauBase == grau && cont < qtdVertices);

        return (grauBase == grau);
    }

    private int getGrauSemLoop(Vertice vertice){
        int contLoop = 0;
        Vertice v = encontrarVertice(vertice);
        for (Vertice vAdj : v.verticesAdjacentes){
            if (vertice.nome.equals(vAdj.nome)) {
                contLoop++;
            }
        }
        return vertice.verticesAdjacentes.size() - contLoop;
    }

    // Método 8
    public boolean eConexo() {
   	 for (Vertice vIndice : this.vertices){
   		 if(getGrauSemLoop(vIndice) == 0) 
   			 return false;
   	 }
   	return true; 		
   }

   // Método 9

    //Método 10
    public void getComplementar(GrafoSimples g) {
        GrafoSimples complementar = g;
        int count = 0;
        for(Vertice v : g.vertices) {
            for(int j = count; j < g.vertices.size(); j++) {
                if(!g.eAdjacente(v, g.vertices.get(j)) && !v.nome.equals(g.vertices.get(j).nome))
                    complementar.adicionarAresta(v, g.vertices.get(j));
                else
                    complementar.removerAresta(v, g.vertices.get(j));
            }
            count++;
        }
        complementar.imprimir();
    }
    
    // Método 11
    public boolean eEuleriano() {
    	if(this.eConexo() && this.verificarTodosVerticesGrauPar())
    		return true;
    
    	 return false;
    }
    
    // Método 12
    public boolean eUnicursal() {
    	int count = 0;
    	if(!verificarTodosVerticesGrauPar()) {
    		for (Vertice vIndice : this.vertices){
       		 if(this.getGrau(vIndice) % 2 != 0)
       			 count++;
       	 }
    		if(count == 2)
    			return true;
    	}
    	return false;
    }

    public boolean verificarTodosVerticesGrauPar() {
    	 for (Vertice vIndice : this.vertices){
    		 if(this.getGrau(vIndice) % 2 != 0)
    			 return false;
    	 }
    	 return true;
    }

    // Método 13
}
