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
import javax.swing.JToolBar;

/**
 *
 * @author Bugatti
 */
public class VentanaGraficadora extends Ventana{
    TablaRes tab;
    protected Ayuda ayuda;
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
        
        int xa = 0;
        int hei = (int) (height - plano.getHeight());
        int ya = plano.getHeight();
        int wi = (int) width;
        ayuda = new Ayuda(xa, ya, wi, hei);
        
        add(ayuda);
        
        setVisible(true);
    }
    
    public class TablaRes extends JPanel implements ItemListener, ActionListener{
    JLabel X, Y, tabla, xValor, yValor, enteros, x2Valor, y2Valor;
    JComboBox tipoTabla;
    private Font fuente;
    private ImageIcon imagelap;
    JTextField valorX, valorY, valorEnt, valorX2, valorY2;
    JButton Grafica;
    private int tipograf;
    
    
    
    public TablaRes(int anchos, int altos, int ancho) {
        fuente = new Font("Verdana", Font.BOLD, 15);
        
        setBackground(Color.GRAY);
        setVisible(true);
        setLayout(null);
        setLocation((ancho+1), 0);
        setSize(anchos, altos);
        //PUSE EL JBUTTON PARA GRAFICAR
        Grafica = new JButton("Grafica!");
        //Grafica.setBounds(140, 150, 110, 30);
        Grafica.setVisible(true);
        Grafica.setLocation(0, (this.getHeight()- 30));
        Grafica.setSize(this.getWidth(), 30);
        Grafica.addActionListener(this);
        
        add(Grafica);
        //PUSE LOS TEXTFIELD
        valorX = new JTextField();
        valorX.setBounds(30, 70, 80, 30);
        valorX.setText("");
        valorX.setVisible(false);
        valorX.setEnabled(false);
        valorX.addActionListener(this);
        
        add(valorX);
        
        valorX2 = new JTextField();
        valorX2.setBounds(30, 100, 80, 30);
        valorX2.setText("");
        valorX2.setVisible(false);
        valorX2.setEnabled(false);
        valorX2.addActionListener(this);
        
        add(valorX2);
        
        valorY = new JTextField();
        valorY.setBounds(140, 70, 80, 30);
        valorY.setText("");
        valorY.setEnabled(false);
        valorY.setVisible(false);
        valorY.addActionListener(this);
        
        add(valorY);
        
        valorY2 = new JTextField();
        valorY2.setBounds(140, 100, 80, 30);
        valorY2.setText("");
        valorY2.setEnabled(false);
        valorY2.setVisible(false);
        valorY2.addActionListener(this);
        
        add(valorY2);
        
        valorEnt = new JTextField();
        valorEnt.setBounds(280, 70, 80, 30);
        valorEnt.setText("");
        valorEnt.setVisible(false);
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
        enteros.setVisible(false);
        enteros.setLayout(null);
        enteros.setFont(fuente);
        enteros.setLocation(220, 70);
        enteros.setSize(500, 30);
        enteros.setForeground(Color.WHITE);
        
        add(enteros);
        
        x2Valor = new JLabel();
        x2Valor.setText("Y²: ");
        x2Valor.setVisible(false);
        x2Valor.setLayout(null);
        x2Valor.setFont(fuente);
        x2Valor.setBounds(10, 100, 500, 30);
        x2Valor.setForeground(Color.WHITE);
        
        add(x2Valor);
        
        y2Valor = new JLabel();
        y2Valor.setText("Y²: ");
        y2Valor.setVisible(false);
        y2Valor.setLayout(null);
        y2Valor.setFont(fuente);
        y2Valor.setBounds(115, 100, 500, 30);
        y2Valor.setForeground(Color.WHITE);
        
        add(y2Valor);
        
        yValor = new JLabel();
        yValor.setText("y: ");
        yValor.setVisible(false);
        yValor.setLayout(null);
        yValor.setFont(fuente);
        yValor.setLocation(115, 70);
        yValor.setSize(500, 30);
        yValor.setForeground(Color.WHITE);
        
        add(yValor);
        
        xValor = new JLabel();
        xValor.setText("x: ");
        xValor.setVisible(false);
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
        tabla.setLocation(50, 180);
        tabla.setSize(500, 30);
        tabla.setForeground(Color.WHITE);
        
        add(tabla);
        
        X = new JLabel();
        X.setText("|            X            |");
        X.setVisible(true);
        X.setLayout(null);
        X.setFont(fuente);
        X.setLocation(50, 210);
        X.setSize(200, 30);
        X.setForeground(Color.WHITE);
        
        add(X);
        Y = new JLabel();
        Y.setText("|            Y           |");
        Y.setVisible(true);
        Y.setLayout(null);
        Y.setFont(fuente);
        Y.setLocation(200, 210);
        Y.setSize(200, 30);
        Y.setForeground(Color.WHITE);
        
        add(Y);
        
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() instanceof JComboBox) {
                
                
                int cual = tipoTabla.getSelectedIndex();
                
                //AQUI SE LE PASA EL TIPO DE GRAFICA A EL PLANO
                //TEXT FIELD VALOR AL FINAL
                if (cual != 0) {
                    if (cual == 1) {
                        JOptionPane.showMessageDialog(null, "Llena todos los espacios");
                        valorX.setEnabled(true);
                        valorY.setEnabled(true);
                        valorEnt.setEnabled(true);
                        plano.setTipo(cual);
                        tipograf = 1;
                        valorX.setText("");
                        valorX.setVisible(true);
                        valorY.setText("");
                        valorY.setVisible(true);
                        valorEnt.setText("");
                        valorEnt.setVisible(true);
                        xValor.setVisible(true);
                        xValor.setText("x: ");
                        yValor.setVisible(true);
                        yValor.setText("y: ");
                        enteros.setVisible(true);
                        enteros.setText("Entero: ");
                        x2Valor.setVisible(false);
                        x2Valor.setText("");
                        
                        valorX2.setVisible(false);
                        valorX2.setText("");
                        
                        y2Valor.setVisible(false);
                        y2Valor.setText("");
                        valorY2.setVisible(false);
                        valorY2.setText("");
                        
                        
                        
                    } else 
                        if (cual == 2) {
                         char verticalXOY = 'z';
                         while(verticalXOY!='x'&&verticalXOY!='X'&&verticalXOY!='y'&&verticalXOY!='Y') {
                          verticalXOY = (JOptionPane.showInputDialog(null, "La elipse es paralela en X o en Y? (Teclea X o Y)").charAt(0));
                          if(verticalXOY=='x'||verticalXOY=='y'||verticalXOY=='X'||verticalXOY=='Y') { 
                            
                            tipograf = 2;
                            
                            valorY.setEnabled(true);
                            valorEnt.setEnabled(true);
                            valorX.setVisible(true);
                            valorY.setText("");
                            valorY.setVisible(true);
                            valorEnt.setText("");
                            valorEnt.setVisible(true);
                            valorX2.setText("");
                            valorX2.setVisible(true);
                            xValor.setVisible(true);
                            xValor.setText("X²: ");
                            yValor.setVisible(true);
                            yValor.setText("X: ");
                            enteros.setVisible(true);
                            enteros.setText("Entero: ");
                            x2Valor.setVisible(true);
                            x2Valor.setText("Y²");
                            y2Valor.setVisible(true);
                            y2Valor.setText("Y: ");
                            valorY2.setVisible(true);
                            valorY2.setText("");
                            valorX.setText("");
                            valorY2.setEnabled(true);
                            if(verticalXOY=='x'||verticalXOY=='X') {
                                plano.setTipo(21);
                                valorX2.setEnabled(true);
                                valorX.setEnabled(false);
                            } else {
                                plano.setTipo(22);
                                valorX.setEnabled(true);
                                valorX2.setEnabled(false);
                            }
                            
                            
                          }
                         }
                         verticalXOY ='z';
                        } else 
                            if (cual == 3) {
                                JOptionPane.showMessageDialog(null, "Llena todos los espacios");
                                plano.setTipo(cual);
                                tipograf = 3;
                                valorY.setEnabled(true);
                            valorEnt.setEnabled(true);
                            valorX.setVisible(true);
                            valorY.setText("");
                            valorY.setVisible(true);
                            valorEnt.setText("");
                            valorEnt.setVisible(true);
                            valorX2.setText("");
                            valorX2.setVisible(true);
                            xValor.setVisible(true);
                            xValor.setText("X²: ");
                            yValor.setVisible(true);
                            yValor.setText("X: ");
                            enteros.setVisible(true);
                            enteros.setText("Entero: ");
                            x2Valor.setVisible(true);
                            x2Valor.setText("Y²");
                            y2Valor.setVisible(true);
                            y2Valor.setText("Y: ");
                            valorY2.setVisible(true);
                            valorY2.setText("");
                            valorX.setText("");
                            valorY2.setEnabled(true);
                            valorX.setEnabled(true);
                            valorX2.setEnabled(true);
                            } else 
                                if (cual == 4) {
                                    plano.setTipo(cual);
                                    tipograf = 4;
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
                
                if(tipograf == 1) {
                    plano.setX1(Double.parseDouble(valorX.getText()));
                    plano.setY1(Double.parseDouble(valorY.getText()));
                    plano.setEnt(Double.parseDouble(valorEnt.getText()));
                    String formula = String.format("| Y= (+(%sX)+(%s))/%s  |", (-(Integer.parseInt(valorX.getText()))), (-(Integer.parseInt(valorEnt.getText()))), valorY.getText());
                    Y.setText(formula);
                }else if(plano.getTipo()>20){
                    if(plano.getTipo()==21) {
                        plano.setY1(Double.parseDouble(valorY.getText()));
                        plano.setY2(Double.parseDouble(valorY2.getText()));
                        //valorX2 equivale a Y al cuadrado y valor Y2 equivale a Y normal X1 equivale a X2 y X2 a X
                        plano.setX2(Double.parseDouble(valorX2.getText()));
                        plano.setEnt(Double.parseDouble(valorEnt.getText()));
                        String formula = String.format("| X= ((%sY²)+(%sY)+(%s)/%s  |", valorX2.getText(), valorY2.getText(), valorEnt.getText(), valorY.getText());
                        X.setText(formula);
                    }
                    else {
                        plano.setX1(Double.parseDouble(valorX.getText()));
                        plano.setY1(Double.parseDouble(valorY.getText()));
                        plano.setEnt(Double.parseDouble(valorEnt.getText()));   
                        plano.setY2(Double.parseDouble(valorY2.getText()));
                        String formula = String.format("| Y= ((%sX²)+(%sX)+(%s))/%s  |", valorX.getText(), valorY.getText(), valorEnt.getText(), valorY2.getText());
                        Y.setText(formula);
                    }
                }else if(plano.getTipo()==3) {
                    //X1 = X cuadrada, X2 = Y cuadrada, Y1 = X, Y2 = Y, Ent = entero; ecuacion es AX²+CY²+DX+EY+F=0  
                    plano.setX1(Double.parseDouble(valorX.getText()));
                    plano.setY1(Double.parseDouble(valorY.getText()));
                    plano.setEnt(Double.parseDouble(valorEnt.getText()));
                    plano.setY2(Double.parseDouble(valorY2.getText()));
                    plano.setX2(Double.parseDouble(valorX2.getText()));
                    String formula = String.format("| ");
                    Y.setText(formula);
                
                }
                
                
                plano.repaint();
                
            }
            
        }
    }
    public class Ayuda extends JPanel{
        
        private ImageIcon imagelap;
        private JButton vectores;
        private JToolBar toot;
        
        public Ayuda(int x, int y, int width, int height){
            
            setVisible(true);
            setLocation(x, y);
            setSize(width, height);
            setLayout(null);
            
            vectores = new JButton("Vectores");
            vectores.setVisible(true);
            vectores.setLocation(0, 50);
            vectores.setSize(100, 30);
            add(vectores);
            
            
        }
        public void paint(Graphics g){
            
            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("default.jpg"));           
            
            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
            super.paint(g);
            
            
            
        } 
        
    }
}

