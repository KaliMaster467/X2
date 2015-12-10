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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Bugatti
 */
public class VentanaGraficadora extends Ventana {

    TablaRes tab;
    protected Ayuda ayuda;
    protected double width;
    protected double height;
    public static Plano plano;

    public void VentanaGraficadoras() {

        width = dim.getWidth();
        height = dim.getHeight();
        int anchoPlano = (int) Math.floor(width * .7);
        int altoPlano = (int) Math.floor(height * .7);
        plano = new Plano(anchoPlano, altoPlano);
        this.setResizable(true);
        add(plano);
        int anchoTabla = (int) Math.floor(width * .3);
        tab = new TablaRes(anchoTabla, altoPlano, anchoPlano);

        add(tab);

        int xa = 0;
        int hei = (int) (height - plano.getHeight());
        int ya = plano.getHeight();
        int wi = (int) width;
        ayuda = new Ayuda(xa, ya, wi, hei);

        add(ayuda);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class TablaRes extends JPanel implements ItemListener, ActionListener {

        JLabel X, Y, tabla, xValor, yValor, enteros, x2Valor, y2Valor;
        JComboBox tipoTabla;
        private Font fuente;
        private ImageIcon imagelap;
        JTextField valorX, valorY, valorEnt, valorX2, valorY2;
        JButton Grafica;
        private int tipograf;
        JButton siguienteTabla, antT;
        /*TABULAR*/
        JLabel[] TY;
        JLabel[] TX;
        private int paginaTabulador = 0;

        public TablaRes(int anchos, int altos, int ancho) {
            fuente = new Font("Verdana", Font.BOLD, 15);

            setBackground(Color.GRAY);
            setVisible(true);
            setLayout(null);
            setLocation((ancho + 1), 0);
            setSize(anchos, altos);
            //PUSE EL JBUTTON PARA GRAFICAR
            Grafica = new JButton("Grafica!");
            //Grafica.setBounds(140, 150, 110, 30);
            Grafica.setVisible(true);
            Grafica.setOpaque(true);
            Grafica.setFont(new Font("Verdana", Font.PLAIN, 20));
            Grafica.setBorderPainted(false);
            Grafica.setForeground(Color.white);
            Grafica.setBackground(Color.orange);
            Grafica.setBorder(BorderFactory.createLineBorder(Color.red));
            Grafica.setLocation(0, (this.getHeight() - 60));
            Grafica.setSize(this.getWidth(), 60);
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
            x2Valor.setText("INTRODUCE  ");
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

            siguienteTabla = new JButton("►");
            siguienteTabla.setVisible(true);
            siguienteTabla.addActionListener(this);
            siguienteTabla.setLayout(null);
            siguienteTabla.setEnabled(false);
            siguienteTabla.setBounds(240, 180, 60, 30);

            add(siguienteTabla);

            antT = new JButton("◄");
            antT.setVisible(true);
            antT.addActionListener(this);
            antT.setEnabled(false);
            antT.setLayout(null);
            antT.setBounds(60, 180, 60, 30);

            add(antT);

            tabla = new JLabel();
            tabla.setText("|                        TABLA                     |");
            tabla.setVisible(true);
            tabla.setLayout(null);
            tabla.setFont(fuente);
            tabla.setLocation(30, 180);
            tabla.setSize(500, 30);
            tabla.setForeground(Color.WHITE);

            add(tabla);

            X = new JLabel();
            X.setText("|            X            |");
            X.setVisible(true);
            X.setLayout(null);
            X.setFont(fuente);
            X.setLocation(30, 210);
            X.setSize(200, 30);
            X.setForeground(Color.WHITE);
            add(X);
            TX = new JLabel[10];
            TY = new JLabel[10];
            for (int i = 0; i < 10; i++) {
                TY[i] = new JLabel();
                TY[i].setText("           Y=          ");
                TY[i].setVisible(false);
                TY[i].setLayout(null);
                TY[i].setFont(fuente);
                TY[i].setLocation(180, 240 + (i * 30));
                TY[i].setSize(200, 30);
                TY[i].setForeground(Color.WHITE);
                add(TY[i]);
                TX[i] = new JLabel();
                TX[i].setText("           X=          ");
                TX[i].setVisible(false);
                TX[i].setLayout(null);
                TX[i].setFont(fuente);
                TX[i].setLocation(30, 240 + (i * 30));
                TX[i].setSize(200, 30);
                TX[i].setForeground(Color.WHITE);
                add(TX[i]);
            }

            Y = new JLabel();
            Y.setText("|            Y           |");
            Y.setVisible(true);
            Y.setLayout(null);
            Y.setFont(fuente);
            Y.setLocation(180, 210);
            Y.setSize(200, 30);
            Y.setForeground(Color.WHITE);

            add(Y);

            setVisible(true);
        }

        public int getWidthTabla() {

            return this.getWidth();

        }

        @Override
        /*public void itemStateChanged(ItemEvent e) {
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
                                char verticalXOY = 'z';
                                while(verticalXOY!='x'&&verticalXOY!='X'&&verticalXOY!='y'&&verticalXOY!='Y'){
                                    verticalXOY = JOptionPane.showInputDialog(null, "La elipse es paralela en X o Y").charAt(0);
                                    if(verticalXOY=='x'||verticalXOY=='y'||verticalXOY=='X'||verticalXOY=='Y'){
                                    JOptionPane.showMessageDialog(null, "Ingrese los valores de A (Long mayor|Debe ser mayor a C) y C (Distancia del los focos al centro)");
                                    plano.setTipo(cual);
                                    tipograf = 3;
                                    valorY.setEnabled(true);
 
                                valorEnt.setEnabled(false);
                                valorX.setVisible(true);
                                valorY.setText("");
                                valorY.setVisible(true);
                                valorEnt.setText(" ");
                                valorEnt.setVisible(false);
                                valorX2.setText("");
                                valorX2.setVisible(false);
                                xValor.setVisible(true);
                                xValor.setText("X: ");
                                
                                
                            
                                enteros.setVisible(false);
                                enteros.setText("");
                                x2Valor.setVisible(false);
                                x2Valor.setText("");
                                
                                y2Valor.setVisible(false);
                                y2Valor.setText("");
                                valorY2.setVisible(false);
                                valorY2.setText("");
                                valorX.setText("");
                                valorY2.setEnabled(true);
                                valorX.setEnabled(true);
                                valorX2.setEnabled(true);
                                yValor.setVisible(true);
                                xValor.setText("a: ");
                                    yValor.setText("c: ");
                                                                    y2Valor.setVisible(true);
                            
                                if(verticalXOY=='x'||verticalXOY=='X') {
                                    plano.setTipoElipse(31);
                                    
                                } else {
                                    plano.setTipoElipse(32);
                                    
                            }
                                    
                            
                                    }
                                }
                            } else 
                                if (cual == 4) {
                                    JOptionPane.showMessageDialog(null, "Llena todos los espacios (X² y Y² deben tener signos diferentes)");
                                plano.setTipo(cual);
                                tipograf = 3;
                                valorY.setEnabled(true);
                            valorEnt.setEnabled(true);
                            valorX.setVisible(true);
                            valorY.setText("");
                            valorY.setVisible(true);
                            valorEnt.setText("  1");
                            valorEnt.setEnabled(false);
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
                                }
                            
                        
                
                }
            }
        }
    }*/
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (e.getSource() instanceof JComboBox) {

                    int cual = tipoTabla.getSelectedIndex();

                    //AQUI SE LE PASA EL TIPO DE GRAFICA A EL PLANO
                    //TEXT FIELD VALOR AL FINAL
                    if (cual != 0) {
                        if (cual == 1) {
                            tipoTabla.setSelectedIndex(0);
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
                            enteros.setEnabled(true);

                        } else if (cual == 2) {
                            tipoTabla.setSelectedIndex(0);
                            char verticalXOY = 'z';
                            while (verticalXOY != 'x' && verticalXOY != 'X' && verticalXOY != 'y' && verticalXOY != 'Y') {
                                verticalXOY = (JOptionPane.showInputDialog(null, "La parabola es paralela en X o en Y? (Teclea X o Y)").charAt(0));
                                if (verticalXOY == 'x' || verticalXOY == 'y' || verticalXOY == 'X' || verticalXOY == 'Y') {
                                    JOptionPane.showMessageDialog(null, "Ingresa los valores de H(X del vertice), K(Y del vertice) y P (distancia del vertice al foco)");
                                    tipograf = 2;
                                    enteros.setEnabled(true);
                                    enteros.setVisible(true);
                                    enteros.setText("   P: ");
                                    valorY.setEnabled(true);
                                    valorEnt.setEnabled(true);
                                    valorX.setVisible(true);
                                    valorY.setText("");
                                    valorY.setVisible(true);
                                    valorEnt.setText("");
                                    valorEnt.setVisible(true);
                                    valorX.setEnabled(true);
                                    xValor.setVisible(true);
                                    xValor.setText("H: ");
                                    yValor.setVisible(true);
                                    yValor.setText("K: ");
                                    enteros.setVisible(true);
                                    valorX.setText("");
                                    if (verticalXOY == 'x' || verticalXOY == 'X') {
                                        plano.setTipo(21);
                                    } else {
                                        plano.setTipo(22);
                                    }

                                }
                            }
                            verticalXOY = 'z';
                        } else if (cual == 3) {
                            tipoTabla.setSelectedIndex(0);
                            char verticalXOY = 'z';
                            while (verticalXOY != 'x' && verticalXOY != 'X' && verticalXOY != 'y' && verticalXOY != 'Y') {
                                verticalXOY = JOptionPane.showInputDialog(null, "La elipse es paralela en X o Y").charAt(0);
                                if (verticalXOY == 'x' || verticalXOY == 'y' || verticalXOY == 'X' || verticalXOY == 'Y') {
                                    JOptionPane.showMessageDialog(null, "Ingrese los valores de A (Long mayor|Debe ser mayor a C) y C (Distancia del los focos al centro)");
                                    plano.setTipo(cual);
                                    tipograf = 3;
                                    valorY.setEnabled(true);

                                    valorEnt.setEnabled(false);
                                    valorX.setVisible(true);
                                    valorY.setText("");
                                    valorY.setVisible(true);
                                    valorEnt.setText(" ");
                                    valorEnt.setVisible(false);
                                    xValor.setVisible(true);
                                    xValor.setEnabled(true);
                                    enteros.setVisible(false);
                                    enteros.setText("");
                                    valorX.setText("");
                                    valorX.setEnabled(true);
                                    yValor.setVisible(true);
                                    xValor.setText("a: ");
                                    yValor.setText("c: ");

                                    if (verticalXOY == 'x' || verticalXOY == 'X') {
                                        plano.setTipoElipse(31);

                                    } else {
                                        plano.setTipoElipse(32);

                                    }

                                }
                            }
                        } else if (cual == 4) {
                            tipoTabla.setSelectedIndex(0);
                            char verticalXOY = 'z';
                            while (verticalXOY != 'x' && verticalXOY != 'X' && verticalXOY != 'y' && verticalXOY != 'Y') {
                                verticalXOY = JOptionPane.showInputDialog(null, "Desea que sea paralela a X o Y?").charAt(0);
                                if (verticalXOY == 'x' || verticalXOY == 'y' || verticalXOY == 'X' || verticalXOY == 'Y') {
                                    plano.setTipo(cual);
                                    tipograf = 4;
                                    if (verticalXOY == 'x' || verticalXOY == 'X') {
                                        plano.setTipoHiper(41);
                                        JOptionPane.showMessageDialog(null, "Formula general siendo paralela a X\n(X²/A²)-(Y²/B²)=1");
                                        JOptionPane.showMessageDialog(null, "Ingrese los valores de A & B (El valor por defecto del entero es 1)");
                                        xValor.setEnabled(true);
                                        yValor.setEnabled(true);
                                        y2Valor.setEnabled(false);
                                        xValor.setVisible(true);
                                        yValor.setVisible(true);
                                        y2Valor.setVisible(false);
                                        enteros.setText("");
                                        enteros.setVisible(false);
                                        enteros.setEnabled(false);
                                        xValor.setText("A: ");
                                        yValor.setText("B: ");
                                        y2Valor.setText("");
                                        valorX.setText("");
                                        valorY.setText("");
                                        valorX.setEnabled(true);
                                        valorY.setEnabled(true);
                                        valorEnt.setText("");
                                        valorX.setVisible(true);
                                        valorY.setVisible(true);
                                        valorEnt.setVisible(false);
                                        valorEnt.setEnabled(false);

                                    } else {
                                        plano.setTipoHiper(42);
                                        JOptionPane.showMessageDialog(null, "Formula general siendo paralela a Y\n(Y²/A²)-(X²/B²)=1");
                                        JOptionPane.showMessageDialog(null, "Ingrese los valores de A & B  (El valor por defecto del entero es 1)");
                                        xValor.setEnabled(true);
                                        yValor.setEnabled(true);
                                        xValor.setVisible(true);
                                        yValor.setVisible(true);
                                        enteros.setText("");
                                        enteros.setVisible(false);
                                        enteros.setEnabled(false);
                                        xValor.setText("A: ");
                                        yValor.setText("B: ");
                                        valorX.setText("");
                                        valorY.setText("");
                                        valorX.setEnabled(true);
                                        valorX.setVisible(true);
                                        valorY.setVisible(true);
                                        valorY.setEnabled(true);
                                        valorEnt.setText("");
                                        valorEnt.setVisible(false);
                                        valorEnt.setEnabled(false);
                                    }

                                }
                            }
                        }

                    }
                }
            }
        }

