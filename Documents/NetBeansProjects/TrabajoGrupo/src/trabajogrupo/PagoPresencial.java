package trabajogrupo;

    public abstract class PagoPresencial extends Pago{

    public PagoPresencial(String idpago, String dniInquilino, String idHabitacion, double monto, String fechaPago, String metodoPago) {
        super(idpago, dniInquilino, idHabitacion, monto, fechaPago, metodoPago);
    }
    
    public void registrarPagoPresencial() {
        System.out.println("Registrando el pago presencial en el sistema.");
    }
    
}
