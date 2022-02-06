package org.filetransfer.AnimalFriendsDad;

import java.io.Serializable;
import java.util.ArrayList;

public class AlmacenUsuarios implements Serializable{
	
	private ArrayList<Usuarios> almacenU;
	
	public AlmacenUsuarios() {
		this.almacenU = new ArrayList<Usuarios>();
	}
	
	
	public int numeroUsuarios() {
		return almacenU.size();
	}
	
	public boolean Visualizar(Usuarios u){
        
        if (almacenU.contains(u)) 
            return true;
        return false;
    }



	public void mostrarListaUsuarios(){
	    System.out.println("----------------------------------------");
	    System.out.println("Numero de usuarios registrados: " + numeroUsuarios());
	
	    System.out.println (toString());
	
	    System.out.println("---------------------------------------");
	}
	
	@Override
	public String toString(){
	    String s = new String(); 
	    for (Usuarios u: getAlmacenU())
	        s += u.toString() + "\n";
	    return s;
	}
	
	
	public ArrayList<Usuarios> getAlmacenU() {
		return almacenU;
	}
	
	
	public void setAlmacenU(ArrayList<Usuarios> almacenU) {
		this.almacenU = almacenU;
	}
}


