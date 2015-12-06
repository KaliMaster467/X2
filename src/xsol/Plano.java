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
    int ancho = 0;
    int alto = 0;
    double X1, Y1, Ent;

    public double getX1() {
        return X1;
    }

    public void setX1(double X) {
        this.X1 = X;
    }

    public double getY1() {
        return Y1;
    }

    public void setY1(double Y) {
        this.Y1 = Y;
    }

    public double getEnt() {
        return Ent;
    }

    public void setEnt(double Ent) {
        this.Ent = Ent;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    int tipo;
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
        this.ancho =ancho;
        this.alto = alto;
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
        g.setColor(new Color(177,228,255));
        double los40divisiones = .000;
        for(int i= 0;i<40;i++) {
            
            g.drawLine(0, (int)Math.floor(this.getHeight()*los40divisiones) , ancho, (int)Math.floor(this.getHeight()*los40divisiones));
            g.drawLine((int)Math.floor(this.getWidth()*los40divisiones),0 , (int)Math.floor(this.getWidth()*los40divisiones), alto);
            los40divisiones += .025;
            
        }
        //PINTAR GRAFICA INGRESADA
        if(tipo!=0) {
            
            //Recta
            //ME PARTI EL ORTO CON ESTA :v
            if(this.tipo==1) {
                g.setColor(new Color(115, 255, 147));
                g.setColor(Color.BLACK);
                int x1=80;
                int x2=79;
                double las160divisiones = .00000;
                los40divisiones = .000;
                for(int z = 0; z<160;z++) {
                        double Y5 = ((-((this.X1)*x1)) -(this.Ent))/this.Y1;
                        double Y2 = ((-((this.X1)*x2)) -(this.Ent))/this.Y1;
                        int y1graf = (int)Math.floor((this.getHeight()/2)-(Y5*(getHeight()*0.025)));
                        int y2graf = (int)Math.floor((this.getHeight()/2)-(Y2*(getHeight()*0.025)));
                        int x1graf = (int)Math.floor((this.getWidth()/2)+(x1*(getWidth()*0.025)));
                        los40divisiones += .025;
                        int x2graf = (int)Math.floor((this.getWidth()/2)+(x2*(getWidth()*0.025)));
                        x1=x2;
                        x2--;
                        g.drawLine(x1graf, y1graf, x2graf, y2graf);
                
                    }
                }
            //AQUI HAZ LAS OTRAS PINSHES TIPOS DE GRAFICAS
                
                
            }
            
            
            
            
            
        
        
        
        
        
        
        g.setColor(Color.red);
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth()/2, this.getHeight());
        
    }
    public void paintSQRFunc(Graphics g, double x2mult, double x1mult, double cons,
            double x1, double x2){
        
        
        
    }
}

