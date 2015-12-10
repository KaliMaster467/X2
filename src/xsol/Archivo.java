/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bugatti
 */
public class Archivo{
    
    private ArrayList <Usuario> users = new ArrayList<>();
    private ArrayList<Examenes> exam = new ArrayList<>();
    
    public ArrayList<Usuario> leer(){
        
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Usuarios.dat"));
            users = (ArrayList<Usuario>)in.readObject();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "***Bienvenido***");
        }
        return users;
    }
    public void Serializar(ArrayList<Usuario> user){
        
        try{
            FileOutputStream out = new FileOutputStream("Usuarios.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(user);
            objOut.close();
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
        
    }
    
    public ArrayList<Examenes> leerExamenes(){
        
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Examenes.dat"));
            exam = (ArrayList<Examenes>)in.readObject();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return exam;
    }
    public void SerializarExamenes(ArrayList<Examenes> examenes){
        
        try{
            FileOutputStream exout = new FileOutputStream("Examenes.dat");
            ObjectOutputStream objexout = new ObjectOutputStream(exout);
            objexout.writeObject(examenes);
            objexout.close();
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
        
    }
    
}

