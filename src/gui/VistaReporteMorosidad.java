package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VistaReporteMorosidad extends JFrame {
    private JTable tablaMorosidad;
    private DefaultTableModel modeloTabla;
    private JButton btnCargar;
    
    public VistaReporteMorosidad() {
        setTitle("Módulo de Reportes de Morosidad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout(10, 10));
        
        String[] columnas = {"ID Reporte", "Inquilino", "Meses Deuda", "Recomendación"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaMorosidad = new JTable(modeloTabla);
        
        // Corregido: Jpanel -> JPanel y agregado el JScrollPane para la tabla
        JScrollPane scrollPane = new JScrollPane(tablaMorosidad);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        btnCargar = new JButton("Cargar Reportes");
        panelInferior.add(btnCargar);
        
        // Corregido: panelInferiorm con 'm' y la coma por BorderLayout.SOUTH
        add(panelInferior, BorderLayout.SOUTH);
        
        btnCargar.addActionListener(e -> cargarDatosEnTabla());
    }
    
    private void cargarDatosEnTabla() {
        modeloTabla.setRowCount(0);
        
        // Ruta del archivo (puedes usar la ruta completa o solo "morosidad.txt" si está en la raíz del proyecto)
        String rutaArchivo = "C:/Users/luisi/Documents/morosidad.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                
                String[] datos = linea.split(",");
                if (datos.length >= 4) {
                    String idReporte = datos[0].trim();
                    String nombreInquilino = datos[1].trim(); // Corregido el paréntesis extra
                    int mesesDeuda = Integer.parseInt(datos[2].trim());
                    String recomendacion = datos[3].trim();
                    
                    Object[] fila = {
                        idReporte,
                        nombreInquilino,
                        mesesDeuda,
                        recomendacion
                    };
                    modeloTabla.addRow(fila);
                }
            }
            
            // El mensaje de éxito va fuera del while, al terminar de leer todo el archivo
            JOptionPane.showMessageDialog(this, "Datos cargados exitosamente desde el archivo .txt");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(),
                    "Error de Archivo", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato numérico de los meses de deuda.",
                    "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaReporteMorosidad().setVisible(true);
        });
    }
}
