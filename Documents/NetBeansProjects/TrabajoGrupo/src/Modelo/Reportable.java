package modelo;

public interface Reportable {
    String generarReporte();
    void imprimirReporte();
    
    default String titulo() {
        return "Reporte de Morosidad y Alquileres";
    }
    
    
    default void mostrarCabeceraEstandar() {
        System.out.println("  " + titulo());  
    }
}