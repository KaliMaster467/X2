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
public class Plano extends JPanel {

    int ancho = 0;
    int alto = 0;

    public double getHP1() {
        return HP1;
    }

    public void setHP1(double HP1) {
        this.HP1 = HP1;
    }

    public double getKP1() {
        return KP1;
    }

    public void setKP1(double KP1) {
        this.KP1 = KP1;
    }

    public double getPP1() {
        return PP1;
    }

    public void setPP1(double PP1) {
        this.PP1 = PP1;
    }

    public double getB2() {
        return b2;
    }

    public void setB2(double b2) {
        this.b2 = b2;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
    double b2, b;
    double X1, Y1, Ent;
    double X2, Y2;
    double HP1, KP1, PP1;
    double YR1, YR2, YP1, YP2, XP1, XP2;//
    double YE1, YE2, XE1, XE2;
    int tipoElipse = 0;
    double AX, CX;
    int tipoHiper = 0;
    double YH1, YH2, XH1, XH2;

    public double getXH() {
        return XH;
    }

    public void setXH(double XH) {
        this.XH = XH;
    }

    public double getAH() {
        return AH;
    }

    public void setAH(double AH) {
        this.AH = AH;
    }

    public double getYH() {
        return YH;
    }

    public void setYH(double YH) {
        this.YH = YH;
    }

    public double getBH() {
        return BH;
    }

    public void setBH(double BH) {
        this.BH = BH;
    }
    double XH, AH, YH, BH;

    public int getTipoHiper() {
        return tipoHiper;
    }

    public void setTipoHiper(int tipoHiper) {
        this.tipoHiper = tipoHiper;
    }

    public double getAX() {
        return AX;
    }

    public void setAX(double AX) {
        this.AX = AX;
    }

    public double getCX() {
        return CX;
    }

    public void setCX(double CX) {
        this.CX = CX;
    }

    public int getTipoElipse() {
        return tipoElipse;
    }

    public void setTipoElipse(int tipoElipse) {
        this.tipoElipse = tipoElipse;
    }

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

    public double getX2() {
        return X2;
    }

    public void setX2(double X2) {
        this.X2 = X2;
    }

    public double getY2() {
        return Y2;
    }

    public void setY2(double Y2) {
        this.Y2 = Y2;
    }

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
    public Plano(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        init();
        setSize(ancho, alto);
        setLocation(0, 0);

    }

    public void init() {

        this.setBorder(BorderFactory.createLineBorder(Color.black));

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(new Color(177, 228, 255));
        double los40divisiones = .000;
        for (int i = 0; i < 40; i++) {

            g.drawLine(0, (int) Math.floor(this.getHeight() * los40divisiones), ancho, (int) Math.floor(this.getHeight() * los40divisiones));
            g.drawLine((int) Math.floor(this.getWidth() * los40divisiones), 0, (int) Math.floor(this.getWidth() * los40divisiones), alto);
            los40divisiones += .025;

        }
        //PINTAR GRAFICA INGRESADA
        if (tipo != 0) {

            //Recta
            if (this.tipo == 1) {
                g.setColor(new Color(0, 24, 125));
                double x1 = 80;//Tambien sirven como ys
                double x2 = 79;
                for (int z = 0; z < 160; z++) {
                    YR1 = ((-((this.X1) * x1)) - (this.Ent)) / this.Y1;
                    YR2 = ((-((this.X1) * x2)) - (this.Ent)) / this.Y1;
                    int y1graf = (int) Math.floor((this.getHeight() / 2) - (YR1 * (getHeight() * 0.025)));
                    int y2graf = (int) Math.floor((this.getHeight() / 2) - (YR2 * (getHeight() * 0.025)));
                    int x1graf = (int) Math.floor((this.getWidth() / 2) + (x1 * (getWidth() * 0.025)));

                    int x2graf = (int) Math.floor((this.getWidth() / 2) + (x2 * (getWidth() * 0.025)));
                    x1 = x2;
                    x2--;
                    g.drawLine(x1graf, y1graf, x2graf, y2graf);

                }

            } //PARABOLA
            else if (this.tipo > 20) {
                int cuantas = 0;
                double x1, x2, y1, y2;
                g.setColor(new Color(186, 24, 74));
                if (this.tipo == 21) {
                    
                    for (int Y = 0; Y < 2; Y++) {
                        
                        if (this.PP1 > 0) {
                            cuantas = (int) ((20 - HP1) * 10);
                            x1 = HP1;
                            x2 = HP1 + .125;
                        } else {
                            cuantas = (int) ((20 + HP1) * 10);
                            x1 = HP1;
                            x2 = HP1 -.125;
                        }

                        for (int z = 0; z < cuantas; z++) {
                            double raiz1 = 4 * PP1 * (x1 - HP1);
                            double raiz2 = 4 * PP1 * (x2 - HP1);
                            double yValue = (Math.sqrt(raiz1)) + KP1;
                            double yValue2 = (Math.sqrt(raiz2)) + KP1;
                            if (Y==0) {
                                this.YP1 = (yValue);
                                this.YP2 = (yValue2);
                            }else {
                                this.YP1 = -(yValue);
                                this.YP2 = -(yValue2);
                            }
                            int y1graf, y2graf, x1graf, x2graf;
                            if(Y==0) {
                                y1graf = (int) Math.floor((this.getHeight() / 2) - (YP1 * (getHeight() * .025)));
                                y2graf = (int) Math.floor((this.getHeight() / 2) - (YP2 * (getHeight() * .025)));
                            }else {
                                y1graf = (int) Math.floor((this.getHeight() / 2) - ((YP1+(KP1*2)) * (getHeight() * .025)));
                                y2graf = (int) Math.floor((this.getHeight() / 2) - ((YP2+(KP1*2)) * (getHeight() * .025)));
                            }
                            x1graf = (int) Math.floor((this.getWidth() / 2) + (x1 * (getWidth() * 0.025)));
                            x2graf = (int) Math.floor((this.getWidth() / 2) + (x2 * (getWidth() * 0.025)));
                            if (this.PP1 > 0) {
                                x1 = x2;
                                x2 = x2 + .125;
                            } else {
                                x1 = x2;
                                x2 = x2 - .125;
                            }
                            g.drawLine(x1graf, y1graf, x2graf, y2graf);

                        }
                    }
                    
                    
                } else {
                    for (int Y = 0; Y < 2; Y++) {
                        
                        if (this.PP1 > 0) {
                            cuantas = (int) ((20 - KP1) * 8);
                            y1 = KP1;
                            y2 = KP1 + .125;
                        } else {
                            cuantas = (int) ((20 + KP1) * 8);
                            y1 = KP1;
                            y2 = KP1 -.125;
                        }

                        for (int z = 0; z < cuantas; z++) {
                            double raiz1 = 4 * PP1 * (y1 - KP1);
                            double raiz2 = 4 * PP1 * (y2 - KP1);
                            double yValue = (Math.sqrt(raiz1)) + HP1;
                            double yValue2 = (Math.sqrt(raiz2)) + HP1;
                            if (Y==0) {
                                this.XP1 = (yValue);
                                this.XP2 = (yValue2);
                            }else {
                                this.XP1 = -(yValue);
                                this.XP2 = -(yValue2);
                            }
                            int y1graf, y2graf, x1graf, x2graf;
                            if(Y==0) {
                                x1graf = (int) Math.floor((this.getWidth() / 2) + (XP1 * (getWidth() * 0.025)));
                                x2graf = (int) Math.floor((this.getWidth() / 2) + (XP2 * (getWidth() * 0.025)));
                                
                            }else {
                                x1graf = (int) Math.floor((this.getWidth() / 2) + ((XP1+(HP1 *2)) * (getWidth() * 0.025)));
                                x2graf = (int) Math.floor((this.getWidth() / 2) + ((XP2+(HP1*2)) * (getWidth() * 0.025)));
                            }
                                y1graf = (int) Math.floor((this.getHeight() / 2) - (y1 * (getHeight() * .025)));
                                y2graf = (int) Math.floor((this.getHeight() / 2) - (y2 * (getHeight() * .025)));
                            
                            if (this.PP1 > 0) {
                                y1 = y2;
                                y2 = y2 + .125;
                            } else {
                                y1 = y2;
                                y2 = y2 - .125;
                            }
                            g.drawLine(x1graf, y1graf, x2graf, y2graf);

                        }
                    }
                }

            } /*for (int z = 0; z < 2560; z++) {
                    if (this.tipo == 21) {
                        double Elevada = X2 * x1;
                        double Elevada1 = X2 * x2;

                        XP1 = (Ent + (Y2 * x1) + (Elevada * Elevada)) / -Y1;
                        XP2 = (Ent + (Y2 * x2) + (Elevada1 * Elevada1)) / -Y1;
                        int x1graf = (int) Math.floor((this.getWidth() / 2) + (XP1 * (getWidth() * 0.025)));
                        int x2graf = (int) Math.floor((this.getWidth() / 2) + (XP2 * (getWidth() * 0.025)));
                        int y1graf = (int) Math.floor((this.getHeight() / 2) - (x1 * (getHeight() * 0.025)));
                        int y2graf = (int) Math.floor((this.getHeight() / 2) - (x2 * (getHeight() * 0.025)));
                        x1 = x2;
                        x2 = x2 - .125;
                        g.drawLine(x1graf, y1graf, x2graf, y2graf);
                    } else {
                        double Elevada = X1 * x1;
                        double Elevada1 = X1 * x2;

                        YP1 = (Ent + (Y1 * x1) + (Elevada * Elevada)) / -Y2;
                        YP2 = (Ent + (Y1 * x2) + (Elevada1 * Elevada1)) / -Y2;
                        int x1graf = (int) Math.floor((this.getWidth() / 2) + (x1 * (getWidth() * 0.025)));
                        int x2graf = (int) Math.floor((this.getWidth() / 2) + (x2 * (getWidth() * 0.025)));
                        int y1graf = (int) Math.floor((this.getHeight() / 2) - (YP1 * (getHeight() * 0.025)));
                        int y2graf = (int) Math.floor((this.getHeight() / 2) - (YP2 * (getHeight() * 0.025)));
                        x1 = x2;
                        x2 = x2 - .125;
                        g.drawLine(x1graf, y1graf, x2graf, y2graf);
                    }
                }*/ else if (this.tipo
                    == 3) {
                b2 = (AX * AX) - (CX * CX);
                b = Math.sqrt(b2);
                g.setColor(new Color(170, 140, 7));
                if (this.tipoElipse == 31) {//PARALELA X

                    for (int i = 0; i < 2; i++) {
                        double x1 = AX;
                        double x2 = AX - .125;
                        for (int z = 0; z < ((AX * 2) * 8); z++) {
                            double raiz1 = (1 - ((x1 * x1) / (AX * AX))) * b2;
                            double raiz2 = (1 - ((x2 * x2) / (AX * AX))) * b2;
                            double YValue = Math.sqrt(raiz1);
                            double YValue2 = Math.sqrt(raiz2);
                            if (i == 0) {
                                YE1 = YValue;
                                YE2 = YValue2;
                            } else {
                                YE1 = -YValue;
                                YE2 = -YValue2;
                            }
                            int x1graf = (int) Math.floor((this.getWidth() / 2) + (x1 * (getWidth() * 0.025)));
                            int x2graf = (int) Math.floor((this.getWidth() / 2) + (x2 * (getWidth() * 0.025)));
                            int y1graf, y2graf;

                            y1graf = (int) Math.floor((this.getHeight() / 2) - (YE1 * (getHeight() * 0.025)));
                            y2graf = (int) Math.floor((this.getHeight() / 2) - (YE2 * (getHeight() * 0.025)));

                            x1 = x2;
                            x2 = x2 - .125;
                            g.drawLine(x1graf, y1graf, x2graf, y2graf);
                        }
                    }
                    g.setColor(new Color(25, 200, 45));
                    int x1s = (int) Math.floor((this.getWidth() / 2) + (CX * (getWidth() * .025)));
                    int x2s = (int) Math.floor((this.getWidth() / 2) - (CX * (getWidth() * .025)));
                    int y1s = (int) Math.floor(this.getHeight() / 2);
                    g.fillOval((x1s - 4), (y1s - 4), 9, 9);
                    g.fillOval((x2s - 4), (y1s - 4), 9, 9);
                    g.setColor(Color.CYAN);

                }
                if (this.tipoElipse == 32) {//PARALELA Y
                    for (int i = 0; i < 2; i++) {
                        double x1 = AX;
                        double x2 = AX - .125;
                        for (int z = 0; z < ((AX * 2) * 8); z++) {
                            double raiz1 = (1 - ((x1 * x1) / (AX * AX))) * b2;
                            double raiz2 = (1 - ((x2 * x2) / (AX * AX))) * b2;
                            double YValue = Math.sqrt(raiz1);
                            double YValue2 = Math.sqrt(raiz2);
                            if (i == 0) {
                                YE1 = YValue;
                                YE2 = YValue2;
                            } else {
                                YE1 = -YValue;
                                YE2 = -YValue2;
                            }
                            int y1graf = (int) Math.floor((this.getHeight() / 2) + (x1 * (getHeight() * 0.025)));
                            int y2graf = (int) Math.floor((this.getHeight() / 2) + (x2 * (getHeight() * 0.025)));
                            int x1graf, x2graf;

                            x1graf = (int) Math.floor((this.getWidth() / 2) - (YE1 * (getWidth() * 0.025)));
                            x2graf = (int) Math.floor((this.getWidth() / 2) - (YE2 * (getWidth() * 0.025)));

                            x1 = x2;
                            x2 = x2 - .125;
                            g.drawLine(x1graf, y1graf, x2graf, y2graf);
                        }
                    }
                }
            } else if (this.tipo
                    == 4) {
                //setcolor
                g.setColor(new Color(140, 15, 200));
                if (this.tipoHiper == 41) {
                    //paralela X
                    for (int i = 0; i < 2; i++) {
                        double x1pos = AH;
                        double x2pos = AH + .125;
                        double x1neg = -AH;
                        double x2neg = -AH - .125;
                        for (int z = 0; z < (AH * 20) * 8; z++) {
                            double raiz1 = ((BH * BH) * (((x1pos * x1pos) / (AH * AH)) - 1));
                            double raiz2 = ((BH * BH) * (((x2pos * x2pos) / (AH * AH)) - 1));
                            double yValue = Math.sqrt(raiz1);
                            double yValue2 = Math.sqrt(raiz2);
                            if (i == 0) {
                                YH1 = yValue;
                                YH2 = yValue2;
                            } else {
                                YH1 = -yValue;
                                YH2 = -yValue2;
                            }
                            int y1graf = (int) Math.floor(((getHeight()) / 2) - (YH1 * (getHeight() * .025)));
                            int y2graf = (int) Math.floor(((getHeight()) / 2) - (YH2 * (getHeight() * .025)));
                            int x1graf = (int) Math.floor(((getWidth()) / 2) + (x1pos * (getWidth() * .025)));
                            int x2graf = (int) Math.floor(((getWidth()) / 2) + (x2pos * (getWidth() * .025)));
                            int x3graf = (int) Math.floor(((getWidth()) / 2) + (x1neg * (getWidth() * .025)));
                            int x4graf = (int) Math.floor(((getWidth()) / 2) + (x2neg * (getWidth() * .025)));

                            x1pos = x2pos;
                            x2pos = x2pos + .125;
                            x1neg = x2neg;
                            x2neg = x2neg - .125;
                            g.drawLine(x1graf, y1graf, x2graf, y2graf);
                            g.drawLine(x3graf, y1graf, x4graf, y2graf);
                        }

                    }

                } else if (this.tipoHiper == 42) {
                    //Paralela Y
                    for (int i = 0; i < 2; i++) {
                        double x1pos = AH;
                        double x2pos = AH + .125;
                        double x1neg = -AH;
                        double x2neg = -AH - .125;
                        for (int z = 0; z < (AH * 20) * 8; z++) {
                            double raiz1 = ((BH * BH) * (((x1pos * x1pos) / (AH * AH)) - 1));
                            double raiz2 = ((BH * BH) * (((x2pos * x2pos) / (AH * AH)) - 1));
                            double yValue = Math.sqrt(raiz1);
                            double yValue2 = Math.sqrt(raiz2);
                            if (i == 0) {
                                XH1 = yValue;
                                XH2 = yValue2;
                            } else {
                                XH1 = -yValue;
                                XH2 = -yValue2;
                            }
                            int y1graf = (int) Math.floor(((getHeight()) / 2) - (x1pos * (getHeight() * .025)));
                            int y2graf = (int) Math.floor(((getHeight()) / 2) - (x2pos * (getHeight() * .025)));
                            int x1graf = (int) Math.floor(((getWidth()) / 2) + (XH1 * (getWidth() * .025)));
                            int x2graf = (int) Math.floor(((getWidth()) / 2) + (XH2 * (getWidth() * .025)));
                            int y3graf = (int) Math.floor(((getHeight()) / 2) - (x1neg * (getHeight() * .025)));
                            int y4graf = (int) Math.floor(((getHeight()) / 2) - (x2neg * (getHeight() * .025)));

                            x1pos = x2pos;
                            x2pos = x2pos + .125;
                            x1neg = x2neg;
                            x2neg = x2neg - .125;
                            g.drawLine(x1graf, y1graf, x2graf, y2graf);
                            g.drawLine(x1graf, y3graf, x2graf, y4graf);
                        }

                    }

                }
            }
        }

        g.setColor(Color.red);

        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());

    }

    public void paintSQRFunc(Graphics g, double x2mult, double x1mult, double cons,
            double x1, double x2) {

    }
}
