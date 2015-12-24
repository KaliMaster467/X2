/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author DANY
 */
public class Subir extends Ventana{
    public BarraLateral late;
    protected Control cont;
    public Dimension Dim;
    protected Exames exa;
    public Subir() {
        
        
        
    }
    public void SubirIn(){
        
        dim = super.getToolkit().getScreenSize();
        
        setVisible(true);
        setLocation(0,0);
        setSize(dim);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //late = new BarraLateral(0,0, (int)dim.getWidth(), (int)dim.getHeight());
        //add(late);
        late = new BarraLateral(this.getWidth()/3, 0,/*(int)dim.getWidth()*/(this.getWidth()/3)*2, (int)dim.getHeight());
        add(late);
        
        exa = new Exames(0,0,this.getWidth()/3, this.getHeight());
        add(exa);
        
    }
    public class BarraLateral extends JPanel{
    private Exames barra;
    public BarraLateral(int x, int y, int width, int height) {
        setBackground(Color.orange);
        setVisible(true);
        setLayout(null);
        setLocation(x,y);
        setSize(width, height);
        
        //barra = new Exames(0,0,this.getWidth()/6, this.getHeight()) ;
        //add(barra); 
        }
        
    }
    public class Exames extends JPanel implements ActionListener{
        private JButton Subido;
        private JButton Modificado;
        private JButton elim;
        private JButton reg;
        private Control cont;
        private JButton back;
        
        public Exames(int x, int y, int width, int height) {
            setBackground(Color.white);
            setVisible(true);
            setLayout(null);
            setLocation(x,y);
            setSize(width, height);
            
            cont = new Control();
            
            int botonesW = this.getWidth();
            int botonesH = this.getHeight()/10;
            
            Subido = new JButton("SUBIR EXAMEN");
            Subido.setVisible(true);
            Subido.setOpaque(true);
            Subido.setBorderPainted(false);
            Subido.setBackground(Color.lightGray);
            Subido.setForeground(Color.white);
            Subido.setLocation(0,0);
            Subido.setSize(botonesW, botonesH);
            Subido.addActionListener(this);
            Subido.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(Subido);
            
            Modificado = new JButton("MODIFICAR\nEXAMEN");
            Modificado.setVisible(true);
            Modificado.setOpaque(true);
            Modificado.setBorderPainted(false);
            Modificado.setBackground(new Color(107, 185, 240));
            Modificado.setForeground(Color.white);
            Modificado.setLocation(0,Subido.getHeight());
            Modificado.setSize(botonesW, botonesH);
            Modificado.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(Modificado);
            
            elim = new JButton("ELIMINAR\nEXAMEN");
            elim.setVisible(true);
            elim.setOpaque(true);
            elim.setBorderPainted(false);
            elim.setBackground(new Color(255, 103, 103));
            elim.setForeground(Color.white);
            elim.setLocation(0,(Subido.getHeight())*2);
            elim.setSize(botonesW, botonesH);
            elim.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(elim);
            
            reg = new JButton("Subir Apuntes");
            reg.setVisible(true);
            reg.setOpaque(true);
            reg.setBorderPainted(false);
            reg.setBackground(new Color(90, 255, 126));
            reg.setForeground(Color.white);
            reg.setLocation(0,Subido.getHeight()*3);
            reg.setSize(botonesW, botonesH);
            reg.addActionListener(cont);
            reg.setFont(new Font("Verdana", Font.PLAIN, 15));
            add(reg);
            
            back = new JButton("Regresar");
            back.setVisible(true);
            back.setLayout(null);
            back.setOpaque(true);
            back.setBorderPainted(false);
            back.setBackground(Color.yellow);
            back.addActionListener(cont);
            back.setSize(botonesW /2, botonesH);
            back.setLocation(0, botonesH*7);
            add(back);
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equals("SUBIR EXAMEN")){
                
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg","*.MP4", "mp4", "*.PNG", "png");
                FileNameExtensionFilter fil = new FileNameExtensionFilter("*.MP4", "mp4");
                FileNameExtensionFilter fe = new FileNameExtensionFilter("*.DOCX", "docx");
                
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(filtro);
                fc.setFileFilter(fil);
                fc.setFileFilter(fe);
                int seleccion = fc.showOpenDialog(this);
                
                if(seleccion==JFileChooser.APPROVE_OPTION){
                    
                    File ficher = fc.getSelectedFile();
                    
                    try(FileReader fr = new FileReader(ficher)){
                        
                        String cadena = "";
                        int valor = fr.read();
                        while(valor!=-1){
                            
                            cadena = cadena+(char)valor;
                            valor=fr.read();
                            
                        }
                        //Aqui se trata el archivo Dan.
                        
                    }catch(IOException ex){
                        
                        ex.printStackTrace();
                        
                    }
                    
                }
                
            }else if(e.getActionCommand().equals("Subir Apuntes")){
                
                
                
            }
            
        }
    }
}


