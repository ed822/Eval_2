package modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {

    private static final String CLIENTES_FILE = "clientes.json";
    private static final String USUARIOS_FILE = "usuarios.json";
    private Gson gson = new Gson();

    public List<Cliente> leerClientes() throws IOException {
        File file = new File(CLIENTES_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (FileReader reader = new FileReader(CLIENTES_FILE)) {
            Type listType = new TypeToken<List<Cliente>>() {}.getType();
            List<Cliente> clientes = gson.fromJson(reader, listType);
            return clientes != null ? clientes : new ArrayList<>();
        }
    }

    // Guardar
    public void guardarClientes(List<Cliente> clientes) throws IOException {
        try (FileWriter writer = new FileWriter(CLIENTES_FILE)) {
            gson.toJson(clientes, writer);
        }
    }

    // Método para consultar todos los clientes
    public List<Cliente> consultarClientes() {
        try (Reader reader = new FileReader(CLIENTES_FILE)) {
            Type listType = new TypeToken<List<Cliente>>() {}.getType();
            List<Cliente> lista = gson.fromJson(reader, listType);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void modificarCliente(Cliente clienteModificado) throws IOException {
        List<Cliente> clientes = leerClientes();
        boolean encontrado = false;
        
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNid().equals(clienteModificado.getNid())) {
                clientes.set(i, clienteModificado);
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            guardarClientes(clientes);
        }
    }
    
    public boolean eliminarCliente(String nid) throws IOException {
        List<Cliente> clientes = leerClientes();
        boolean eliminado = false;
        
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNid().equals(nid)) {
                clientes.remove(i);
                eliminado = true;
                break;
            }
        }
        
        if (eliminado) {
            guardarClientes(clientes);
        }
        
        return eliminado;
    }

    public List<Usuario> leerUsuarios() throws IOException {
        FileReader reader = new FileReader(USUARIOS_FILE);
        Type listType = new TypeToken<List<Usuario>>() {}.getType();
        List<Usuario> usuarios = gson.fromJson(reader, listType);
        reader.close();
        return usuarios != null ? usuarios : new ArrayList<>();
    }

    public void guardarUsuarios(List<Usuario> usuarios) throws IOException {
        FileWriter writer = new FileWriter(USUARIOS_FILE);
        gson.toJson(usuarios, writer);
        writer.close();
    }
}