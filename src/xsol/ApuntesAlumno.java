/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private Apu barra;
    
    public ApuntesAlumno(){
        
         dim = super.getToolkit().getScreenSize();
        
        setVisible(true);
        setLocation(0, 0);
        setSize(dim);
        
       
        late = new BarraLateral(this.getWidth()/3, 0,/*(int)dim.getWidth()*/(this.getWidth()/3)*2, (int)dim.getHeight());
        
        getContentPane().add(late);
        
        barra = new Apu(0,0,this.getWidth()/3, this.getHeight());
            
        add(barra);
        
    }
    public int getPanelWidth(){
        
        return (this.getWidth()/3) * 2;
        
    }
    public int getPanelHeight(){
        
        return this.getHeight();
        
    }
    public int getPanelX(){
        
        return this.getWidth()/3;
        
    }
    public int getPanelY(){
        
        return 0;
       
    }
    public class BarraLateral extends JPanel{
        
        private Apu barra;
        private LeerFichero leer;
        
        public BarraLateral(int x, int y, int width, int height){
            
            setBackground(Color.orange);
            setVisible(true);
            setLayout(null);
            setLocation(x,y);
            setSize(width, height);
            
            /*barra = new Apu(0,0,this.getWidth()/3, this.getHeight());
            
            add(barra);*/
        }
        
    }
    public class Apu extends JPanel{
        
        private JButton prim;
        private JButton seg;
        private JButton ter;
        private JButton vid;
        private JButton eva;
        private Control cont;
        
        public Apu(int x, int y, int width, int height){
            
            cont = new Control();
            
            setBackground(Color.white);
            setVisible(true);
            setLayout(null);
            setLocation(x, y);
            setSize(width, height);
            
            int botonesw= this.getWidth();
            int botonesh= this.getHeight()/10;
            
            prim = new JButton("Primer Parcial");
            prim.setVisible(true);
            prim.setOpaque(true);
            prim.setBorderPainted(false);
            prim.setBackground(Color.lightGray);
            prim.setForeground(Color.white);
            prim.setLocation(0,0);
            prim.addActionListener(cont);
            prim.setSize(botonesw, botonesh);
            prim.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(prim);
            
            seg = new JButton("Segundo Parcial");
            seg.setVisible(true);
            seg.setLayout(null);
            seg.setLocation(0, prim.getHeight());
            seg.setSize(botonesw, botonesh);
            seg.setOpaque(true);
            seg.setBorderPainted(false);
            seg.setBackground(new Color(107, 185, 240));
            seg.setFont(new Font("Verdana", Font.PLAIN, 15));
            seg.setForeground(Color.white);
            add(seg);
            
            ter = new JButton("Tercer Parcial");
            ter.setVisible(true);
            ter.setLayout(null);
            ter.setOpaque(true);
            ter.setBorderPainted(false);
            ter.setLocation(0, prim.getHeight()+seg.getHeight());
            ter.setSize(botonesw, botonesh);
            ter.setBackground(new Color(255, 103, 103));
            ter.setForeground(Color.white);
            ter.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(ter);
            
            vid = new JButton("Videos");
            vid.setVisible(true);
            vid.setLayout(null);
            vid.setOpaque(true);
            vid.setBorderPainted(false);
            vid.setBackground(new Color(90, 255, 126));
            vid.setForeground(Color.white);
            vid.setLocation(0, prim.getHeight()+seg.getHeight()+ter.getHeight());
            vid.setSize(botonesw, botonesh);
            vid.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(vid);
            
            eva = new JButton("Exámenes");
            eva.setVisible(true);
            eva.setLayout(null);
            eva.setOpaque(true);
            eva.setBorderPainted(false);
            eva.setBackground(new Color(194, 83, 208));
            eva.setForeground(Color.white);
            eva.setFont(new Font("Verdana", Font.PLAIN, 15));
            eva.setLocation(0, prim.getHeight()+seg.getHeight()+ter.getHeight()+
                    vid.getHeight());
            eva.setSize(botonesw, botonesh);
            add(eva);
        }
        
    }
    
}
