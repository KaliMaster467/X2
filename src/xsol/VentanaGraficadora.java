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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Bugatti
 */
public class VentanaGraficadora extends Ventana{
    TablaRes tab;
    protected double width;
    protected double height;
    public static Plano plano;
    
    public VentanaGraficadora(){
        
        width = dim.getWidth();
        height = dim.getHeight();
        int anchoPlano = (int)Math.floor(width*.7);
        int altoPlano = (int)Math.floor(height*.7);
        plano = new Plano(anchoPlano, altoPlano);
        this.setResizable(true);
        add(plano);
        int anchoTabla = (int)Math.floor(width*.3);
        tab = new TablaRes(anchoTabla, altoPlano, anchoPlano);
        
        add(tab);
        
        setVisible(true);
    }
    
    public class TablaRes extends JPanel implements ItemListener, ActionListener{
    JLabel X, Y, tabla, xValor, yValor, enteros;
    JComboBox tipoTabla;
    private Font fuente;
    private ImageIcon imagelap;
    JTextField valorX, valorY, valorEnt;
    JButton Grafica;
    
    
    
    
    public TablaRes(int anchos, int altos, int ancho) {
        fuente = new Font("Verdana", Font.BOLD, 15);
        
        setBackground(Color.GRAY);
        setVisible(true);
        setLayout(null);
        setLocation((ancho+1), 0);
        setSize(anchos, altos);
        //PUSE EL JBUTTON PARA GRAFICAR
        Grafica = new JButton("Grafica!");
        Grafica.setBounds(120, 110, 110, 30);
        Grafica.setVisible(true);
        Grafica.addActionListener(this);
        
        add(Grafica);
        //PUSE LOS TEXTFIELD
        valorX = new JTextField();
        valorX.setBounds(30, 70, 80, 30);
        valorX.setText("");
        valorX.setVisible(true);
        valorX.setEnabled(false);
        valorX.addActionListener(this);
        
        add(valorX);
        
        valorY = new JTextField();
        valorY.setBounds(135, 70, 80, 30);
        valorY.setEnabled(false);
        valorY.addActionListener(this);
        
        add(valorY);
        
        valorEnt = new JTextField();
        valorEnt.setBounds(280, 70, 80, 30);
        valorEnt.setText("");
        valorEnt.setVisible(true);
        valorEnt.setEnabled(false);
        valorEnt.addActionListener(this);
        
        add(valorEnt);
        
        tipoTabla = new JComboBox();
        tipoTabla.addItem("Seleccione un tipo de Grafica.");
        tipoTabla.addItem("Recta");
        tipoTabla.addItem("Parabola");
        tipoTabla.addItem("Elipse");
        tipoTabla.addItem("Hiperbole");
        tipoTabla.addItemListener(this);
        tipoTabla.setBounds(100, 10, 200, 30);
        //LOS JLABEL DE LOS VALORES
        enteros = new JLabel();
        enteros.setText("Entero: ");
        enteros.setVisible(true);
        enteros.setLayout(null);
        enteros.setFont(fuente);
        enteros.setLocation(220, 70);
        enteros.setSize(500, 30);
        enteros.setForeground(Color.WHITE);
        
        add(enteros);
        
        yValor = new JLabel();
        yValor.setText("y: ");
        yValor.setVisible(true);
        yValor.setLayout(null);
        yValor.setFont(fuente);
        yValor.setLocation(115, 70);
        yValor.setSize(500, 30);
        yValor.setForeground(Color.WHITE);
        
        add(yValor);
        
        xValor = new JLabel();
        xValor.setText("x: ");
        xValor.setVisible(true);
        xValor.setLayout(null);
        xValor.setFont(fuente);
        xValor.setLocation(10, 70);
        xValor.setSize(500, 30);
        xValor.setForeground(Color.WHITE);
        
        add(xValor);
                
        add(this.tipoTabla);
        
        tabla = new JLabel();
        tabla.setText("|                        TABLA                     |");
        tabla.setVisible(true);
        tabla.setLayout(null);
        tabla.setFont(fuente);
        tabla.setLocation(50, 140);
        tabla.setSize(500, 30);
        tabla.setForeground(Color.WHITE);
        
        add(tabla);
        
        X = new JLabel();
        X.setText("|            X            |");
        X.setVisible(true);
        X.setLayout(null);
        X.setFont(fuente);
        X.setLocation(50, 170);
        X.setSize(200, 30);
        X.setForeground(Color.WHITE);
        
        add(X);
        Y = new JLabel();
        Y.setText("|            Y           |");
        Y.setVisible(true);
        Y.setLayout(null);
        Y.setFont(fuente);
        Y.setLocation(200, 170);
        Y.setSize(200, 30);
        Y.setForeground(Color.WHITE);
        
        add(Y);
        
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() instanceof JComboBox) {
                valorX.setEnabled(true);
                valorY.setEnabled(true);
                valorEnt.setEnabled(true);
                
                int cual = tipoTabla.getSelectedIndex();
                
                //AQUI SE LE PASA EL TIPO DE GRAFICA A EL PLANO
                if (cual != 0) {
                    if (cual == 1) {
                        plano.setTipo(cual);
                        
                    } else {
                        if (cual == 2) {
                            plano.setTipo(cual);
                        } else {
                            if (cual == 3) {
                                plano.setTipo(cual);
                            } else {
                                if (cual == 4) {
                                    plano.setTipo(cual);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void paint(Graphics g){
            
            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("bgtab.jpg"));           
            
            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
            super.paint(g);
            
            
            
        } 

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Grafica!")) {
                //AQUI SE PASA EL VALOR DE X Y EL ENTERO Y SE HACE EL REPAINT
                plano.setX1(Double.parseDouble(valorX.getText()));
                plano.setY1(Double.parseDouble(valorY.getText()));
                plano.setEnt(Double.parseDouble(valorEnt.getText()));
                
                plano.repaint();
                
            }
            
        }
    }
    
}
