package vista;

import javax.swing.*;
import java.awt.*;

public class ClienteVista extends JFrame {

    private JTextField txtNid, txtNombre, txtApellido, txtEmail, txtNoTelf, txtDireccion;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemNuevo, menuItemGuardar, menuItemConsultar, menuItemModificar, menuItemEliminar, menuItemSalir;

    public ClienteVista() {
        setTitle("Gestión de Clientes");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Menú
        menuBar = new JMenuBar();
        menu = new JMenu("Opciones");
        menuItemNuevo = new JMenuItem("Nuevo");
        menuItemGuardar = new JMenuItem("Guardar");
        menuItemConsultar = new JMenuItem("Consultar");
        menuItemModificar = new JMenuItem("Modificar");
        menuItemEliminar = new JMenuItem("Eliminar");
        menuItemSalir = new JMenuItem("Salir");
        
        // Anadir al menu
        menu.add(menuItemNuevo);
        menu.add(menuItemGuardar);
        menu.add(menuItemConsultar);
        menu.add(menuItemModificar);
        menu.add(menuItemEliminar);
        menu.add(menuItemSalir);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        // Campos de texto y etiquetas
        add(new JLabel("NID:"));
        txtNid = new JTextField();
        add(txtNid);
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);
        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);
        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);
        add(new JLabel("No. Teléfono:"));
        txtNoTelf = new JTextField();
        add(txtNoTelf);
        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);
    }

    // Getters para los campos de texto y los menús
    /// Getters
    public JTextField getTxtNid() { return txtNid; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtApellido() { return txtApellido; }
    public JTextField getTxtEmail() { return txtEmail; }
    public JTextField getTxtNoTelf() { return txtNoTelf; }
    public JTextField getTxtDireccion() { return txtDireccion; }
    public JMenu getMenu() { return menu; }
    public JMenuItem getMenuItemNuevo() { return menuItemNuevo; }
    public JMenuItem getMenuItemGuardar() { return menuItemGuardar; }
    public JMenuItem getMenuItemConsultar() { return menuItemConsultar; }
    public JMenuItem getMenuItemModificar() { return menuItemModificar; }
    public JMenuItem getMenuItemEliminar() { return menuItemEliminar; }
    public JMenuItem getMenuItemSalir() { return menuItemSalir; }


    /// Setters
    public void setTxtNid(JTextField txtNid) { this.txtNid = txtNid; }
    public void setTxtNombre(JTextField txtNombre) { this.txtNombre = txtNombre; }
    public void setTxtApellido(JTextField txtApellido) { this.txtApellido = txtApellido; }
    public void setTxtEmail(JTextField txtEmail) { this.txtEmail = txtEmail; }
    public void setTxtNoTelf(JTextField txtNoTelf) { this.txtNoTelf = txtNoTelf; }
    public void setTxtDireccion(JTextField txtDireccion) { this.txtDireccion = txtDireccion; }
    public void setMenu(JMenu menu) { this.menu = menu; }
    public void setMenuItemNuevo(JMenuItem menuItemNuevo) { this.menuItemNuevo = menuItemNuevo; }
    public void setMenuItemGuardar(JMenuItem menuItemGuardar) { this.menuItemGuardar = menuItemGuardar; }
    public void setMenuItemConsultar(JMenuItem menuItemConsultar) { this.menuItemConsultar = menuItemConsultar; }
    public void setMenuItemModificar(JMenuItem menuItemModificar) { this.menuItemModificar = menuItemModificar; }
    public void setMenuItemEliminar(JMenuItem menuItemEliminar) { this.menuItemEliminar = menuItemEliminar; }
    public void setMenuItemSalir(JMenuItem menuItemSalir) { this.menuItemSalir = menuItemSalir; }
}
