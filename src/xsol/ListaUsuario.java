/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.util.ArrayList;

/**
 *
 * @author Bugatti
 */
public class ListaUsuario {
    private ArrayList<Usuario> user;
    private Archivo ar;
    
    public ListaUsuario(){
        
        user = ar.leer();
        
    }
    public void agregarUsuario(){
        
    }
    public void encontrarUsuario(){
        
    }
    public void cerrarArchivo(){
        ar.Serializar(user);
    }
}
