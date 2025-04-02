package controlador;

import modelo.Cliente;
import modelo.GestorArchivos;
import vista.ClienteVista;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ClienteControlador {

    private ClienteVista vista;
    private GestorArchivos gestor;

    public ClienteControlador(ClienteVista vista, GestorArchivos gestor) {
        this.vista = vista;
        this.gestor = gestor;
        this.vista.getMenuItemNuevo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para nuevo cliente
                JOptionPane.showMessageDialog(null, "Entro al nuevo item");
            }
        });
        this.vista.getMenuItemGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar cliente
                gestor.guardarClientes(clientes);
            }
        });
        this.vista.getMenuItemConsultar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, gestor.consultarClientes());
            }
        });
        this.vista.getMenuItemModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar cliente
            }
        });

        this.vista.getMenuItemEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar cliente
            }
        });
        this.vista.getMenuItemSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
