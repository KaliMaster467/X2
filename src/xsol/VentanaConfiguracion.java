/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rey
 */
public class VentanaConfiguracion extends Ventana{
    
    private double width;
    private double height;
    private BarraArriba barar;
    private Prin pri;
    private Otr ot;
    private Localizar loc;
    
    public VentanaConfiguracion() throws IOException{
        
        setVisible(true);
        setLocation(310, 200);
        setSize(600, 500);
        setLayout(null);
        setResizable(false);
        
        
        
        width = dim.getWidth();
        height = dim.getHeight();
        
        barar = new BarraArriba(this.getWidth(), 100);
        
        add(barar);
        
        pri = new Prin(0, barar.getHeight(),this.getWidth()/3,this.getHeight()-barar.getHeight());
        
        add(pri);
        
        ot = new Otr(pri.getWidth(),barar.getHeight(),this.getWidth()-pri.getWidth(),this.getHeight()-barar.getHeight());
   
        add(ot);
        
    }
    private class BarraArriba extends JPanel{
        
        private ImageIcon imagelap;
        private JLabel ima;
        private JLabel tit;
        
        public BarraArriba(int width, int height) throws IOException{
            
            setVisible(true);
            setLayout(null);
            setLocation(0,0);
            setSize(width, height);
            
            BufferedImage im = ImageIO.read(this.getClass().getResource("configuracion.png"));
            
            ima = new JLabel(new ImageIcon(im));
            ima.setVisible(true);
            ima.setLayout(null);
            ima.setLocation(0,0);
            ima.setSize(this.getWidth()/5,this.getHeight());
            add(ima);
            
            tit = new JLabel();
            tit.setVisible(true);
            tit.setLayout(null);
            tit.setText("Configuración");
            tit.setLocation(ima.getWidth(), 0);
            tit.setSize(this.getWidth()-ima.getWidth(), this.getHeight());
            tit.setForeground(Color.black);
            tit.setFont(new Font("Verdana", Font.PLAIN, 30));
            add(tit);
            
            
        }
        public void paint(Graphics g) {

            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("backcon.jpg"));

            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);

            super.paint(g);

        }        
        
    }
    private class Prin extends JPanel{
        
        private JButton bor;
        
        public Prin(int x, int y, int width, int height){
            
            setVisible(true);
            setLayout(null);
            setLocation(x, y);
            setSize(width, height);
            setBackground(Color.lightGray);
            
            bor = new JButton("Cuenta");
            bor.setVisible(true);
            bor.setOpaque(true);
            bor.setBorderPainted(false);
            bor.setLocation(0,0);
            bor.setSize(this.getWidth(),this.getHeight()/10);
            add(bor);
            
        }
        
    }
    private class Otr extends JPanel{
        
        private JButton sub;
        private Control cont;
        
        public Otr(int x, int y, int width, int height){
            
            
            cont = new Control();
            
            setVisible(true);
            setBackground(Color.white);
            setLocation(x,y);
            setSize(width, height);
            
            sub = new JButton("Subir nueva foto");
            sub.setVisible(true);
            sub.setLocation(0,0);
            sub.setSize(100, 50);
            sub.addActionListener(cont);
            add(sub);
            
            
        }
        
    }
    
}
