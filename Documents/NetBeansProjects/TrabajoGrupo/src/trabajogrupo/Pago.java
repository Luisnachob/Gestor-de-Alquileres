package trabajogrupo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public abstract class Pago {
    private String idpago;
    private String dniInquilino;
    private String idHabitacion;
    protected double monto;
    protected String fechaPago;
    protected String metodoPago;
    private static final int PLAZO_DIAS = 5;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pago(String idpago, String dniInquilino, String idHabitacion, double monto, String fechaPago, String metodoPago) {
        this.setIdpago(idpago);
        this.setDniInquilino(dniInquilino);
        this.setIdHabitación(idHabitacion);
        this.setMonto(monto);
        this.setFechaPago(fechaPago);
        this.setMetodoPago(metodoPago);
    }
    
    
    
    public abstract double calcularRecargo();
    
    protected int diasDeRetraso() {
        try {
            LocalDate fecha = LocalDate.parse(fechaPago, FORMATO);
            LocalDate limite = fecha.withDayOfMonth(PLAZO_DIAS);
            return (int) Math.max(0, ChronoUnit.DAYS.between(limite, fecha));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Fecha inválida, usa dd/MM/yyyy: " + fechaPago);
        }
    }
    
    public String getIdpago() {
        return idpago;
    }

    public void setIdpago(String idpago) {
        if (!idpago.trim().equals(""))
            this.idpago = idpago.trim().toUpperCase();
    }

    public String getDniInquilino() {
        return dniInquilino;
    }

    public void setDniInquilino(String dniInquilino) {
        if (!dniInquilino.trim().equals(""))
            this.dniInquilino = dniInquilino.trim().toUpperCase();
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitación(String idHabitacion) {
        if (!idHabitacion.trim().equals(""))
            this.idHabitacion = idHabitacion.trim().toUpperCase();
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        if (monto > 0)
            this.monto = monto;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        if (!fechaPago.trim().equals(""))
            this.fechaPago = fechaPago.trim().toUpperCase();
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        if (!metodoPago.trim().equals(""))
            this.metodoPago = metodoPago;
    }
    
    
}
