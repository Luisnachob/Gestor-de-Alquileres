package trabajogrupo;

public class PagoEfectivo extends PagoPresencial{
    private double montoRecibido;
    private static final double TAZA_DIARIA = 0.02;
    
    public PagoEfectivo(String idpago, String dniInquilino, String idHabitacion, double monto, String fechaPago, String metodoPago, double montoRecibido) {
        super(idpago, dniInquilino, idHabitacion, monto, fechaPago, metodoPago);
        this.setMontoRecibido(montoRecibido);
        
    }

    @Override
    public double calcularRecargo() {
        return monto*TAZA_DIARIA*diasDeRetraso();
    }

    public double getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(double montoRecibido) {
        if (monto > 0)
            this.montoRecibido = montoRecibido;
    }
    
    
}
