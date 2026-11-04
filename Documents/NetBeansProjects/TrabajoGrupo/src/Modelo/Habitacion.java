package Modelo;
public class Habitacion implements Mantenible {
    private String id_habitacion;
    private int piso;
    private String numero_cuarto;
    private double precio_mensual;
    private String estado;

    public Habitacion(String id_habitacion, int piso, String numero_cuarto, double precio_mensual, String estado) {
        setId_habitacion(id_habitacion);
        setPiso(piso);
        setNumero_cuarto(numero_cuarto);
        setPrecio_mensual(precio_mensual);
        setEstado(estado);
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        if(id_habitacion!=null && !id_habitacion.trim().isEmpty())
        this.id_habitacion = id_habitacion.trim().toUpperCase();
        else
            throw new IllegalArgumentException("La habitacion no puede estar vacia");
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        if(piso>=1 && piso<=5)
        this.piso = piso;
        else
            throw new IllegalArgumentException("Piso inexistente");
    }

    public String getNumero_cuarto() {
        return numero_cuarto;
    }

    public void setNumero_cuarto(String numero_cuarto) {
        if(numero_cuarto!=null && !numero_cuarto.trim().isEmpty())
        this.numero_cuarto = numero_cuarto.trim().toUpperCase();
        else
            throw new IllegalArgumentException("El numero de cuarto no puede estar vacio");
    }

    public double getPrecio_mensual() {
        return precio_mensual;
    }

    public void setPrecio_mensual(double precio_mensual) {
        if(precio_mensual<0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        else
        this.precio_mensual = precio_mensual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if(estado!=null &&(estado.toUpperCase().equals("DISPONIBLE") || estado.toUpperCase().equals("OCUPADO"))){
            this.estado=estado.toUpperCase();
        }
        
        else
            throw new IllegalArgumentException("Estado invalido");
    }
    @Override
    public void actualizar_estado(){
        if(estado.equals("DISPONIBLE")){
            setEstado("OCUPADO");
        }
        else{
            setEstado("DISPONIBLE");
        }
    }
}
