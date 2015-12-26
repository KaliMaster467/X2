/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Bugatti
 */
public class Usuario implements Serializable{
    
    private final String nombre;
    private String clave;
    private String grupo;
    private ImageIcon img;
    
    public Usuario(String nombre, String clave, String grupo) throws IOException{
        
        this.nombre = nombre;
        this.clave = clave;
        this.grupo = grupo;
        
        BufferedImage im = ImageIO.read(this.getClass().getResource("usuario.png"));
        
        img = new ImageIcon(im);
        
        id += IdSig;
        
        
    }
    public Usuario(String nombre){
        
        this.nombre = nombre;
        
    }
    public ImageIcon getImage(){
        
        return img;
        
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
    public void setImage(ImageIcon perfil){
        
        perfil = img;
        
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
