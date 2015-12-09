/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AlbertoReyes
 */
public class ApuntesAlumno extends Ventana{
    
    protected Control cont;
    public BarraLateral late;
    public Dimension dim;
    
    public ApuntesAlumno(){
        
         dim = super.getToolkit().getScreenSize();
        
        setVisible(true);
        setLocation(0, 0);
        setSize(dim);
        
       
        late = new BarraLateral(0, 0,(int)dim.getWidth(), (int)dim.getHeight());
        
        add(late);
        
    }
    public class BarraLateral extends JPanel{
        
        private Apu barra;
        
        public BarraLateral(int x, int y, int width, int height){
            
            setBackground(Color.orange);
            setVisible(true);
            setLayout(null);
            setLocation(x,y);
            setSize(width, height);
            
            barra = new Apu(0,0,this.getWidth()/3, this.getHeight());
            
            add(barra);
        }
    }
    public class Apu extends JPanel{
        
        private JButton prim;
        
        public Apu(int x, int y, int width, int height){
            
            setBackground(Color.white);
            setVisible(true);
            setLayout(null);
            setLocation(x, y);
            setSize(width, height);     
            
            prim = new JButton("Primer Parcial");
            prim.setVisible(true);
            prim.setOpaque(true);
            prim.setBorderPainted(false);
            prim.setBackground(Color.lightGray);
            prim.setForeground(Color.white);
            prim.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(prim);
            
        }
        
    }
    
}
