/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Persona;
import java.util.List;

/**
 *
 * @author Andres
 */
public class ControladorPersona extends ListaGenerica<Persona> {

public Persona login(String correo, String contra){
List<Persona> p = getLista();
    for (int i = 0; i < p.size(); i++) {
        if (p.get(i).getCorreo().equals(correo)&&p.get(i).getContraseña().equals(contra)) {
          return p.get(i);
        }
    }
    return null;
}

   

    @Override
    public boolean validar(Persona objeto) {
        String correo=objeto.getCorreo();
        String contra=objeto.getContraseña();
        if (correo.length()>=20&&contra.length()>6) {
            return true;
        } 
        return false;
    }
    
}
