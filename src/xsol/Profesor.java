/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsol;

import java.io.IOException;

/**
 *
 * @author Bugatti
 */
public class Profesor extends Usuario{

    public Profesor(String nombre, String clave, String grupo) throws IOException {
        super(nombre, clave, grupo);
    }
}
