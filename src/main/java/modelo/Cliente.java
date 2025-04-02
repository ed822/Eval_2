package modelo;

public class Cliente {

    private String nid;
    private String nombre;
    private String apellido;
    private String email;
    private String noTelf;
    private int genero;
    private int edad;
    private String direccion;

    public Cliente(String nid, String nombre, String apellido, String email, String noTelf, int genero, int edad, String direccion) {
        this.nid = nid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.noTelf = noTelf;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelf() {
        return noTelf;
    }

    public void setNoTelf(String noTelf) {
        this.noTelf = noTelf;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}