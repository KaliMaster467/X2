/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Bugatti
 */
public class Manejador implements ActionListener{
    
    protected String accion;
    private Registro reg;
    private VentanaGraficadora graf;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        /*switch (e.getActionCommand()){
            
            case "Registro":
                
                accion = "Regtistro";
                
                break;
            case "Inicio":
                
                accion = "Inicion";
                
                break;
            
        }
        
    }
    public String getAccion(){
        
        return accion;
        
    }*/
        
        if(e.getActionCommand().equals("Registro")){
            
            reg = new Registro();
            
            
        }else
            if(e.getActionCommand().equals("Iniciar")){
                
                graf = new VentanaGraficadora();
                
            }
    }    
    
}
