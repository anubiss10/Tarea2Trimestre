package com.cesur.dam.controladores;

import com.cesur.dam.Entidades.Cliente;
import com.cesur.dam.servicios.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Controlador para realizar acciones en la BBDD mediante JDBC. Hacemos uso de application.properties
mediante JdbcTemplate, clase que configura automáticamente la configuración del DataSource de Spring a partir de este.
*/
@Controller
@RequestMapping("/jdbc")
public class JdbcController {

    private final ClienteService clienteService;

    @Autowired
    public JdbcController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/obtenerClientes")
    @ResponseBody
    public List<Cliente> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    @PostMapping("/añadirCliente")
    @ResponseBody
    public ResponseEntity<String> añadirCliente(@RequestBody Cliente nuevoCliente) {
        try {
            clienteService.añadirCliente(nuevoCliente);
            return new ResponseEntity<>("Cliente añadido correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al añadir cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
