package org.filetransfer.AnimalFriendsDad.Almacenes;

import java.io.Serializable;
import java.util.ArrayList;

import org.filetransfer.AnimalFriendsDad.Localizaciones;

public class AlmacenLocalizaciones implements Serializable {
	
	private ArrayList<Localizaciones> almacenLocalizaciones;
	
	public AlmacenLocalizaciones() {
		this.almacenLocalizaciones = new ArrayList<Localizaciones>();
	}
	
	
	public int numeroLocalizaciones() {
		return almacenLocalizaciones.size();
	}
	
	public boolean Visualizar(Localizaciones l){
        
        if (almacenLocalizaciones.contains(l)) 
            return true;
        return false;
    }



	public void mostrarListaLocalizaciones(){
	    System.out.println("----------------------------------------");
	    System.out.println("Numero de Localizaciones registradas: " + numeroLocalizaciones());
	
	    System.out.println (toString());
	
	    System.out.println("---------------------------------------");
	}
	
	@Override
	public String toString(){
	    String s = new String(); 
	    for (Localizaciones l: getAlmacenLocalizaciones())
	        s += l.toString() + "\n";
	    return s;
	}
	
	
	public ArrayList<Localizaciones> getAlmacenLocalizaciones() {
		return almacenLocalizaciones;
	}
	
	
	public void setAlmacenLocalizaciones(ArrayList<Localizaciones> almacenL) {
		this.almacenLocalizaciones = almacenL;
	}

}
