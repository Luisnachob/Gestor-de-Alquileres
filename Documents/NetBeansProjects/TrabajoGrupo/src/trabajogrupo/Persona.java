package trabajogrupo;


public abstract class Persona {
    protected String dni;
    protected String nombre;
    protected String apellidos;

    public Persona(String dni, String nombre, String apellidos) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if(!apellidos.trim().equals(" "))    
            this.apellidos = apellidos;
    }
    
    
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if(!dni.trim().equals(" "))
            this.dni = dni.trim().toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(!nombre.trim().equals(" "))
            this.nombre = nombre;
    }
    
    public abstract void imprimirDatos(); {
    }
}
