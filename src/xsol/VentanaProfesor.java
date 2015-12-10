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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author AlbertoReyes
 */
public class VentanaProfesor extends Ventana{ 
    
    private PanelProfesor pro;
    
    public VentanaProfesor(){
        
        setSize(600, 500);
        setLocation(310, 200);
        setResizable(false);
        setVisible(true);
        
        pro = new PanelProfesor(0,0, this.getWidth() , this.getHeight() );
        
        add(pro);
        
        /*int x = 0;
        int y = pro.getLabelHeight();
        int w = this.getWidth();
        int h = this.getHeight() - pro.getLabelHeight();*/
        
    }
    public String getUsuario(){
        
        return pro.getUsuario();
        
    }
    public String getContraseña(){
        
        return pro.getContraseña();
        
    }
    public String getUnica(){
        
        return pro.getUnica();
        
    }
    public class PanelProfesor extends JPanel{
        
        private JLabel descripcion;
        private JLabel nombre;
        private JLabel clav;
        private JLabel uni;
        private JTextField Nombre;
        private JTextField clave;
        private JTextField unica;
        private ImageIcon imagelap;
        private PanelLog pan;
        
        public PanelProfesor(int x, int y, int width, int height){
            
            setVisible(true);
            setLayout(null);
            setBounds(x, y, width, height);
            
            Font fuente = new Font("Verdana", Font.BOLD, 30);
            
            descripcion = new JLabel();
            descripcion.setVisible(true);
            descripcion.setText("Ingresa con tu clave Unica.");
            descripcion.setForeground(Color.white);
            descripcion.setFont(fuente);
            descripcion.setLocation(20,0);
            descripcion.setSize(width, 100);
            add(descripcion);    
            
            pan = new PanelLog(0,descripcion.getHeight(), this.getWidth(),
            this.getHeight()-descripcion.getHeight());
            
            add(pan);
            
            
        }
        public String getUsuario(){
            
            return pan.getUsuario();
            
        }
        public String getContraseña(){
            
            return pan.getContraseña();
            
        }
        public String getUnica(){
            
            return pan.getClaveUnica();
            
        }
        public int getLabelWidth(){
            
            return descripcion.getWidth();
            
        }
        public int getLabelHeight(){
            
            return descripcion.getHeight();
            
        }
        public void paint(Graphics g){
            
            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("Prof.jpg"));           
            
            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
            super.paint(g);
            
        } 
        
    }
    public class PanelLog extends JPanel{
        
        private JLabel descripcion;
        private JLabel nombre;
        private JLabel clav;
        private JLabel uni;
        private JTextField Nombre;
        private JPasswordField clave;
        private JPasswordField unica; 
        private JButton bot;
        private Control cont;
        private String usuario;
        private String contra;
        private String conun;
        
        public PanelLog(int x, int y, int width, int height){
            
            setVisible(true);
            setBackground(Color.white);
            setLocation(x, y);
            setSize(width, height);
            setLayout(null);
            
            cont = new Control();
            
            Font fu = new Font("Verdana", Font.PLAIN, 16);
            
            nombre = new JLabel();
            nombre.setVisible(true);
            nombre.setLayout(null);
            nombre.setText("Nombre:");
            nombre.setForeground(Color.black);
            nombre.setFont(fu);
            nombre.setLocation(100, 50);
            nombre.setSize(120, 30);
            add(nombre);
            
            Nombre = new JTextField();
            Nombre.setEditable(true);
            Nombre.setLocation(250, 50);
            Nombre.setSize(200, 30);
            add(Nombre);
                    
            clav = new JLabel();
            clav.setVisible(true);
            clav.setLayout(null);
            clav.setText("Contraseña:");
            clav.setFont(fu);
            clav.setForeground(Color.BLACK);
            clav.setLocation(100, 120);
            clav.setSize(120, 30);
            add(clav);
            
            clave = new JPasswordField();
            clave.setVisible(true);
            clave.setLayout(null);
            clave.setLocation(250, 120);
            clave.setSize(200, 30);
            add(clave);
            
            
            uni = new JLabel();
            uni.setVisible(true);
            uni.setText("Clave Unica:");
            uni.setForeground(Color.black);
            uni.setLayout(null);
            uni.setLocation(100, 190);
            uni.setSize(192, 30);
            uni.setFont(fu);
            add(uni);
            
            unica = new JPasswordField();
            unica.setVisible(true);
            unica.setLayout(null);
            unica.setLocation(250, 190);
            unica.setSize(200, 30);
            add(unica);
            
            
            bot = new JButton("Entrar");
            bot.setVisible(true);
            bot.setLayout(null);
            bot.setSize(this.getWidth(), 80);
            bot.setLocation(0, this.getHeight() - bot.getHeight());
            bot.setOpaque(true);
            bot.setFont(fu);
            bot.setBorderPainted(false);
            bot.addActionListener(cont);
            bot.setBackground(Color.black);
            bot.setForeground(Color.white);
            add(bot);
        }
        public String getUsuario(){
            usuario= Nombre.getText();
            return usuario;
            
        }
        public String getContraseña(){
            contra= clave.getText();
            return contra;
            
        }
        public String getClaveUnica(){
            conun = unica.getText();
            return conun;
            
        }
    }
    
}
