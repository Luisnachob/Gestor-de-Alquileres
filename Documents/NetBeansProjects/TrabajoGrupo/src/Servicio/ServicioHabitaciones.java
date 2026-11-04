package Servicio;
import Modelo.Habitacion;
import java.io.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ServicioHabitaciones {
    private final String archivo = "habitaciones.txt";
    public void agregarHabitacion(Habitacion h){
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String line;
            boolean existe = false;
            while((line=br.readLine())!=null){
                String[]datos = line.split(",");
                if(datos[0].equals(h.getId_habitacion())){
                    existe = true;
                    break;
                }
                else{
                    existe = false;
                }
            }
            br.close();
            if(!existe){
                FileWriter fw = new FileWriter(archivo,true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(h.getId_habitacion()+ "," +h.getPiso()+ "," +h.getNumero_cuarto()+ "," +h.getPrecio_mensual()+ "," +h.getEstado());
                bw.newLine();
                bw.close();
                fw.close();
            }
            else{
                System.out.println("Habitacion existente");
            }
        }catch(IOException e){
            System.out.println("Error al guardar la habitacion: " + e.getMessage());
        }
    }
    public void eliminarHabitacion(String id){
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            boolean encontrada = false;
            List<String> habitaciones = new ArrayList<>();
            while((linea = br.readLine())!=null){
                String[]datos = linea.split(",");
                if(!datos[0].equals(id)){
                    habitaciones.add(linea);
                }
                else{
                    encontrada = true;
                }
            }
            br.close();
            if(encontrada){
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                for(String habitacion : habitaciones){
                    bw.write(habitacion);
                    bw.newLine();
                }
                bw.close();
                fw.close();
            }
            else{
                System.out.println("La habitacion no existe");
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public List<Habitacion> listarHabitaciones(){
        List<Habitacion> habitaciones = new ArrayList<>();
        try{
           FileReader fr = new FileReader(archivo); 
           BufferedReader br = new BufferedReader(fr);
           String linea;
           while((linea=br.readLine())!=null){
               String[]datos = linea.split(",");
               int piso = Integer.parseInt(datos[1]);
               double precio = Double.parseDouble(datos[3]);
               Habitacion h = new Habitacion(datos[0],piso,datos[2],precio,datos[4]);
               habitaciones.add(h);
           }
           br.close();
        }catch(NumberFormatException e){
            System.out.println("Error: Hay datos numeros errados en el archivo");
        }catch(IOException e){
            System.out.println("Error al listar habitaciones: " + e.getMessage());
        }
        return habitaciones;
    }
}
