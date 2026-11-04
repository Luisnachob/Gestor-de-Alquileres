package trabajogrupo;

public class PagoPlin extends PagoVirtual{
    private String numeroOperacion;
    private static final double TAZA_DIARIA = 0.01;

    public PagoPlin(String idpago, String dniInquilino, String idHabitacion, double monto, String fechaPago, String metodoPago, String constancia, String numeroOperacion) {
        super(idpago, dniInquilino, idHabitacion, monto, fechaPago, metodoPago, constancia);
        this.setNumeroOperacion(numeroOperacion);
    }
    
    @Override
    public double calcularRecargo() {
        return monto*TAZA_DIARIA*diasDeRetraso();
    }
    
    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        if (!numeroOperacion.trim().equals(""))
            this.numeroOperacion = numeroOperacion.trim().toUpperCase();
    }    
}
