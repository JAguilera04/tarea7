/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import datos.Gestor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class Prueba {
    

          @Test(expected = NullPointerException.class)
        public void PruebaLeerArchivoPar() {
        Gestor k=new Gestor();
        
        String textoOriginal=k.leerArchivopar(null);
        
    }
    
    @Test(expected = NullPointerException.class)
    public void PruebaLeerArchivoSinSaltos() {
        Gestor k=new Gestor();
        
        String textoOriginal=k.leerArchivoSinSaltos(null);
        
    }
    
}

