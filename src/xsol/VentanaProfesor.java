/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author AlbertoReyes
 */
public class VentanaProfesor extends Ventana{
    
    public VentanaProfesor(){
        
        PanelProfesor pro = new PanelProfesor(0,0, this.getWidth(), this.getHeight());
        
    }
    public class PanelProfesor{
        
        private JLabel descripcion;
        private JLabel nombre;
        private JLabel clav;
        private JLabel uni;
        private JTextField Nombre;
        private JTextField clave;
        private JTextField unica;
        
        public PanelProfesor(int x, int y, int width, int height){
            
            setBackground(Color.ORANGE);
            
            Font fuente = new Font("Verdana", Font.BOLD, 35);
            
            descripcion = new JLabel();
            descripcion.setVisible(true);
            descripcion.setText("Ingresa con tu clave Unica");
            descripcion.setForeground(Color.white);
            descripcion.setFont(fuente);
            descripcion.setLocation(20,0);
            descripcion.setSize(540, 100);
            descripcion.setOpaque(true);
            descripcion.setBackground(Color.red);
            add(descripcion);
            
        }
        
    }
    
}
