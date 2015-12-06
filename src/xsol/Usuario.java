/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.io.Serializable;

/**
 *
 * @author Bugatti
 */
public class Usuario implements Serializable{
    
    private final String nombre;
    private String clave;
    private String grupo;
    
    public Usuario(String nombre, String clave, String grupo){
        
        this.nombre = nombre;
        this.clave = clave;
        this.grupo = grupo;
        
        id += IdSig;
        
    }
    public Usuario(String nombre){
        
        this.nombre = nombre;
        
    }
    public int getId(){
        
        return id;
        
    }
    public void setClave(String clave){
        
        this.clave = clave;
        
    }
    public void setGrupo(){
        
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
    private static int IdSig = 1;
    private int id = 0;
}
