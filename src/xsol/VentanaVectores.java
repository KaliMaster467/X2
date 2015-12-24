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
public class VentanaVectores extends Ventana{
    
    private static PlanoVectores ve;
    
    public VentanaVectores(){
        
        ve = new PlanoVectores(this.getWidth()/2, (this.getHeight()/3)*2);
        add(ve);
        
    }
    private class PlanoVectores extends JPanel{
        
        private int ancho;
        private int alto;
        
        public PlanoVectores(int ancho, int alto){
            
            this.ancho = ancho;
            this.alto = alto;
            setSize(ancho, alto);
            init();
            setLocation(0,0);
            setVisible(true);
            
        }
        
        public void init() {

        this.setBorder(BorderFactory.createLineBorder(Color.black));

        }
        
        public void paintComponent(Graphics g){
            
            super.paintComponent(g);
            g.setColor(new Color(177, 228, 255));
            double los40divisiones = .000;
            for (int i = 0; i < 40; i++) {

                g.drawLine(0, (int) Math.floor(this.getHeight() * los40divisiones), ancho, (int) Math.floor(this.getHeight() * los40divisiones));
                g.drawLine((int) Math.floor(this.getWidth() * los40divisiones), 0, (int) Math.floor(this.getWidth() * los40divisiones), alto);
                los40divisiones += .025;
                

            }
            g.setColor(Color.red);

            g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
            g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());

        }
        
    }
    
}
