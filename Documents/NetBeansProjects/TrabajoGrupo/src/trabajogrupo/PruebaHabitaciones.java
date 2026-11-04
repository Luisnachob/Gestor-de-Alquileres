package trabajogrupo;
import Modelo.Habitacion;
import Servicio.ServicioHabitaciones;
import java.util.List;
public class PruebaHabitaciones {

    public static void main(String[] args) {

        ServicioHabitaciones servicio = new ServicioHabitaciones();

        List<Habitacion> lista = servicio.listarHabitaciones();
        System.out.println("Cantidad de habitaciones: " + lista.size());

        for (Habitacion h : lista) {
            System.out.println(h.getId_habitacion());
        }
    }
}
