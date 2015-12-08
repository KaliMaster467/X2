/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Bugatti
 */
public class Ventana extends JFrame{
    protected Dimension dim;
    
    public Ventana(){
        
        dim = super.getToolkit().getScreenSize();
        setLocation(0,0);
        setSize((int)dim.getWidth(), (int)dim.getHeight());
        setVisible(true);
        setLayout(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("X-Solutions");
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("showimage.png"));
        
        setIconImage(icon);
        
    }
}
