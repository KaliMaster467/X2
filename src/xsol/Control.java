/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Bugatti
 */
public class Control implements ActionListener, KeyListener{
    
    protected static VentanaInicion ini;
    protected static VentanaGraficadora graf;
    private static VentanaVectores vec;
    protected Registro reg;
    protected ListaUsuario users;
    protected Usuario ud;
    protected static Subir sub;
    private Archivo archivo = new Archivo();
    private Manejador man;
    private static ApuntesAlumno al;
    protected static VentanaProfesor pro;
    protected static int id;
    protected String nombre;
    protected ImageIcon img;
    protected static VentanaConfiguracion config;
    
    public static ArrayList<Usuario> Usuarios = new ArrayList<>();
    
    
    public void Controls(){
        Usuarios = archivo.leer();
        try{
            ini = new VentanaInicion();
            ini.VentanaInicions();
        }catch(IOException e){
            
            JOptionPane.showMessageDialog(null, "Error");   
        }
    }
    /*public void addRegistro(){
        
        if(man.getAccion().equals("Registro")){
            
            reg = new Registro();
            
        }
        
    }*/
    public void removeVentana(Ventana ventana){
        
        ventana.dispose();
        
    }
    public int getId(){
        
        return id;
        
    }
    public String getNombre(){
        
        return nombre;
        
    }
    public ImageIcon getImage(){
        
        return img;
        
    }
    public String getUsuario(String usuario){
        
        return usuario;
        
    }
    public void Iniciar(){
        
            int encontrado = 0;
            for(int i=0;i<Usuarios.size();i++) {
                if(Usuarios.get(i).getNombre().equals(ini.getUserReturn())) {
                    
                    if(Usuarios.get(i).getClave().equals(ini.getPassReturn())) {
                        /*id = Usuarios.get(i).getId();
                        nombre = Usuarios.get(i).getNombre();
                        img = Usuarios.get(i).getImage();*/
                        ud = Usuarios.get(i);
                        JOptionPane.showMessageDialog(null, "Bienvenido "+Usuarios.get(i).getNombre());
                        graf = new VentanaGraficadora();
                        graf.VentanaGraficadoras(ud);
                        ini.dispose();
                        encontrado = 1;
                        
                        break;
                    }
                }
               
            }
            if(encontrado ==0)
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Iniciar")) {
            
            this.Iniciar();
            
        }
        else if(e.getActionCommand().equals("Registro")) {
            Registro reg = new Registro();
        }
        else if(e.getActionCommand().equals("Profesor")){
           
            pro = new VentanaProfesor();
            
        }else
            if(e.getActionCommand().equals("Cerrar")){
                
                graf.dispose();
                ini = new VentanaInicion();
            try {
                ini.VentanaInicions();
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }else
                if(e.getActionCommand().equals("Aula")){
                    
                    al = new ApuntesAlumno();
                    
                }else
                    if(e.getActionCommand().equals("Entrar")){
                        
                        if(pro.getUsuario().equals("Hermenegildo") && 
                                pro.getContraseña().equals("PI") &&
                                pro.getUnica().equals("hola")){
                            
                            JOptionPane.showMessageDialog(null, "Bienvenido Profesor");
                            sub = new Subir();
                            sub.SubirIn();
                            ini.dispose();
                            pro.dispose();  
                        }else
                            JOptionPane.showMessageDialog(null, "Acceso Denegado");
                        
                    }else if(e.getActionCommand().equals("Vectores")){
                        
                        vec = new VentanaVectores();
                        
                    }
                    else if(e.getActionCommand().equals("Creditos")) {
                        JOptionPane.showMessageDialog(null, "X-SolutYons\n\n-Ochoa Rodriguez Daniel Salvador\n-Reyes Briseño Alberto\n-Martinez Heredia Liam\n-El shavito");
                    }else
                        if(e.getActionCommand().equals("Regresar")){
                            
                            sub.dispose();
                            ini = new VentanaInicion();
                            try {
                            ini.VentanaInicions();
                            } catch (IOException ex) {
                                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }else if(e.getActionCommand().equals("Atras")){
                            
                            
                            al.dispose();
                            
                            
                        }else if(e.getActionCommand().equals("Configuración")){
                            
                                try {
                                    config = new VentanaConfiguracion();
                                } catch (IOException ex) {
                                     Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            
                        }else if(e.getActionCommand().equals("Subir nueva foto")){

                            ImageIcon imagen;
                            
                            JFileChooser cho = new JFileChooser();
                            int seleccion = cho.showOpenDialog(new JFrame());
                            if(seleccion == JFileChooser.APPROVE_OPTION){
                                
                                File fich = cho.getSelectedFile();
                                
                                try{
                        
                                    /*String cadena = "";
                                    int valor = fr.read();
                                    while(valor!=-1){
                            
                                        cadena = cadena+(char)valor;
                                        valor=fr.read();*/
                                    BufferedImage img = ImageIO.read(fich);
                                        
                                    //users.addImage(graf.getUsuario(), (ImageIcon)img);
                                    
                                    //Aqui se trata el archivo Dan.
                                    
                                    
                        
                                }catch(IOException ex){
                        
                                    ex.printStackTrace();
                        
                                }
                                
                            }
                            
                        }                
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    

