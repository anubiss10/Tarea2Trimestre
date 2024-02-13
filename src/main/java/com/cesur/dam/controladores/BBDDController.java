package com.cesur.dam.controladores;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cesur.dam.Entidades.Aseguradora;
import com.cesur.dam.Entidades.Cliente;
import com.cesur.dam.servicios.AseguradoraService;
import com.cesur.dam.servicios.ClienteService;
import com.cesur.dam.servicios.ConexionService;
import com.cesur.dam.servicios.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Controller
public class BBDDController {

    //Declaración de las entidades servicio para conectar con estos
    @Autowired
    protected ConexionService conexionService;

    private final FileService fileService;

    //Nos permite trabahar con el servicio de ficheros
    @Autowired
    public BBDDController(FileService fileService) {
        this.fileService = fileService;
    }

    //Método para hacer y confirmar la conexión a la BBDD mediante JDBC
    @ResponseBody
    @GetMapping("/conexion")
    public String devolverTests() {
        return conexionService.devolverTests();
    }

    //Mediante un POST, podemos subir un archivo al proyecto y guardarlo en el directorio estipulado en el método guardarArchivo() de FileService
    @ResponseBody
    @PostMapping("/subirArchivo")
    public String subirArchivo(@RequestParam("archivo") MultipartFile archivo) {
        fileService.guardarArchivo(archivo);
        return "Archivo subido correctamente";
    }

    //Al igual que el método anterior, nos permite borrar un archivo del directorio en el que se encuentran dentro del proyecto
    @ResponseBody
    @PostMapping("/borrarArchivo")
    public void borrarArchivos(@RequestParam("archivo") String archivo) {
        fileService.borrarArchivo(archivo);
    }

    //Controlador para trabajar con la tabla clientes de la base de datos, permite obtener un listado de todos los clientes
    @RestController
    @RequestMapping("/clientes")
    public class ClienteController {
        private final ClienteService clienteService;

        @Autowired
        public ClienteController(ClienteService clienteService) {
            this.clienteService = clienteService;
        }

        @GetMapping
        public List<Cliente> obtenerTodosClientes() {
            return clienteService.obtenerTodos();
        }
    }

    //Permite generar un xml de la tabla Clientes de la base de datos y mostrarlo en postman
    @RestController
    @RequestMapping("/xml")
    public class XmlController {
        private final ClienteService clienteService;

        @Autowired
        public XmlController(ClienteService clienteService) {
            this.clienteService = clienteService;
        }

        @GetMapping("/clientes")
        public ResponseEntity<String> obtenerClientesEnXml() throws JsonProcessingException {
            List<Cliente> clientes = clienteService.obtenerTodos();
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(clientes);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);

            return new ResponseEntity<>(xml, headers, HttpStatus.OK);
        }
    }

    //Controllador para obtener un listado de todas las aseguradoras almacenadas en la BBDD
    @RestController
    @RequestMapping("/api/aseguradoras")
    public class AseguradoraController {

        private final AseguradoraService aseguradoraService;

        @Autowired
        public AseguradoraController(AseguradoraService aseguradoraService) {
            this.aseguradoraService = aseguradoraService;
        }

        @GetMapping
        public List<Aseguradora> obtenerTodasLasAseguradoras() {
            return aseguradoraService.obtenerTodos();
        }

    }

    //Permite listar los archivos del directorio en el que se guardan
    @RestController
    @RequestMapping("/api/archivos")
    public class FileController {

        @Autowired
        private FileService fileService;

        @GetMapping("/listar")
        public List<String> listarArchivos() {
            return fileService.listarArchivos();
        }
    }
}