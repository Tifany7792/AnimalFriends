package org.filetransfer.AnimalFriendsDad.Almacenes;

import java.io.Serializable;
import java.util.ArrayList;

import org.filetransfer.AnimalFriendsDad.Productos;

public class AlmacenProductos implements Serializable {
	
	private ArrayList<Productos> almacenProductos;
	
	public AlmacenProductos() {
		this.almacenProductos = new ArrayList<Productos>();
	}
	
	
	public int numeroProductos() {
		return almacenProductos.size();
	}
	
	public boolean Visualizar(Productos p){
        
        if (almacenProductos.contains(p)) 
            return true;
        return false;
    }



	public void mostrarListaProductos(){
	    System.out.println("----------------------------------------");
	    System.out.println("Numero de productos registradas: " + numeroProductos());
	
	    System.out.println (toString());
	
	    System.out.println("---------------------------------------");
	}
	
	@Override
	public String toString(){
	    String s = new String(); 
	    for (Productos p: getAlmacenProductos())
	        s += p.toString() + "\n";
	    return s;
	}
	
	
	public ArrayList<Productos> getAlmacenProductos() {
		return almacenProductos;
	}
	
	
	public void setAlmacenProductos(ArrayList<Productos> almacenP) {
		this.almacenProductos = almacenP;
	}


}
