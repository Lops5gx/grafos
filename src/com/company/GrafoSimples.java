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
        int grau = (temLoop(vertice)) ? vertice.verticesAdjacentes.size() + 2 : vertice.verticesAdjacentes.size();
        return grau;
    }

    private boolean temLoop(Vertice vertice){
        boolean temLoop = false;
        for(Vertice v : vertice.verticesAdjacentes){
            if(v.nome.equals(vertice.nome)){
                temLoop = true;
            }
        }
        return temLoop;
    }

    // Método 3
    public boolean eRegular(){
        return verificarIgualdade(this.getGrau(this.vertices.get(0)));
    }

    private boolean verificarIgualdade(int grauBase){
        int qtdVertices = this.vertices.size();
        int grau, cont = 0;

        do {
            grau = this.getGrau(this.vertices.get(cont++));
        }while (grauBase == grau && cont < qtdVertices);

        return (grauBase == grau);
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
        return verificarIgualdade(0);
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
   public boolean eBipartido(){
       List<Vertice> subGrafo1 = new ArrayList<>();
       List<Vertice> subGrafo2 = new ArrayList<>();
       List<Vertice> toRemove = new ArrayList<>();

       // Criando caso base
       Vertice verticeBase = this.vertices.get(0);
       subGrafo1.add(verticeBase);
       for(Vertice v: this.vertices){
           if(this.eAdjacente(v, verticeBase)){
               subGrafo2.add(v);
           }else{
               if(!v.nome.equals(verticeBase.nome)) subGrafo1.add(v);
           }
       }

       // Verficando adjacencia entre os elementos do subrafo 1
       for(Vertice vBase : subGrafo1){
           if(!toRemove.contains(vBase)){
               for(Vertice v : subGrafo1){
                   if(!vBase.nome.equals(v.nome)){
                       if(this.eAdjacente(vBase, v)){
                           if(!subGrafo2.contains(v))subGrafo2.add(v);
                           if(!toRemove.contains(v)) toRemove.add(v);
                       }
                   }
               }
           }
       }

       for(Vertice v : toRemove){
           subGrafo1.remove(v);
       }
       toRemove.clear();


       // Verficando adjacencia entre os elementos do subrafo 2
       for(Vertice vBase : subGrafo2){
           if(!toRemove.contains(vBase)){
               for(Vertice v : subGrafo2){
                   if(!vBase.nome.equals(v.nome)){
                       if(this.eAdjacente(vBase, v)){
                           if(!toRemove.contains(v)) toRemove.add(v);
                       }
                   }
               }
           }
       }

       for(Vertice v : toRemove){
           subGrafo2.remove(v);
       }
       toRemove.clear();

       return (subGrafo1.size() + subGrafo2.size()) == this.vertices.size();

   }

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
