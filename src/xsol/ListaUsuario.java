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
    public static ArrayList<Usuario> use = new ArrayList<>();
    private Archivo ar;
    private String nombre;
    private String clave;
    private String grupo;
    
    public ListaUsuario(){
        
        use = ar.leer();
        
    }
    public void agregarUsuario(){
            
        Usuario user = new Usuario(nombre, clave, grupo);
        use.add(user);
        
    }
    public void eliminarUsualrio(String nombre){
        
        boolean encontrado = false;
        
        for(int i = 0; i<use.size();i++){
            
            if(nombre.equals(use.get(i).getNombre())){
                
                
                
            }
            
        }
        
    }
    public void setNombre(String nombre){
        
        this.nombre = nombre;
        
    }
    public void setClave(String clave){
        
        this.clave = clave;
        
    }
    public void setGrupo(String grupo){
        
        this.grupo = grupo;
        
    }
    public String getNombre(){
        
        return nombre;
        
    }
    public String getClave(){
        
        return clave;
        
    }
    public String getGrupo(){
        
        return grupo;
        
    } 
    public void encontrarUsuario(){
        
    }
    public void cerrarArchivo(){
        ar.Serializar(use);
    }
}
