package com.cesur.dam.bbdd.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cesur.dam.Entidades.Persona;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@Service
public class JasperService {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    // Método para obtener la conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    // Método para obtener las personas desde la base de datos
    public List<Persona> obtenerPersonasDesdeBD() {
        List<Persona> lista = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT nombre, apellidos, telefono, email FROM clientes");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellidos");
                String telefono = resultSet.getString("telefono");
                String email = resultSet.getString("email");
                lista.add(new Persona(nombre, apellido, telefono, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }

        return lista;
    }

    // Método para generar el informe
 // Método para generar el informe
    public boolean generarInforme() {
        String nombreFichero = "informe.pdf";
        String rutaCompleta = System.getProperty("user.dir") + "/" + nombreFichero; // Obtener la ruta completa del archivo en la raíz del proyecto

        List<Persona> lista = obtenerPersonasDesdeBD();

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", "Informe de Clientes");

        try {
            JasperPrint informe = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(getClass().getResourceAsStream("/Informe.jrxml")), // Corrección: Agregar '/' al principio para indicar la raíz de los recursos
                    parametros,
                    new JRBeanCollectionDataSource(lista)
            );

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(informe));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new FileOutputStream(rutaCompleta))); // Usar la ruta completa

            SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
            exportConfig.setMetadataAuthor("Julian");
            exportConfig.setEncrypted(true);
            exportConfig.setAllowedPermissionsHint("PRINTING");

            exporter.exportReport();

            return true;
        } catch (IOException | JRException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
            return false;
        }
    }
}