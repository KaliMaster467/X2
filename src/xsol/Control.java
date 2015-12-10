/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bugatti
 */
public class Control implements ActionListener{
    
    protected static VentanaInicion ini;
    protected static VentanaGraficadora graf;
    protected Registro reg;
    protected ListaUsuario users;
    protected Subir sub;
    private Archivo archivo = new Archivo();
    private Manejador man;
    private ApuntesAlumno al;
    protected static VentanaProfesor pro;
    
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Iniciar")) {
            int encontrado = 0;
            for(int i=0;i<Usuarios.size();i++) {
                if(Usuarios.get(i).getNombre().equals(ini.getUserReturn())) {
                    
                    if(Usuarios.get(i).getClave().equals(ini.getPassReturn())) {
                        JOptionPane.showMessageDialog(null, "Bienvenido "+Usuarios.get(i).getNombre());
                        graf = new VentanaGraficadora();
                        graf.VentanaGraficadoras();
                        ini.dispose();
                        encontrado = 1;
                        break;
                    }
                }
                
            }
            if(encontrado ==0)
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
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
                            ini.dispose();
                            pro.dispose();  
                        }else
                            JOptionPane.showMessageDialog(null, "Acceso Denegado");
                        
                    }
    }
}
    
    

