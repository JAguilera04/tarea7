/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import datos.Gestor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class Ventana extends JFrame implements ActionListener {

    Mostrar v2;
    JPanel panel;
    JTextField cajaTexto;
    JButton botonCarga;
    JLabel etiqueta;

    public Ventana() {
        this.setSize(500, 500);
        this.setTitle("Inicio");
        iniciarComponentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes() {
        iniciarPaneles();
        crearCajas();
        crearEtiquetas();
        crearBotones();

    }

    private void iniciarPaneles() {
        panel = new JPanel();

        panel.setLayout(null);

        this.getContentPane().add(panel); //agrega un panel a la ventana

    }

    private void crearEtiquetas() {
        etiqueta = new JLabel("Ingresar nombre del archivo:");
        etiqueta.setBounds(125, 40, 200, 50);
        panel.add(etiqueta);
    }

    private void crearCajas() {
        cajaTexto = new JTextField();
        cajaTexto.setBounds(125, 75, 250, 75);

        panel.add(cajaTexto);

    }

    private void crearBotones() {
        botonCarga = new JButton("Cargar Archivo");

        botonCarga.setBounds(190, 175, 125, 75);
        panel.add(botonCarga);

        //crear accion al boton
        ActionListener accionCarga = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Gestor j = new Gestor();
                String texto = "";
                String ruta = cajaTexto.getText();
                String texto1 = j.leerArchivo(ruta);
                if (texto1.equals(j.leerArchivo("archivo1.txt"))) {
                    texto = j.leerArchivopar(ruta);
                }
                if (texto1.equals(j.leerArchivo("archivo2.txt"))) {
                    texto = j.leerArchivoSinSaltos(ruta);
                }
                Mostrar n = new Mostrar();
                n.setVisible(true);
                n.setTextoAsmostrar(texto);
                dispose();

            }
        };
        botonCarga.addActionListener(accionCarga);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
