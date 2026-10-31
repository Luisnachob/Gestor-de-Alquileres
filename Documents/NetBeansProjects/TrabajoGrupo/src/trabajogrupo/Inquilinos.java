package trabajogrupo;


public class Inquilinos extends Persona {
    private static final int ESTRELLAS_MINIMO =1;
    private static final int ESTRELLAS_MAXIMAS = 5;
    private String telefono;
    private int puntuacionEstrellas;
    
    public Inquilinos(String telefono, int puntuacionEstrella, String dni, String nombre, String apellidos) {
        super(dni, nombre, apellidos);
        this.setTelefono(telefono);
        this.puntuacionEstrellas = ESTRELLAS_MAXIMAS;
    }
   
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(!telefono.trim().equals(""))
            this.telefono = telefono;
    }

    public int getPuntuacionEstrella() {
        return puntuacionEstrellas;
    }

    public void setPuntuacionEstrella(int puntuacionEstrella) {
        if (puntuacionEstrellas < ESTRELLAS_MINIMO || puntuacionEstrellas > ESTRELLAS_MAXIMAS) {
            throw new IllegalArgumentException(
                "La puntuación debe estar entre " + ESTRELLAS_MINIMO + " y " + ESTRELLAS_MAXIMAS + ".");
         }
            this.puntuacionEstrellas = puntuacionEstrellas;
    }
    
    @Override
    public void imprimirDatos() {
        System.out.println("DNI:" + dni);
        System.out.println("Nombres: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Teléfono : " + telefono);
        System.out.println("Puntuacion: " + puntuacionEstrellas + "Estrellas");
    }
    
}
