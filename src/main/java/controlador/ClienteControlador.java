package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.GestorArchivos;
import vista.ClienteVista;

public class ClienteControlador {

    private ClienteVista vista;
    private GestorArchivos gestor;
    private List<Cliente> clientes;
    private Cliente clienteActual;

    public ClienteControlador(ClienteVista vista, GestorArchivos gestor) {
        this.vista = vista;
        this.gestor = gestor;
        
        // Inicializar la lista de clientes
        try {
            this.clientes = gestor.leerClientes();
        } catch (IOException e) {
            // Si el archivo no existe o hay otro error, inicializar una lista vacía
            this.clientes = new ArrayList<>();
        }
        
        this.vista.getMenuItemNuevo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                clienteActual = null;
                JOptionPane.showMessageDialog(vista, "Formulario listo para nuevo cliente");
            }
        });
        
        this.vista.getMenuItemGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCliente();
            }
        });
        
        this.vista.getMenuItemConsultar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCliente();
            }
        });
        
        this.vista.getMenuItemModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarCliente();
            }
        });

        this.vista.getMenuItemEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCliente();
            }
        });
        
        this.vista.getMenuItemSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    private void limpiarFormulario() {
        vista.getTxtNid().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtEmail().setText("");
        vista.getTxtNoTelf().setText("");
        vista.getTxtDireccion().setText("");
    }
    
    private void guardarCliente() {
        try {
            // Validar que los campos obligatorios estén completos
            if (vista.getTxtNid().getText().isEmpty() || vista.getTxtNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "El NID y el Nombre son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear un nuevo cliente con los datos del formulario
            String nid = vista.getTxtNid().getText();
            String nombre = vista.getTxtNombre().getText();
            String apellido = vista.getTxtApellido().getText();
            String email = vista.getTxtEmail().getText();
            String noTelf = vista.getTxtNoTelf().getText();
            int genero = 0; // Por defecto, se podría agregar un combo box para seleccionar
            int edad = 0;   // Por defecto, se podría agregar un campo numérico
            String direccion = vista.getTxtDireccion().getText();
            
            Cliente nuevoCliente = new Cliente(nid, nombre, apellido, email, noTelf, genero, edad, direccion);
            
            // Verificar si estamos modificando un cliente existente o creando uno nuevo
            boolean clienteExistente = false;
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getNid().equals(nid)) {
                    clientes.set(i, nuevoCliente);
                    clienteExistente = true;
                    break;
                }
            }
            
            // Si no existe, agregarlo a la lista
            if (!clienteExistente) {
                clientes.add(nuevoCliente);
            }
            
            // Guardar los clientes en el archivo
            gestor.guardarClientes(clientes);
            
            JOptionPane.showMessageDialog(vista, "Cliente guardado exitosamente");
            limpiarFormulario();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(vista, "Error al guardar el cliente: " + e.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void consultarCliente() {
        String nidBuscar = JOptionPane.showInputDialog(vista, "Ingrese el NID del cliente a consultar:");
        if (nidBuscar != null && !nidBuscar.isEmpty()) {
            try {
                // Actualizar la lista de clientes desde el archivo
                clientes = gestor.leerClientes();
                
                // Buscar el cliente por NID
                for (Cliente cliente : clientes) {
                    if (cliente.getNid().equals(nidBuscar)) {
                        // Mostrar los datos del cliente en el formulario
                        vista.getTxtNid().setText(cliente.getNid());
                        vista.getTxtNombre().setText(cliente.getNombre());
                        vista.getTxtApellido().setText(cliente.getApellido());
                        vista.getTxtEmail().setText(cliente.getEmail());
                        vista.getTxtNoTelf().setText(cliente.getNoTelf());
                        vista.getTxtDireccion().setText(cliente.getDireccion());
                        
                        clienteActual = cliente;
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(vista, "Cliente no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(vista, "Error al consultar clientes: " + e.getMessage(), 
                                             "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    
    private void modificarCliente() {
        String nidModificar = JOptionPane.showInputDialog(vista, "Ingrese el NID del cliente a modificar:");
        if (nidModificar != null && !nidModificar.isEmpty()) {
            try {
                // Actualizar la lista de clientes desde el archivo
                clientes = gestor.leerClientes();
                
                // Buscar el cliente por NID
                for (Cliente cliente : clientes) {
                    if (cliente.getNid().equals(nidModificar)) {
                        // Mostrar los datos del cliente en el formulario para modificación
                        vista.getTxtNid().setText(cliente.getNid());
                        vista.getTxtNombre().setText(cliente.getNombre());
                        vista.getTxtApellido().setText(cliente.getApellido());
                        vista.getTxtEmail().setText(cliente.getEmail());
                        vista.getTxtNoTelf().setText(cliente.getNoTelf());
                        vista.getTxtDireccion().setText(cliente.getDireccion());
                        
                        clienteActual = cliente;
                        JOptionPane.showMessageDialog(vista, "Modifique los datos y luego presione Guardar");
                        return;
                    }
                }
                
                JOptionPane.showMessageDialog(vista, "Cliente no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(vista, "Error al buscar el cliente: " + e.getMessage(), 
                                             "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    
    private void eliminarCliente() {
        String nidEliminar = JOptionPane.showInputDialog(vista, "Ingrese el NID del cliente a eliminar:");
        if (nidEliminar != null && !nidEliminar.isEmpty()) {
            try {
                // Actualizar la lista de clientes desde el archivo
                clientes = gestor.leerClientes();
                
                boolean clienteEliminado = false;
                // Buscar y eliminar el cliente por NID
                for (int i = 0; i < clientes.size(); i++) {
                    if (clientes.get(i).getNid().equals(nidEliminar)) {
                        clientes.remove(i);
                        clienteEliminado = true;
                        break;
                    }
                }
                
                if (clienteEliminado) {
                    // Guardar la lista actualizada
                    gestor.guardarClientes(clientes);
                    JOptionPane.showMessageDialog(vista, "Cliente eliminado exitosamente");
                    limpiarFormulario();
                } else {
                    JOptionPane.showMessageDialog(vista, "Cliente no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(vista, "Error al eliminar el cliente: " + e.getMessage(), 
                                             "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}