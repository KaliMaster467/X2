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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bugatti
 */
public class Control implements ActionListener{
    
    protected static VentanaInicion ini;
    protected VentanaGraficadora graf;
    protected Registro reg;
    protected ListaUsuario users;
    private Archivo archivo = new Archivo();
    private Manejador man;
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
                        VentanaGraficadora graficadora = new VentanaGraficadora();
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
           
            VentanaProfesor pro = new VentanaProfesor();
            
        }
    }
    public void accionRegis(ActionEvent e){
        
        
        
    }
}
    
    

