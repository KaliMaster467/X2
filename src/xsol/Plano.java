/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author AlbertoReyes
 */
public class Plano extends JPanel{
    
    /*public Plano(int ancho, int alto){
        
        setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);
        setSize(ancho, alto);
        setLocation(0, 0);
    }
    public void paintX(Graphics g){
        
        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.fillRect(this.getHeight() / 2, 0, this.getWidth(), 3);
        
    }
    public void paintY(Graphics g){
        
        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.fillRect(this.getWidth() / 2, 0, 3, this.getHeight());
        
    }*/
    public Plano(int ancho, int alto){
        
        init();
        setSize(ancho, alto);
        setLocation(0,0);
        
    }
    public void init(){
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
    }
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        g.setColor(Color.red);
        
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth()/2, this.getHeight());
        
    }
    public void paintSQRFunc(Graphics g, double x2mult, double x1mult, double cons,
            double x1, double x2){
        
        
        
    }
}
