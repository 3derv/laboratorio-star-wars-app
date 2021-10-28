package Tabla;

import java.awt.BorderLayout;
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


    public Tabla() {
        String[] columnas = {"Nombre", "Altura", "Año de nacimiento"};
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

    private void agregarDatos(DefaultTableModel modelo) {
        // Borramos todas las filas en la tabla
        modelo.setRowCount(0);

        // Creamos los datos de una fila de la tabla
        Object[] datosFila = {"carlos", "1.66", "1946"};

        // agregamos esos datos
        modelo.addRow(datosFila);

        // Creamos las lista
        List list = new ArrayList();
        list.add("Andrea");
        list.add("1.94 m");
        list.add("1875");
        list.add("pedro");
        list.add("1.75 m");
        list.add("1923");
        list.add("albertp");
        list.add("1.85 m");
        list.add("1845");

        // Agregamos MUCHOS mas datos
        int cont = 0;
        for(int x=0; x < 2; x++) {
            datosFila[0] = list.get(cont);
            datosFila[1] =  list.get(cont + 1);
            datosFila[2] = list.get(cont + 2);
            cont += 3;


            modelo.addRow(datosFila);
        }
    }

    static public void main(String[] args) {
        Tabla tabla = new Tabla();

        tabla.setLocationRelativeTo(null);
        tabla.setVisible(true);

    }
}
