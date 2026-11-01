package modelo;

public class ReporteMorosidad implements Reportable {
    private String idReporte;
    private int mesesDeuda;
    private String recomendacion;
    public static final int MESES_ALERTA = 2; // Constante estática
    
    private Inquilino inquilinoEvaluado; // Relación "evalúa" con Inquilino[cite: 3]

    public ReporteMorosidad() {
    }

    public ReporteMorosidad(String idReporte, int mesesDeuda, Inquilino inquilinoEvaluado) {
        this.idReporte = idReporte;
        this.mesesDeuda = mesesDeuda;
        this.inquilinoEvaluado = inquilinoEvaluado;
        calcularRecomendacion();
    }

    private void calcularRecomendacion() {
        if (this.mesesDeuda >= MESES_ALERTA) {
            this.recomendacion = "ALERTA DE DESALOJO - Deuda critica";
        } else if (this.mesesDeuda == 1) {
            this.recomendacion = "ADVERTENCIA - Pago atrasado";
        } else {
            this.recomendacion = "REGULAR - Al dia";
        }
    }

    @Override
    public String generarReporte() {
        String infoInquilino = (inquilinoEvaluado != null) ? 
                "DNI: " + inquilinoEvaluado.getDni() + " | Nombre: " + inquilinoEvaluado.getNombres() : 
                "Sin inquilino asociado";
        
        return "ID Reporte: " + idReporte + "\n" +
               "Inquilino: " + infoInquilino + "\n" +
               "Meses de Deuda: " + mesesDeuda + "\n" +
               "Recomendacion: " + recomendacion;
    }

    @Override
    public void imprimirReporte() {
        mostrarCabeceraEstandar();
        System.out.println(generarReporte());
    }

    // Getters y Setters
    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public int getMesesDeuda() {
        return mesesDeuda;
    }

    public void setMesesDeuda(int mesesDeuda) {
        this.mesesDeuda = mesesDeuda;
        calcularRecomendacion();
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public Inquilino getInquilinoEvaluado() {
        return inquilinoEvaluado;
    }

    public void setInquilinoEvaluado(Inquilino inquilinoEvaluado) {
        this.inquilinoEvaluado = inquilinoEvaluado;
    }
}