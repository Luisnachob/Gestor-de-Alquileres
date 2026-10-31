package trabajogrupo;

public abstract class PagoVirtual extends Pago{
    protected String constancia;

    public PagoVirtual(String idpago, String dniInquilino, String idHabitacion, double monto, String fechaPago, String metodoPago, String constancia) {
        super(idpago, dniInquilino, idHabitacion, monto, fechaPago, metodoPago);
        this.setConstancia(constancia);
    }
    
    public void validarContancia() {
        if (this.constancia != null && !this.constancia.trim().equals(""))
            System.out.println("Constancia de pago validada");
        else
            System.out.println("ERRO, CONSTANCIA DE PAGO INVALIDA");
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        if (!constancia.trim().equals(""))
            this.constancia = constancia.toUpperCase();
    }
    
        
}
