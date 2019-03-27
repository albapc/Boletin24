package boletin24;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener {

    JFrame marco;
    JPanel panelPrincipal, panelArriba, panelAbajo;
    JTextField liTexto1;
    JPasswordField liTexto2;
    JLabel etiqueta1, etiqueta2;
    JButton boton1, boton2, boton3;
    String ciclos[] = {"1º Adm. y Finanzas", "2º Adm. y Finanzas", "1º ASIR",
        "2º ASIR", "1º DAM", "2º DAM"};
    JTextArea aTexto;
    JList cfgs;

    public void crearVentana() {
        //creamos la ventana y le damos tamaño
        marco = new JFrame("Boletín 24"); //titulo de la ventana
        marco.setSize(600, 600); //tamaño de la ventana

        //creamos el panel principal que contendrá los subpaneles
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(800, 600); //tamaño del panel prinicpal
        panelPrincipal.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white)); //creamos los bordes

        //creamos el panel de arriba, ponemos el layout a null para q podamos mover los elementos libremente
        panelArriba = new JPanel();
        panelArriba.setLayout(null);
        panelArriba.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));

        //creamos el de abajo
        panelAbajo = new JPanel();
        panelAbajo.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));

        /* ***** ELEMENTOS PRIMER PANEL ***** */
        //creamos el campo de texto nombre con su tamaño
        liTexto1 = new JTextField(20);
        liTexto1.setBounds(250, 80, 165, 25);

        //creamos el campo de texto para la contraseña
        liTexto2 = new JPasswordField(20);
        liTexto2.setBounds(250, 140, 165, 25);

        //creamos las etiquetas de texto para que muestren "nome" y "password"
        etiqueta1 = new JLabel();
        etiqueta1.setText("NOME");
        etiqueta1.setBounds(150, 80, 80, 25);

        etiqueta2 = new JLabel();
        etiqueta2.setText("PASSWORD");
        etiqueta2.setBounds(150, 140, 80, 25);

        //creamos los botones y ponemos su tamaño
        boton1 = new JButton("PREMER");
        boton1.setBounds(150, 220, 100, 25);

        boton2 = new JButton("LIMPAR");
        boton2.setBounds(340, 220, 100, 25);
        boton2.addActionListener(this); //declaramos que este boton irá enlazado a una accion, q declaramos debajo
        //this indica que la accion se realiza en la misma clase

        //añadimos los componentes al subpanel de arriba
        panelArriba.add(etiqueta1);
        panelArriba.add(etiqueta2);
        panelArriba.add(liTexto1);
        panelArriba.add(liTexto2);
        panelArriba.add(boton1);
        panelArriba.add(boton2);

        //ponemos un layout que muestre los subpaneles uno encima de otro y los añadimos al panel principal
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.add(panelArriba);
        panelPrincipal.add(panelAbajo);

        /* ***** ELEMENTOS SEGUNDO PANEL ***** */
        panelAbajo.setLayout(null);

        //añadimos los elementos del array a una lista
        cfgs = new JList(ciclos);
        cfgs.setBounds(40, 70, 120, 120);
        cfgs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //solo se puede seleccionar un curso

        //creamos el boton que almacenara los datos
        boton3 = new JButton("BOTON");
        boton3.setBounds(230, 100, 100, 25);
        boton3.addActionListener(this);

        //creamos el area de texto donde se mostraran los datos que introduzcamos
        aTexto = new JTextArea(100, 100);
        aTexto.setBounds(400, 70, 130, 100);
        
        //añadimos los componentes al subpanel de abajo
        panelAbajo.add(cfgs);
        panelAbajo.add(boton3);
        panelAbajo.add(aTexto);

        //añadimos todo al marco
        marco.add(panelPrincipal);

        //hacemos la ventana visible
        marco.setVisible(true);

        //configuramos que el programa finalice al cerrar la ventana
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == boton3) {
            if(cfgs.isSelectionEmpty() == true) {
                aTexto.setText(liTexto1.getText() + "\nCurso sin seleccionar");
            } else {
                aTexto.setText(liTexto1.getText() + "\n" + (String) cfgs.getSelectedValue());
            }
        } else if (ae.getSource() == boton2) {
            liTexto1.setText("");
            liTexto2.setText("");
            aTexto.setText("");
            cfgs.clearSelection();
        }
    }
}