        public void paint(Graphics g) {

            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("bgtab.jpg"));

            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
            super.paint(g);

        }

        /*@Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Grafica!")) {
                //AQUI SE PASA EL VALOR DE X Y EL ENTERO Y SE HACE EL REPAINT
                
                if(tipograf == 1) {
                    plano.setX1(Double.parseDouble(valorX.getText()));
                    plano.setY1(Double.parseDouble(valorY.getText()));
                    plano.setEnt(Double.parseDouble(valorEnt.getText()));
                    siguienteTabla.setEnabled(true);
                    String formula = String.format("| Y= (+(%sX)+(%s))/%s |", (-(Integer.parseInt(valorX.getText()))), (-(Integer.parseInt(valorEnt.getText()))), valorY.getText());
                    JOptionPane.showMessageDialog(null, formula);
                }else if(plano.getTipo()>20&&plano.getTipo()<25){
                    if(plano.getTipo()==21) {
                        plano.setY1(Double.parseDouble(valorY.getText()));
                        plano.setY2(Double.parseDouble(valorY2.getText()));
                        //valorX2 equivale a Y al cuadrado y valor Y2 equivale a Y normal X1 equivale a X2 y X2 a X
                        plano.setX2(Double.parseDouble(valorX2.getText()));
                        plano.setEnt(Double.parseDouble(valorEnt.getText()));
                        siguienteTabla.setEnabled(true);
                        String formula = String.format("| X= ((%sY²)+(%sY)+(%s)/%s  |", valorX2.getText(), valorY2.getText(), valorEnt.getText(), valorY.getText());
                        JOptionPane.showMessageDialog(null, formula);
                    }
                    else {
                        plano.setX1(Double.parseDouble(valorX.getText()));
                        plano.setY1(Double.parseDouble(valorY.getText()));
                        plano.setEnt(Double.parseDouble(valorEnt.getText()));   
                        plano.setY2(Double.parseDouble(valorY2.getText()));
                        siguienteTabla.setEnabled(true);
                        String formula = String.format("| Y= ((%sX²)+(%sX)+(%s))/%s  |", valorX.getText(), valorY.getText(), valorEnt.getText(), valorY2.getText());
                        JOptionPane.showMessageDialog(null, formula);
                    }
                }else if(plano.getTipo()==3) {
                    //X1 = X cuadrada, X2 = Y cuadrada, Y1 = X, Y2 = Y, Ent = entero; ecuacion es AX²+CY²+DX+EY+F=0  
                    if(Double.parseDouble(valorX.getText())>Double.parseDouble(valorY.getText())) {
                        plano.setAX(Double.parseDouble(valorX.getText()));//A
                        plano.setCX(Double.parseDouble(valorY.getText()));//C
                        siguienteTabla.setEnabled(true);
                        String formula = String.format("| ");
                        Y.setText(formula);
                    } else {
                        JOptionPane.showMessageDialog(null, "A debe ser mayor que C");
                    }    
                    
                }else if(plano.getTipo()==4) {
                    if(Integer.parseInt(valorX.getText())<0&&Integer.parseInt(valorX2.getText())>0||Integer.parseInt(valorX.getText())>0&&Integer.parseInt(valorX2.getText())<0
                            ) {
                        plano.setX1(Double.parseDouble(valorX.getText()));
                        plano.setY1(Double.parseDouble(valorY.getText()));
                        plano.setEnt(Double.parseDouble(valorEnt.getText()));
                        plano.setY2(Double.parseDouble(valorY2.getText()));
                        plano.setX2(Double.parseDouble(valorX2.getText()));
                        siguienteTabla.setEnabled(true);
                        String formula = String.format("| ");
                        Y.setText(formula);
                    }else
                        JOptionPane.showMessageDialog(null, "X² y Y² deben ser de signos diferentes!!");
                }
                
                
                plano.repaint();
                
            }
            
        }*/
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("►")) {
                paginaTabulador++;
                if (plano.getTipo() == 1) {

                    if (paginaTabulador == 3) {
                        siguienteTabla.setEnabled(false);
                    }
                    if (paginaTabulador != 0) {
                        antT.setEnabled(true);
                    }

                    for (int i = 0; i < 10; i++) {
                        TX[i].setVisible(true);
                        String Xs = String.format(" X=%d", (20 - i - (paginaTabulador * 10)));
                        System.out.println(Xs);
                        TX[i].setText(Xs);
                        TY[i].setVisible(true);
                        String Ys = String.format(" Y=%.2f", (((-Double.parseDouble(valorX.getText()) * (20 - i - (paginaTabulador * 10))) - (Double.parseDouble(valorEnt.getText())))) / Double.parseDouble(valorY.getText()));
                        TY[i].setText(Ys);

                    }
                } else if (plano.getTipo() > 20 && plano.getTipo() < 25) {
                    int cuantosLabels;
                    int maximoPaginas;
                    int cuantos;
                    int x1;
                    if (plano.getTipo() == 21) {
                        if (plano.getPP1() > 0) {
                            //se abre derecha
                            cuantosLabels = 20 - (int) plano.getHP1();
                            x1 = 20;
                            if (paginaTabulador == 1) {
                                cuantos = cuantosLabels - 9;
                                x1 = x1 - 10;
                                if (cuantosLabels > 19) {
                                    cuantos = 10;

                                }
                            } else if (paginaTabulador == 2) {
                                cuantos = cuantosLabels - 19;
                                x1 = x1 - 20;
                                if (cuantosLabels > 29) {
                                    cuantos = 10;
                                }
                            } else {
                                cuantos = cuantosLabels - 29;
                                x1 = x1 - 30;
                                if (cuantosLabels > 39) {
                                    cuantos = 10;
                                }
                            }
                        } else {
                            //se abre izquierda
                            cuantosLabels = 20 + (int) plano.getHP1();
                            x1 = -20;
                            if (paginaTabulador == 1) {
                                cuantos = cuantosLabels - 9;
                                x1 = x1 + 10;
                                if (cuantosLabels > 19) {
                                    cuantos = 10;
                                }

                            } else if (paginaTabulador == 2) {
                                cuantos = cuantosLabels - 19;
                                x1 = x1 + 20;
                                if (cuantosLabels > 29) {
                                    cuantos = 10;
                                }
                            } else {
                                cuantos = cuantosLabels - 29;
                                x1 = x1 + 30;
                                if (cuantosLabels > 39) {
                                    cuantos = 10;
                                }
                            }
                        }
                        maximoPaginas = (int) cuantosLabels / 10;
                        if (paginaTabulador == maximoPaginas || paginaTabulador == 3) {
                            siguienteTabla.setEnabled(false);
                        }
                        if (paginaTabulador != 0) {
                            antT.setEnabled(true);
                        }

                        for (int i = 0; i < cuantos; i++) {
                            TX[i].setVisible(true);
                            double Xss = ((Math.sqrt(4 * plano.getPP1() * (x1 - plano.getHP1()))) + plano.getKP1());
                            String Xs = String.format(" X=%d", (x1));
                            TX[i].setText(Xs);
                            TY[i].setVisible(true);
                            String Ys = String.format(" Y=%.2f, %.2f", Xss, (-Xss + (plano.getKP1() * 2)));
                            TY[i].setText(Ys);
                            if (plano.getPP1() > 0) {
                                x1--;
                            } else {
                                x1++;
                            }
                        }
                        int cuantosBorrar = cuantos - 1;
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }

                    } else {
                        //EN Y
                        if (plano.getPP1() > 0) {
                            //se abre arriba
                            cuantosLabels = 20 - (int) plano.getKP1();
                            x1 = 20;
                            if (paginaTabulador == 1) {
                                cuantos = cuantosLabels - 9;
                                x1 = x1 - 10;
                                if (cuantosLabels > 19) {
                                    cuantos = 10;

                                }
                            } else if (paginaTabulador == 2) {
                                cuantos = cuantosLabels - 19;
                                x1 = x1 - 20;
                                if (cuantosLabels > 29) {
                                    cuantos = 10;
                                }
                            } else {
                                cuantos = cuantosLabels - 29;
                                x1 = x1 - 30;
                                if (cuantosLabels > 39) {
                                    cuantos = 10;
                                }
                            }
                        } else {
                            //se abre abajo
                            cuantosLabels = 20 + (int) plano.getKP1();
                            x1 = -20;
                            if (paginaTabulador == 1) {
                                cuantos = cuantosLabels - 9;
                                x1 = x1 + 10;
                                if (cuantosLabels > 19) {
                                    cuantos = 10;
                                }

                            } else if (paginaTabulador == 2) {
                                cuantos = cuantosLabels - 19;
                                x1 = x1 + 20;
                                if (cuantosLabels > 29) {
                                    cuantos = 10;
                                }
                            } else {
                                cuantos = cuantosLabels - 29;
                                x1 = x1 + 30;
                                if (cuantosLabels > 39) {
                                    cuantos = 10;
                                }
                            }
                        }
                        maximoPaginas = (int) cuantosLabels / 10;
                        if (paginaTabulador == maximoPaginas || paginaTabulador == 3) {
                            siguienteTabla.setEnabled(false);
                        }
                        if (paginaTabulador != 0) {
                            antT.setEnabled(true);
                        }

                        for (int i = 0; i < cuantos; i++) {
                            TX[i].setVisible(true);
                            double Xss = ((Math.sqrt(4 * plano.getPP1() * (x1 - plano.getKP1()))) + plano.getHP1());
                            String Xs = String.format(" Y=%d", (x1));
                            String Ys = String.format(" X=%.2f, %.2f", Xss, (-Xss + (plano.getHP1() * 2)));
                            TX[i].setText(Ys);
                            TY[i].setVisible(true);

                            TY[i].setText(Xs);
                            if (plano.getPP1() > 0) {
                                x1--;
                            } else {
                                x1++;
                            }
                        }
                        int cuantosBorrar = cuantos - 1;
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }

                    }

                } else if (plano.getTipo() == 3) {
                    int cuantosBorrar;
                    int cuantosLabel = (int) (2 * plano.getAX() + 1);
                    int cuantos = (int) (2 * plano.getAX() + 1);
                    int x1;
                    int cuantasPags = (int) Math.floor(cuantos / 10);
                    x1 = (int) plano.getAX();
                    if (paginaTabulador == cuantasPags || paginaTabulador == 3) {
                        siguienteTabla.setEnabled(false);
                    }
                    if (paginaTabulador != 0) {
                        antT.setEnabled(true);
                    }
                    if (plano.getTipoElipse() == 31) {
                        if (paginaTabulador == 1) {
                            cuantos = cuantos - 10;
                            x1 = x1 - 10;
                            if (cuantosLabel > 19) {
                                cuantos = 10;
                            }

                        } else if (paginaTabulador == 2) {
                            cuantos = cuantos - 20;
                            x1 = x1 - 20;
                            if (cuantosLabel > 29) {
                                cuantos = 10;
                            }
                        } else if (paginaTabulador == 3) {
                            cuantos = cuantos - 30;
                            x1 = x1 - 30;
                            if (cuantosLabel > 39) {
                                cuantos = 10;
                            }

                        }

                        for (int i = 0; i < cuantos; i++) {
                            TX[i].setVisible(true);
                            TY[i].setVisible(true);
                            double Xss = Math.sqrt((1 - ((x1 * x1) / (plano.getAX() * plano.getAX()))) * ((plano.getAX() * plano.getAX()) - (plano.getCX() * plano.getCX())));
                            String Xs = String.format(" X=%d", x1);
                            String Ys = String.format(" Y=%.2f, %.2f", Xss, (-Xss));
                            TX[i].setText(Xs);
                            TY[i].setText(Ys);
                            x1--;

                        }
                        cuantosBorrar = cuantos - 1;
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }
                    } else if (plano.getTipoElipse() == 32) {
                        if (paginaTabulador == 1) {
                            cuantos = cuantos - 10;
                            x1 = x1 - 10;
                            if (cuantosLabel > 19) {
                                cuantos = 10;
                            }

                        } else if (paginaTabulador == 2) {
                            cuantos = cuantos - 20;
                            x1 = x1 - 20;
                            if (cuantosLabel > 29) {
                                cuantos = 10;
                            }
                        } else if (paginaTabulador == 3) {
                            cuantos = cuantos - 30;
                            x1 = x1 - 30;
                            if (cuantosLabel > 39) {
                                cuantos = 10;
                            }
                        }
                        for (int i = 0; i < cuantos; i++) {
                            TX[i].setVisible(true);
                            TY[i].setVisible(true);
                            double Xss = Math.sqrt((1 - ((x1 * x1) / (plano.getAX() * plano.getAX()))) * ((plano.getAX() * plano.getAX()) - (plano.getCX() * plano.getCX())));
                            String Xs = String.format(" Y=%d", x1);
                            String Ys = String.format(" X=%.2f, %.2f", Xss, (-Xss));
                            TX[i].setText(Ys);
                            TY[i].setText(Xs);
                            x1--;

                        }
                        cuantosBorrar = cuantos - 1;
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }
                    }
                }

            }
            if (e.getActionCommand().equals("◄")) {
                paginaTabulador--;
                if (plano.getTipo() == 1) {

                    if (paginaTabulador == 0) {
                        antT.setEnabled(false);
                    }
                    if (paginaTabulador != 3) {
                        siguienteTabla.setEnabled(true);
                    }
                    for (int i = 0; i < 10; i++) {
                        TX[i].setVisible(true);
                        String Xs = String.format(" X=%d", (20 - i - (paginaTabulador * 10)));
                        System.out.println(Xs);
                        TX[i].setText(Xs);
                        TY[i].setVisible(true);
                        String Ys = String.format(" Y=%.2f", (((-Double.parseDouble(valorX.getText()) * (20 - i - (paginaTabulador * 10))) - (Double.parseDouble(valorEnt.getText())))) / Double.parseDouble(valorY.getText()));
                        TY[i].setText(Ys);

                    }
                } else if (plano.getTipo() > 20 && plano.getTipo() < 25) {
                    int cuantosLabels;
                    int maximoPaginas;
                    int cuantos;
                    int x1;
                    if (plano.getTipo() == 21) {
                        if (plano.getPP1() > 0) {
                            //se abre derecha
                            cuantosLabels = 20 - (int) plano.getHP1();
                            x1 = 20;
                            switch (paginaTabulador) {
                                case 0:
                                    cuantos = 10;
                                    break;
                                case 1:
                                    cuantos = cuantosLabels - 9;
                                    x1 = x1 - 10;
                                    if (cuantosLabels > 19) {
                                        cuantos = 10;
                                    }
                                    break;
                                case 2:
                                    cuantos = cuantosLabels - 19;
                                    x1 = x1 - 20;
                                    if (cuantosLabels > 29) {
                                        cuantos = 10;
                                    }
                                    break;
                                default:
                                    cuantos = cuantosLabels - 29;
                                    x1 = x1 - 30;
                                    if (cuantosLabels > 39) {
                                        cuantos = 10;
                                    }
                                    break;
                            }
                        } else {
                            //se abre izquierda
                            cuantosLabels = 20 + (int) plano.getHP1();
                            x1 = -20;
                            switch (paginaTabulador) {
                                case 0:
                                    cuantos = 10;
                                    break;
                                case 1:
                                    cuantos = cuantosLabels - 9;
                                    x1 = x1 + 10;
                                    if (cuantosLabels > 19) {
                                        cuantos = 10;
                                    }
                                    break;
                                case 2:
                                    cuantos = cuantosLabels - 19;
                                    x1 = x1 + 20;
                                    if (cuantosLabels > 29) {
                                        cuantos = 10;
                                    }
                                    break;
                                default:
                                    cuantos = cuantosLabels - 29;
                                    x1 = x1 + 30;
                                    if (cuantosLabels > 39) {
                                        cuantos = 10;
                                    }
                                    break;
                            }
                        }
                        maximoPaginas = (int) cuantosLabels / 10;
                        if (paginaTabulador != 3) {
                            siguienteTabla.setEnabled(true);
                        }
                        if (paginaTabulador == 0) {
                            antT.setEnabled(false);
                        }

                        for (int i = 0; i < cuantos; i++) {
                            TX[i].setVisible(true);
                            double Xss = ((Math.sqrt(4 * plano.getPP1() * (x1 - plano.getHP1()))) + plano.getKP1());
                            String Xs = String.format(" X=%d", (x1));
                            TX[i].setText(Xs);
                            TY[i].setVisible(true);
                            String Ys = String.format(" Y=%.2f, %.2f", Xss, (-Xss + (plano.getKP1() * 2)));
                            TY[i].setText(Ys);
                            if (plano.getPP1() > 0) {
                                x1--;
                            } else {
                                x1++;
                            }
                        }
                        int cuantosBorrar = cuantos - 1;
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }

                    } else {

                        if (plano.getPP1() > 0) {
                            //se abre arriba
                            cuantosLabels = 20 - (int) plano.getKP1();
                            x1 = 20;
                            switch (paginaTabulador) {
                                case 0:
                                    cuantos = 10;
                                    break;
                                case 1:
                                    cuantos = cuantosLabels - 9;
                                    x1 = x1 - 10;
                                    if (cuantosLabels > 19) {
                                        cuantos = 10;

                                    }
                                    break;
                                case 2:
                                    cuantos = cuantosLabels - 19;
                                    x1 = x1 - 20;
                                    if (cuantosLabels > 29) {
                                        cuantos = 10;
                                    }
                                    break;
                                default:
                                    cuantos = cuantosLabels - 29;
                                    x1 = x1 - 30;
                                    if (cuantosLabels > 39) {
                                        cuantos = 10;
                                    }
                                    break;
                            }
                        } else {
                            //se abre abajo
                            cuantosLabels = 20 + (int) plano.getKP1();
                            x1 = -20;
                            switch (paginaTabulador) {
                                case 0:
                                    cuantos = 10;
                                    break;
                                case 1:
                                    cuantos = cuantosLabels - 9;
                                    x1 = x1 + 10;
                                    if (cuantosLabels > 19) {
                                        cuantos = 10;
                                    }
                                    break;
                                case 2:
                                    cuantos = cuantosLabels - 19;
                                    x1 = x1 + 20;
                                    if (cuantosLabels > 29) {
                                        cuantos = 10;
                                    }
                                    break;
                                default:
                                    cuantos = cuantosLabels - 29;
                                    x1 = x1 + 30;
                                    if (cuantosLabels > 39) {
                                        cuantos = 10;
                                    }
                                    break;
                            }
                        }
                        maximoPaginas = (int) cuantosLabels / 10;
                        if (paginaTabulador != 3) {
                            siguienteTabla.setEnabled(true);
                        }
                        if (paginaTabulador == 0) {
                            antT.setEnabled(false);
                        }

                        for (int i = 0; i < cuantos; i++) {
                            TX[i].setVisible(true);
                            double Xss = ((Math.sqrt(4 * plano.getPP1() * (x1 - plano.getKP1()))) + plano.getHP1());
                            String Xs = String.format(" Y=%d", (x1));
                            String Ys = String.format(" X=%.2f, %.2f", Xss, (-Xss + (plano.getHP1() * 2)));
                            TX[i].setText(Ys);
                            TY[i].setVisible(true);

                            TY[i].setText(Xs);
                            if (plano.getPP1() > 0) {
                                x1--;
                            } else {
                                x1++;
                            }
                        }
                        int cuantosBorrar = cuantos - 1;
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }

                    }

                } else if (plano.getTipo() == 3) {
                    int cuantosLabel = (int) (2 * plano.getAX() + 1);
                    int cuantos = (int) (2 * plano.getAX() + 1);
                    int x1;
                    int cuantosBorrar;
                    x1 = (int) plano.getAX();
                    if (paginaTabulador != 3) {
                        siguienteTabla.setEnabled(true);
                    }
                    if (paginaTabulador == 0) {
                        antT.setEnabled(false);
                    }

                    if (plano.getTipoElipse() == 31) {
                        if (paginaTabulador == 0) {
                            antT.setEnabled(false);
                            if (cuantosLabel > 9) {
                                cuantos = 10;
                            }
                        }
                        if (paginaTabulador == 1) {
                            cuantos = cuantos - 10;
                            x1 = x1 - 10;
                            if (cuantosLabel > 19) {
                                cuantos = 10;
                            }

                        } else if (paginaTabulador == 2) {
                            cuantos = cuantos - 20;
                            x1 = x1 - 20;
                            if (cuantosLabel > 29) {
                                cuantos = 10;
                            }
                        }

                        for (int i = 0; i < cuantos; i++) {
                            TX[i].setVisible(true);
                            TY[i].setVisible(true);
                            double Xss = Math.sqrt((1 - ((x1 * x1) / (plano.getAX() * plano.getAX()))) * ((plano.getAX() * plano.getAX()) - (plano.getCX() * plano.getCX())));
                            String Xs = String.format(" X=%d", x1);
                            String Ys = String.format(" Y=%.2f, %.2f", Xss, (-Xss));
                            TX[i].setText(Xs);
                            TY[i].setText(Ys);
                            x1--;

                        }
                        cuantosBorrar = cuantos - 1;
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }
                    } else if (plano.getTipoElipse() == 32) {
                        if (paginaTabulador == 0) {
                            cuantos = cuantos;
                            if (cuantosLabel > 9) {
                                cuantos = 10;
                            }
                        } else if (paginaTabulador == 1) {
                            cuantos = cuantos - 10;
                            x1 = x1 - 10;
                            if (cuantosLabel > 19) {
                                cuantos = 10;
                            }

                        } else if (paginaTabulador == 2) {
                            cuantos = cuantos - 20;
                            x1 = x1 - 20;
                            if (cuantosLabel > 29) {
                                cuantos = 10;
                            }

                        }
                        for (int i = 0; i < cuantos; i++) {
                            TX[i].setVisible(true);
                            TY[i].setVisible(true);
                            double Xss = Math.sqrt((1 - ((x1 * x1) / (plano.getAX() * plano.getAX()))) * ((plano.getAX() * plano.getAX()) - (plano.getCX() * plano.getCX())));
                            String Xs = String.format(" Y=%d", x1);
                            String Ys = String.format(" X=%.2f, %.2f", Xss, (-Xss));
                            TX[i].setText(Ys);
                            TY[i].setText(Xs);
                            x1--;

                        }
                        cuantosBorrar = cuantos - 1;
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }
                    }

                }
            } else if (e.getActionCommand().equals("Grafica!")) {
                //AQUI SE PASA EL VALOR DE X Y EL ENTERO Y SE HACE EL REPAINT
                if (plano.getTipo() == 1) {

                    plano.setX1(Double.parseDouble(valorX.getText()));
                    plano.setY1(Double.parseDouble(valorY.getText()));
                    plano.setEnt(Double.parseDouble(valorEnt.getText()));
                    siguienteTabla.setEnabled(true);
                    String formula = String.format("| Y= (+(%sX)+(%s))/%s |", (-(Integer.parseInt(valorX.getText()))), (-(Integer.parseInt(valorEnt.getText()))), valorY.getText());
                    JOptionPane.showMessageDialog(null, formula);
                    //TABULAR
                    for (int i = 0; i < 10; i++) {
                        TX[i].setVisible(true);
                        String Xs = String.format(" X=%d", (20 - i));
                        TX[i].setText(Xs);
                        TY[i].setVisible(true);
                        String Ys = String.format(" Y=%.2f", (((-Double.parseDouble(valorX.getText()) * (20 - i)) - (Double.parseDouble(valorEnt.getText())))) / Double.parseDouble(valorY.getText()));
                        TY[i].setText(Ys);

                    }
                    paginaTabulador = 0;
                    //FIN TABULAR
                } else if (plano.getTipo() > 20 && plano.getTipo() < 25) {
                    plano.setKP1(Double.parseDouble(valorY.getText()));
                    plano.setHP1(Double.parseDouble(valorX.getText()));
                    plano.setPP1(Double.parseDouble(valorEnt.getText()));
                    siguienteTabla.setEnabled(true);
                    if (plano.getTipo() == 21) {

                        //TABULAR
                        int cuantos = 0;
                        int x1 = 0;
                        int cuantosBorrar = 10;
                        if (plano.getPP1() > 0) {
                            x1 = 20;
                            if (plano.getHP1() > 10) {
                                cuantos = 20 - (int) plano.getHP1();
                                siguienteTabla.setEnabled(false);
                                cuantosBorrar = cuantos;
                            } else {
                                cuantos = 9;

                            }

                        } else if (plano.getPP1() < 0) {
                            x1 = -20;
                            if (plano.getHP1() < (-10)) {
                                cuantos = 20 + (int) plano.getHP1();
                                siguienteTabla.setEnabled(false);
                                cuantosBorrar = cuantos;
                            } else {
                                cuantos = 9;
                            }
                        }

                        for (int i = 0; i <= cuantos; i++) {
                            TX[i].setVisible(true);
                            double Xss = ((Math.sqrt(4 * plano.getPP1() * (x1 - plano.getHP1()))) + plano.getKP1());
                            String Xs = String.format(" X=%d", x1);
                            TX[i].setText(Xs);
                            TY[i].setVisible(true);
                            String Ys = String.format(" Y=%.2f, %.2f", Xss, (-Xss + (plano.getKP1() * 2)));
                            TY[i].setText(Ys);
                            if (plano.getPP1() > 0) {
                                x1--;
                            } else {
                                x1++;
                            }

                        }
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }
                        paginaTabulador = 0;
                        //FIN TABULAR
                    } else {
                        String formula = String.format("| X=   |", valorX.getText(), valorEnt.getText(), valorY.getText());
                        //TABULAR
                        int cuantos = 0;
                        int y1 = 0;
                        int cuantosBorrar = 10;
                        if (plano.getPP1() > 0) {
                            y1 = 20;
                            if (plano.getKP1() > 10) {
                                cuantos = 20 - (int) plano.getKP1();
                                siguienteTabla.setEnabled(false);
                                cuantosBorrar = cuantos;
                            } else {
                                cuantos = 9;

                            }

                        } else if (plano.getPP1() < 0) {
                            y1 = -20;
                            if (plano.getKP1() < (-10)) {
                                cuantos = 20 + (int) plano.getKP1();
                                siguienteTabla.setEnabled(false);
                                cuantosBorrar = cuantos;
                            } else {
                                cuantos = 9;
                            }
                        }

                        for (int i = 0; i <= cuantos; i++) {
                            TX[i].setVisible(true);
                            double Xss = ((Math.sqrt(4 * plano.getPP1() * (y1 - plano.getKP1()))) + plano.getHP1());
                            String Xs = String.format(" Y=%d", y1);
                            String Ys = String.format(" X=%.2f, %.2f", Xss, (-Xss + (plano.getHP1() * 2)));
                            TX[i].setText(Ys);
                            TY[i].setVisible(true);

                            TY[i].setText(Xs);
                            if (plano.getPP1() > 0) {
                                y1--;
                            } else {
                                y1++;
                            }

                        }
                        for (int i = 9; i > cuantosBorrar; i--) {
                            TX[i].setVisible(false);
                            TY[i].setVisible(false);
                        }
                        paginaTabulador = 0;
                        //FIN TABULAR
                    }
                } else if (plano.getTipo() == 3) {
                    //X1 = X cuadrada, X2 = Y cuadrada, Y1 = X, Y2 = Y, Ent = entero; ecuacion es AX²+CY²+DX+EY+F=0  
                    if (Double.parseDouble(valorX.getText()) > Double.parseDouble(valorY.getText())) {
                        plano.setAX(Double.parseDouble(valorX.getText()));//A
                        plano.setCX(Double.parseDouble(valorY.getText()));//C
                        siguienteTabla.setEnabled(true);
                        String formula = String.format("| ");
                        Y.setText(formula);
                        //VARIABLES
                        int cuantos;
                        int x1;
                        cuantos = 2 * (int) plano.getAX() + 1;
                        x1 = (int) plano.getAX();
                        if (cuantos > 10) {
                            cuantos = 10;
                            siguienteTabla.setEnabled(true);
                        } else {
                            siguienteTabla.setEnabled(false);
                        }
                        //FIN VAR
                        //TABULAR EN X
                        if (plano.getTipoElipse() == 31) {
                            for (int i = 0; i < cuantos; i++) {
                                TX[i].setVisible(true);
                                TY[i].setVisible(true);
                                double Xss = Math.sqrt((1 - ((x1 * x1) / (plano.getAX() * plano.getAX()))) * ((plano.getAX() * plano.getAX()) - (plano.getCX() * plano.getCX())));
                                String Xs = String.format(" X=%d", x1);
                                String Ys = String.format(" Y=%.2f, %.2f", Xss, (-Xss));
                                TX[i].setText(Xs);
                                TY[i].setText(Ys);
                                x1--;
                            }

                            //FIN TABULAR    
                            //TABULAR EN Y
                        } else {
                            for (int i = 0; i < cuantos; i++) {
                                TX[i].setVisible(true);
                                TY[i].setVisible(true);
                                double Xss = Math.sqrt((1 - ((x1 * x1) / (plano.getAX() * plano.getAX()))) * ((plano.getAX() * plano.getAX()) - (plano.getCX() * plano.getCX())));
                                String Xs = String.format(" Y=%d", x1);
                                String Ys = String.format(" X=%.2f, %.2f", Xss, (-Xss));
                                TX[i].setText(Ys);
                                TY[i].setText(Xs);
                                x1--;
                            }
                        }
                        //FIN TABULAR   

                    } else {
                        JOptionPane.showMessageDialog(null, "A debe ser mayor que C");

                    }
                    paginaTabulador = 0;
                } else if (plano.getTipo() == 4) {
                    if (plano.getTipoHiper() == 41) {
                        plano.setAH(Double.parseDouble(valorX.getText()));
                        plano.setBH(Double.parseDouble(valorY.getText()));
                        siguienteTabla.setEnabled(true);
                        String formula = String.format("| ");
                        Y.setText(formula);
                        //VAR
                        int cuantos = (int) ((20-plano.getAH())*2);
                        int x1 = 20-(int) plano.getAH();
                        if (cuantos > 10) {
                            cuantos = 10;
                            siguienteTabla.setEnabled(true);
                        } else {
                            cuantos = cuantos;
                            siguienteTabla.setEnabled(false);
                        }
                        //FIN VAR
                        //TAB
                        for (int j = 0; j < 2; j++) {
                            for (int i = 0; i < cuantos; i++) {
                                TX[i].setVisible(true);
                                TY[i].setVisible(true);
                                int S;
                                if(j==0) {
                                    S = x1;
                                }else
                                    S = -x1;
                                double Xss = /**/Math.sqrt((plano.getBH()*plano.getBH())*(((S*S)/(plano.getAH()*plano.getAH()))-1));
                                String Xs = String.format(" X=%d", S);
                                String Ys = String.format(" Y=%.2f, %.2f", Xss, (-Xss));
                                TX[i].setText(Xs);
                                TY[i].setText(Ys);
                                if(j==0) {
                                  x1++;  
                                } else
                                    x1--;
                                
                            }
                        }

                        //FIN TABULAR
                    } else {
                        plano.setBH(Double.parseDouble(valorY.getText()));
                        plano.setAH(Double.parseDouble(valorX.getText()));
                        siguienteTabla.setEnabled(true);
                        String formula = String.format("| ");
                        Y.setText(formula);
                        //TABULAR

                        //FIN TABULAR
                    }
                }

                plano.repaint();

            }

        }
    }

    public class Ayuda extends JPanel implements ActionListener {

        private ImageIcon imagelap;
        private JButton apuntes;
        private JButton vectores;
        private JButton tab;
        private BarraUsuario us;
        private Control cont;

        public Ayuda(int x, int y, int width, int height) {

            cont = new Control();

            setVisible(true);
            setLocation(x, y);
            setSize(width, height);
            setLayout(null);

            apuntes = new JButton("Aula");
            apuntes.setVisible(true);
            apuntes.setLocation(0, 0);
            apuntes.setSize(100, this.getHeight());
            apuntes.setBackground(Color.black);
            apuntes.setOpaque(true);
            apuntes.addActionListener(cont);
            apuntes.setForeground(Color.white);
            apuntes.setBorderPainted(false);
            add(apuntes);

            vectores = new JButton("Vectores");
            vectores.setVisible(true);
            vectores.setOpaque(true);
            vectores.setForeground(Color.white);
            vectores.setBackground(new Color(255, 61, 61));
            vectores.setLocation(apuntes.getWidth(), 0);
            vectores.setSize(100, this.getHeight());
            vectores.setBorderPainted(false);
            add(vectores);

            tab = new JButton("Elementos");
            tab.setVisible(true);
            tab.setLayout(null);
            tab.setOpaque(true);
            tab.setBorderPainted(false);
            tab.setBackground(new Color(166, 0, 138));
            tab.setLocation(apuntes.getWidth() + vectores.getWidth(), 0);
            tab.setSize(100, this.getHeight());
            tab.addActionListener(this);
            tab.setForeground(Color.white);
            add(tab);

            us = new BarraUsuario((int) Math.floor(width * .7) + 1, 0, (int) Math.floor(width * .3), this.getHeight());

            add(us);

        }

        public void paint(Graphics g) {

            Dimension tam = getSize();
            imagelap = new ImageIcon(getClass().getResource("default.jpg"));

            g.drawImage(imagelap.getImage(), 0, 0, tam.width, tam.height, null);
            setOpaque(false);
            super.paint(g);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Elementos")) {

                TablaPeriodica ped = new TablaPeriodica();

            }

        }
    }

    public class BarraUsuario extends JPanel {

        private JButton ce;
        private JButton con;
        private JButton ay;
        private Control cont;

        public BarraUsuario(int x, int y, double width, double height) {

            double w = width;
            double h = height;

            cont = new Control();

            setBackground(new Color(75, 148, 242));
            setVisible(true);
            setLayout(null);
            setSize((int) width, (int) height);
            setLocation(x, y);

            ce = new JButton("Cerrar");
            ce.setVisible(true);
            ce.setLayout(null);
            ce.setOpaque(true);
            ce.setBorderPainted(false);
            ce.setBackground(new Color(255, 91, 91));
            ce.setForeground(Color.white);
            ce.addActionListener(cont);
            ce.setFont(new Font("Verdana", Font.PLAIN, 18));
            ce.setLocation(this.getWidth() / 2, 0);
            ce.setSize(this.getWidth() / 2, this.getHeight() / 2);
            add(ce);

            con = new JButton("Configuración");
            con.setVisible(true);
            con.setLayout(null);
            con.setOpaque(true);
            con.setBorderPainted(false);
            con.setBackground(Color.gray);
            con.setForeground(Color.white);
            con.setFont(new Font("Verdana", Font.PLAIN, 18));
            con.setLocation(this.getWidth() / 2, ce.getHeight());
            con.setSize(this.getWidth() / 2, this.getHeight() / 2);
            add(con);
        }
    }
}
