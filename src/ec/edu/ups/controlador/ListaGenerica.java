/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 * @param <T>
 */
public abstract class ListaGenerica<T> {
 
    private List<T> lista;

    public ListaGenerica() {
        lista = new ArrayList();
    }
    
    public boolean crear(T nObjeto){  
        if(nObjeto!=null)
    return lista.add(nObjeto);
        return false;
    }
    public T buscar(T oBuscado){
    return lista.stream().filter(objeto-> objeto.equals(oBuscado)).findFirst().orElse(null);
    }
    public int buscarPosicion(T comparacion){
        for (int i = 0; i < lista.size(); i++) {
          T objeto = lista.get(i);
            if (objeto.equals(comparacion)) {
                return i;
            }
        }
 return -1;
    }
    public boolean eliminar(T objeto){
    T oEliminar = buscar(objeto);
        if (oEliminar!=null) {
            lista.remove(oEliminar);
        }
        return false;
    }
    public boolean actualizar(T objeto){
     int index = buscarPosicion(objeto);
        if (index>0){ 
            lista.set(index, objeto);
           return true;
        }
        return false;
    }
    
    public abstract boolean validar(T objeto);

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }
    
    public int generarID(){
    if (lista.size()>0) {
        return lista.indexOf(lista.size()-1)+1;
    }
   return 1;
}
   
       
}
