
import modelo.GestorArchivos;
import vista.ClienteVista;
import controlador.ClienteControlador;

public class Main {

    public static void main(String[] args) {
        ClienteVista vista = new ClienteVista();
        GestorArchivos gestor = new GestorArchivos();
        ClienteControlador controlador = new ClienteControlador(vista, gestor);
        vista.setVisible(true);
    }
}