/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Bugatti
 */
public class Registro extends Ventana{
    
    private PanelRegistro reg;
    
    public Registro(){
        
        setSize(600, 400);
        reg = new PanelRegistro(600, 400);
        add(reg);
        
    }
    public class PanelRegistro extends JPanel{
        
        private ImageIcon imagelap;
        private JLabel nombre, grupo, contra, confir;
        private JButton registrarse;
        
        public PanelRegistro(int ancho, int alto){
            
            setVisible(true);
            setLayout(null);
            setLocation(0,0);
            setSize(ancho, alto);
            
            nombre = new JLabel();
            nombre.setText("Nombre");
            
            
        }
        
        public void paint(Graphics g){
           
            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("libros.png"));           
            
            
            
            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
       
            super.paint(g);
            
        }
    }
    
}
