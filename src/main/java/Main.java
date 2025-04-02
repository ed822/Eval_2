import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controlador.ClienteControlador;
import modelo.GestorArchivos;
import vista.ClienteVista;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ClienteVista vista = new ClienteVista();
                    GestorArchivos gestor = new GestorArchivos();
                    ClienteControlador controlador = new ClienteControlador(vista, gestor);
                    vista.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage(), 
                                                 "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
    }
}