package org.filetransfer.AnimalFriendsDad;

import java.io.Serializable;
import java.util.ArrayList;

public class AlmacenAnimales implements Serializable {
	
private ArrayList<Animal> almacenAnimales;
	
	public AlmacenAnimales() {
		this.almacenAnimales = new ArrayList<Animal>();
	}
	
	
	public int numeroAnimales() {
		return almacenAnimales.size();
	}
	
	public boolean Visualizar(Animal a){
        
        if (almacenAnimales.contains(a)) 
            return true;
        return false;
    }



	public void mostrarListaUsuarios(){
	    System.out.println("----------------------------------------");
	    System.out.println("Numero de animales registrados: " + numeroAnimales());
	
	    System.out.println (toString());
	
	    System.out.println("---------------------------------------");
	}
	
	@Override
	public String toString(){
	    String s = new String(); 
	    for (Animal a: getAlmacenAnimales())
	        s += a.toString() + "\n";
	    return s;
	}
	
	
	public ArrayList<Animal> getAlmacenAnimales() {
		return almacenAnimales;
	}
	
	
	public void setAlmacenU(ArrayList<Animal> almacenA) {
		this.almacenAnimales = almacenA;
	}

}
