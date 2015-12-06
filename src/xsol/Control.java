/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Bugatti
 */
public class Control implements ActionListener{
    
    protected static VentanaInicion ini;
    protected VentanaGraficadora graf;
    protected Registro reg;
    protected ListaUsuario users;
    
    public void removeVentana(Ventana ventana){
        
        ventana.dispose();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ini.accion.equals("Registro")){
            
            
            
        }
    }
    
}
