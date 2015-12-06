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
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
        
        private Font font;
        private ImageIcon imagelap;
        private JLabel nombre, grupo, contra, confir;
        private JTextField nom, gru;
        private JPasswordField con, conf;
        private JButton registrarse;
        
        public PanelRegistro(int ancho, int alto){
            
            font = new Font("Verdana", Font.BOLD, 16);
            
            setVisible(true);
            setLayout(null);
            setLocation(0,0);
            setSize(ancho, alto);
            
            nombre = new JLabel();
            nombre.setText("Nombre:");
            nombre.setLocation(100, 50);
            nombre.setSize(100,20);
            nombre.setForeground(Color.black);
            nombre.setFont(font);
            add(nombre);
            
            grupo = new JLabel();
            grupo.setText("Grupo:");
            grupo.setLocation(100, 100);
            grupo.setSize(100, 20);
            grupo.setForeground(Color.black);
            grupo.setFont(font);
            add(grupo);
            
            contra = new JLabel();
            contra.setText("Contraseña:");
            contra.setLocation(100, 150);
            contra.setSize(176, 20);
            contra.setForeground(Color.black);
            contra.setFont(font);
            add(contra);
            
            confir = new JLabel();
            confir.setText("Confirmacion de \nContraseña:");
            confir.setLocation(100, 200);
            confir.setSize(432, 32);
            confir.setForeground(Color.black);
            confir.setFont(font);
            add(confir);
            
            Font fo = new Font("Verdana", Font.PLAIN, 16);
            
            nom = new JTextField();
            nom.setEditable(true);
            nom.setVisible(true);
            nom.setLocation(250, 50);
            nom.setSize(150, 20);
            nom.setForeground(Color.black);
            nom.setFont(fo);
            add(nom);
            
            gru = new JTextField();
            gru.setVisible(true);
            gru.setForeground(Color.black);
            gru.setFont(fo);
            gru.setLocation(250,100);
            gru.setSize(150, 20);
            add(gru);
            
            con = new JPasswordField();
            con.setVisible(true);
            con.setLayout(null);
            con.setEditable(true);
            con.setLocation(250, 150);
            con.setSize(150, 20);
            add(con);
            
            conf = new JPasswordField();
            conf.setVisible(true);
            conf.setLayout(null);
            conf.setEditable(true);
            conf.setLocation(365, 210);
            conf.setSize(150, 20);
            add(conf);
        }
        
        public void paint(Graphics g){
           
            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("escuela.jpg"));           
            
            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
       
            super.paint(g);
            
        }
    }
    
}
