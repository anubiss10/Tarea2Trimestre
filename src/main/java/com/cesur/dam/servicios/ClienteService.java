package com.cesur.dam.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.cesur.dam.Entidades.Cliente;
import com.cesur.dam.repositorios.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, JdbcTemplate jdbcTemplate) {
        this.clienteRepository = clienteRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = clienteRepository.findAll();

        // Convertir la lista de clientes a formato XML
        String xmlClientes = convertirListaClientesAXML(clientes);

        // Guardar la lista de clientes como un archivo XML formateado
        guardarClientesComoXml(xmlClientes);

        return clientes;
    }

    private String convertirListaClientesAXML(List<Cliente> clientes) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<ArrayList>");

        //Crear el xml a partir de la lista de clientes
        for (Cliente cliente : clientes) {
            xmlBuilder.append("\n  <item>");
            xmlBuilder.append("\n    <idCliente>").append(cliente.getIdCliente()).append("</idCliente>");
            xmlBuilder.append("\n    <nombre>").append(cliente.getNombre()).append("</nombre>");
            xmlBuilder.append("\n    <apellidos>").append(cliente.getApellidos()).append("</apellidos>");
            xmlBuilder.append("\n    <telefono>").append(cliente.getTelefono()).append("</telefono>");
            xmlBuilder.append("\n    <email>").append(cliente.getEmail()).append("</email>");
            xmlBuilder.append("\n  </item>");
        }

        xmlBuilder.append("\n</ArrayList>");

        return xmlBuilder.toString();
    }

    private void guardarClientesComoXml(String xmlClientes) {
        String directorioDeTrabajo = "Files";
        String nombreArchivo = "clientes.xml";

        try {
            // Construir la ruta completa para guardar el archivo XML en la carpeta "Files"
            File archivoXml = new File(directorioDeTrabajo, nombreArchivo);

            // Guardar el archivo XML formateado
            try (PrintWriter writer = new PrintWriter(new FileWriter(archivoXml, false), true)) {
                writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                writer.println(xmlClientes);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al intentar guardar la lista de clientes como XML", e);
        }
    }

    //Obtener listado de clientes mediante el uso de JDBC
    @Transactional
    public List<Cliente> obtenerClientes() {
        String sql = "SELECT * FROM clientes";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getLong("idCliente"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellidos(rs.getString("apellidos"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setEmail(rs.getString("email"));
            return cliente;
        });
    }

    //Permite añadir un cliente mediante el uso de JDBC
    @Transactional
    public void añadirCliente(Cliente nuevoCliente) {
        String sql = "INSERT INTO clientes (nombre, apellidos, telefono, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, nuevoCliente.getNombre(), nuevoCliente.getApellidos(), nuevoCliente.getTelefono(), nuevoCliente.getEmail());
    }
}
