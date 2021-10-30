package com.maintabla;

import JSONManager.Character;
import JSONManager.DatosPersonajes;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {

    private JTable tabla = null;
    DefaultTableModel modelo = null;
    JScrollPane desplazamiento = null;


    public Tabla() throws IOException {
        String[] columnas = {"Nombre", "Altura", "Fecha de nacimiento"};
        tabla = new JTable();
        modelo = new DefaultTableModel();
        desplazamiento = new JScrollPane(tabla);

        // Parametros de la ventana
        this.setTitle("JTable");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);

        // Barras de desplazamiento
        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Propiedades de la tabla
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setFillsViewportHeight(true);

        tabla.setModel(modelo);

        // Agregamos datos
        this.agregarDatos(modelo);


        // Agregando elementos a la ventana
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
        this.pack();
    }

    private void agregarDatos(DefaultTableModel modelo) throws IOException {
        // Borramos todas las filas en la tabla
        modelo.setRowCount(0);
        //Se obtienen los datos del JSON
        DatosPersonajes datospersonajes = new DatosPersonajes();

        List<Character> datos = datospersonajes.obtenerDatos();
        System.out.println("El tamaño de la lista de datos es: "+datos.size());
        // Creamos los datos de una fila de la tabla
        Object[] datosFila = {datos.get(0).getName(),datos.get(0).getHeight(),datos.get(0).getBirth_year()};

        // agregamos esos datos
        modelo.addRow(datosFila);


        // Agregamos MUCHOS mas datos
        for(int cont=1; cont < datos.size()-1; cont++) {
            datosFila[0] = datos.get(cont).getName();
            datosFila[1] = datos.get(cont).getHeight();
            datosFila[2] = datos.get(cont).getBirth_year();


            modelo.addRow(datosFila);
        }
    }

    static public void main(String[] args) throws IOException {
        Tabla tabla = new Tabla();

        tabla.setLocationRelativeTo(null);
        tabla.setVisible(true);

    }
}
