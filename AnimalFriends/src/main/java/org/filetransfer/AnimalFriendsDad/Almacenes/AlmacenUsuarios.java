package org.filetransfer.AnimalFriendsDad.Almacenes;

import java.io.Serializable;
import java.util.ArrayList;

import org.filetransfer.AnimalFriendsDad.Usuarios;

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
	
	
	public void setAlmacenUsuarios(ArrayList<Usuarios> almacenU) {
		this.almacenU = almacenU;
	}
	
	public boolean Registrar(Usuarios u){
        boolean insertado = false;
        for(Usuarios c : getAlmacenU()){
            if(almacenU.equals(u))
                return insertado;
        }
        insertado = almacenU.add(u);
        if(insertado)
            u.setId(++Usuarios.nUsuarios);
        return insertado;
    }
	
	public Usuarios estaRegistrado(String nom,String pwd){
        Usuarios usu = new Usuarios(nom,pwd);
        if(this.almacenU.contains(usu)){
            int i = this.almacenU.indexOf(usu);
            usu = (Usuarios) this.almacenU.get(i);
        }else{
            usu = null;
        }
        return usu;
    }
	
	  public Usuarios identificar(String nom,String pwd){

	        Usuarios usuario = estaRegistrado(nom,pwd);

	        return usuario;
	    }
}


