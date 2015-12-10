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
 * @author DANY
 */
public class Subir extends Ventana{
    public BarraLateral late;
    protected Control cont;
    public Dimension Dim;
    public Subir() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dim = super.getToolkit().getScreenSize();
        
        setVisible(true);
        setLocation(0,0);
        setSize(dim);
        
        late = new BarraLateral(0,0, (int)dim.getWidth(), (int)dim.getHeight());
        add(late);
    }
    public class BarraLateral extends JPanel{
    private Exames barra;
    public BarraLateral(int x, int y, int width, int height) {
        setBackground(Color.red);
        setVisible(true);
        setLayout(null);
        setLocation(x,y);
        setSize(width, height);
        
        barra = new Exames(0,0,this.getWidth()/6, this.getHeight()) ;
        add(barra); 
        }
        
    }
    public class Exames extends JPanel{
        private JButton Subido;
        private JButton Modificado;
        private JButton elim;
        private JButton reg;
        
        public Exames(int x, int y, int width, int height) {
            setBackground(Color.white);
            setVisible(true);
            setLayout(null);
            setLocation(x,y);
            setSize(width, height);
            
            int botonesW = this.getWidth();
            int botonesH = this.getHeight()/4;
            
            Subido = new JButton("SUBIR\nEXAMEN");
            Subido.setVisible(true);
            Subido.setOpaque(true);
            Subido.setBorderPainted(false);
            Subido.setBackground(Color.lightGray);
            Subido.setForeground(Color.white);
            Subido.setLocation(0,0);
            Subido.setSize(botonesW, botonesH);
            Subido.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(Subido);
            
            Modificado = new JButton("MODIFICAR\nEXAMEN");
            Modificado.setVisible(true);
            Modificado.setOpaque(true);
            Modificado.setBorderPainted(false);
            Modificado.setBackground(Color.black);
            Modificado.setForeground(Color.white);
            Modificado.setLocation(0,Subido.getHeight());
            Modificado.setSize(botonesW, botonesH);
            Modificado.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(Modificado);
            
            elim = new JButton("ELIMINAR\nEXAMEN");
            elim.setVisible(true);
            elim.setOpaque(true);
            elim.setBorderPainted(false);
            elim.setBackground(Color.MAGENTA);
            elim.setForeground(Color.white);
            elim.setLocation(0,(Subido.getHeight())*2);
            elim.setSize(botonesW, botonesH);
            elim.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(elim);
            
            reg = new JButton("REGRESAR");
            reg.setVisible(true);
            reg.setOpaque(true);
            reg.setBorderPainted(false);
            reg.setBackground(Color.pink);
            reg.setForeground(Color.white);
            reg.setLocation(0,Subido.getHeight()*3);
            reg.setSize(botonesW, botonesH);
            reg.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(reg);
            
            
        }
    }
}


