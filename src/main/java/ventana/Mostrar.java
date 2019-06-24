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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author usuario
 */
public class Mostrar extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextArea cajaTexto;
    private JButton botonFormat;
    private JButton botonOtro;
    private String direccion;
    private String textoAsmostrar;

    public Mostrar(String direccion) {
        this.setSize(500, 500);
        iniciarComponentes(direccion);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    Mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void iniciarComponentes(String direccion) {
        iniciarPaneles();
        crearCajas(direccion
        );
        crearBotones(direccion
        );

    }

    private void iniciarPaneles() {
        panel = new JPanel();

        panel.setLayout(null);

        this.getContentPane().add(panel); //agrega un panel a la ventana

    }

    private void crearCajas(String direccion) {
        Gestor k=new Gestor();
        cajaTexto = new JTextArea();
        cajaTexto.setText(k.leerArchivo(direccion));
        //cajaTexto.setBounds(85, 240, 340, 150);

        JScrollPane sp = new JScrollPane(cajaTexto);
        sp.setBounds(85, 220, 360, 200);

        panel.add(sp);
    }

    private void crearBotones(String direccion) {
        botonFormat = new JButton("Formateo texto");
        botonOtro = new JButton("Cargar otro");

        //boton 1
        botonFormat.setBounds(85, 100, 125, 75);
        panel.add(botonFormat);
        ActionListener formatListen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Gestor ges = new Gestor();
                String textoFormat = ges.diferenciarArchivo(direccion);
                cajaTexto.setText(textoFormat);

            }
        };
        botonFormat.addActionListener(formatListen);

        //boton 2
        botonOtro.setBounds(285, 100, 126, 75);
        panel.add(botonOtro);
        ActionListener formatOtro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Ventana volver = new Ventana();
                volver.setVisible(true);
                dispose();

            }
        };
        botonOtro.addActionListener(formatOtro);

    }
     public void setjTextArea1(String texto) {
        this.cajaTexto.setText(texto);
    }

    public void setTextoAsmostrar(String textoAsmostrar) {
        this.textoAsmostrar = textoAsmostrar;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
