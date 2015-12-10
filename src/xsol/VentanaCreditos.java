/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author AlbertoReyes
 */
public class VentanaCreditos extends Ventana{
    
    public VentanaCreditos(){
        
        
        
    }
    public class PanelCred extends JPanel{
        
        public PanelCred(int x, int y, int width, int height){
            
            setBackground(Color.white);
            setVisible(true);
            setLayout(null);
            setLocation(x, y);
            setSize(width, height);
            
        }
        
    }
    
}
