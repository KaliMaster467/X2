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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
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
public class VentanaInicion extends Ventana{
    
    private static BarraArriba alt;
    private BarraAbajo baj;
    protected String accion;
    
    public VentanaInicion() throws IOException{
        
        add(alt = new BarraArriba(this.getWidth(), this.getHeight() / 2));
        
        baj = new BarraAbajo(0, this.getHeight() / 2, this.getWidth(), this.getHeight());
        
        add(baj);   
        
        this.accion = alt.accion;
        
    }
    
    public class BarraArriba extends JPanel implements ActionListener{
        
    private JTextField userReturned;
    private JPasswordField passReturned;
    private JLabel usuario;
    private JLabel contraseña;
    private JLabel imag;
    private int width;
    private int height;
    private Font fuente;
    private JButton iniciar;
    private JButton registrarse;
    protected String accion;
        
    public BarraArriba(int width, int height) throws IOException {
        
        fuente = new Font("Verdana", Font.PLAIN, 15);
        
        this.width = width;
        this.height = height;
        
        //Caracteristicas de la ventana
        
        setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);
        setLocation(0,0);
        setSize(width, height);
        
        //Crea la zona de texto para el usuario
        
        userReturned = new JTextField();
        userReturned.setVisible(true);
        userReturned.setLayout(null);
        userReturned.setSize(200, 30);
        userReturned.setLocation(200, this.getHeight() /3 );
        userReturned.setFont(fuente);
        
        add(userReturned);
        
        //crea la etiqueta
        
        usuario = new JLabel();
        usuario.setVisible(true);
        usuario.setLayout(null);
        usuario.setLocation(100, this.getHeight() /3 );
        usuario.setSize(200, 25);
        usuario.setText("Usuario: ");
        usuario.setFont(fuente);
        usuario.setForeground(Color.BLACK);
                
        add(usuario);
        
        //Crea el area de texto para la contraseña
        
        passReturned = new JPasswordField();
        passReturned.setVisible(true);
        passReturned.setLayout(null);
        passReturned.setSize(200, 30);
        passReturned.setLocation(200, 200);
        
        add(passReturned);
        
        //Crea la etiqueta para la contraseña
        
        contraseña = new JLabel();
        contraseña.setText("Contraseña: ");
        contraseña.setVisible(true);
        contraseña.setLayout(null);
        contraseña.setFont(fuente);
        contraseña.setLocation(100, 200);
        contraseña.setSize(200, 30);
        contraseña.setForeground(Color.BLACK);
        
        add(contraseña);
        
        //Crea el boton de inicio
        
        iniciar = new JButton("Iniciar");
        iniciar.setVisible(true);
        iniciar.setLayout(null);
        iniciar.addActionListener(this);
        iniciar.setText("Iniciar");
        iniciar.setLocation(100, 280);
        iniciar.setSize(100, 30);
        
        add(iniciar);
        
        //Crea el boton de registro
        
        registrarse = new JButton("Registro");
        registrarse.setVisible(true);
        registrarse.setLayout(null);
        registrarse.addActionListener(this);
        registrarse.setLocation(300, 280);
        registrarse.setSize(100, 30);
        
        add(registrarse);
        
         
        BufferedImage wPic = ImageIO.read(this.getClass().getResource("showimage.png"));
        
        JLabel wIcon = new JLabel(new ImageIcon(wPic));
        
        wIcon.setLocation(900, 120);
        wIcon.setSize(wPic.getWidth(), wPic.getHeight());
        wIcon.setVisible(true);
        wIcon.setLayout(null);
        wIcon.setToolTipText("La mejor graficadora papu");
        
        add(wIcon);
  
    }
    
    public int getWidth(){
        
        return width;
        
    }
    public int getHeight(){
        
        return height;
        
    }
    public Font getFont(){
        
        return fuente;
        
    }
    public String getUserText(){
        
        return userReturned.getText();
        
    }
    public String getUserPass(){
        
        return contraseña.getText();
        
    }
    public String getAction(String accion){
        
        return accion;
        
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            accion = e.getActionCommand();
        }
        
    }
    public class BarraAbajo extends JPanel{
        
        private final JLabel des;
        private ImageIcon imagelap;
        
        public BarraAbajo(int x, int y, int width, int height) throws IOException{
            
            setVisible(true);
            setLayout(null);
            setBackground(Color.DARK_GRAY);
            setLocation(x, y);
            setSize(width, height);
            
            //BufferedImage pic = ImageIO.read(this.getClass().getResource("imageslap.jpeg"));
            
           // setBackground(pic);
            
            des = new JLabel();
            des.setVisible(true);
            des.setLayout(null);
            des.setLocation(100, 2);
            des.setSize(width, 200);
            des.setFont(new Font("Verdana", Font.PLAIN, 30));
            des.setForeground(Color.WHITE);
            des.setText("La mejor Graficadora de este mundo.");
            
            add(des);
            
        }
        public void paint(Graphics g){
            
            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("alumnosjpg.jpg"));           
            
            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
            super.paint(g);
            
        } 
    }
    
}
