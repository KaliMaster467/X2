/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
    private Manejador man;
    
    public Control(){
        
        try{
            ini = new VentanaInicion();
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
        if(e.getSource() == ini.accion){
            
           reg = new Registro(); 
            
        }
    }
    
}
