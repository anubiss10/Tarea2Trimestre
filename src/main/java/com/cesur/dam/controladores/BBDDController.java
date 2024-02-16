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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cesur.dam.Entidades.Aseguradora;
import com.cesur.dam.Entidades.Cliente;
import com.cesur.dam.Entidades.Empleado;
import com.cesur.dam.servicios.AseguradoraService;
import com.cesur.dam.servicios.ClienteService;
import com.cesur.dam.servicios.ConexionService;
import com.cesur.dam.servicios.FileService;
import com.cesur.dam.servicios.MongoDBService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.cesur.dam.bbdd.entities.entitiesobjectdb.AseguradorasOB;
import com.cesur.dam.bbdd.entities.entitiesobjectdb.ClientesOB;
import com.cesur.dam.bbdd.entities.entitiesobjectdb.Poliza;
import com.cesur.dam.bbdd.entities.entitiesobjectdb.SiniestroOB;
import com.cesur.dam.bbdd.services.ObjectdbService;
import com.cesur.dam.bbdd.services.*;
@Controller
public class BBDDController {
	@Autowired
	protected ObjectdbService objectDBService;
	@Autowired
	protected MongoDBService mongoService;
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
	//OBJECTDB
	
	@RestController
	@RequestMapping("/api/aseguradoras")
	public class AseguradorasOBController {

	    private final ObjectdbService objectdbService;

	    @Autowired
	    public AseguradorasOBController(ObjectdbService objectdbService) {
	        this.objectdbService = objectdbService;
	    }

	    @PostMapping("/crear")
	    public AseguradorasOB crearAseguradora(@RequestBody AseguradorasOB aseguradora) {
	        return objectdbService.crearAseguradora(aseguradora);
	    }

	    @GetMapping("/polizas/{clienteId}")
	    public List<Poliza> obtenerPolizasPorCliente(@PathVariable Long clienteId) {
	        return objectdbService.obtenerPolizasPorCliente(clienteId);
	    }
	    
	}
	
	   @RestController
	    @RequestMapping("/clientesOB")
	    public class ClientesOBController {

	        private final ObjectdbService objectdbService;

	        @Autowired
	        public ClientesOBController(ObjectdbService objectdbService) {
	            this.objectdbService = objectdbService;
	        }

	        @PostMapping("/crear")
	        public String crearCliente(@RequestBody ClientesOB cliente) {
	            objectdbService.crearCliente(cliente);
	            return "Cliente creado exitosamente";
	        }
	    }
	   @RestController
	   @RequestMapping("/api/ejemplos")
	   public class EjemploController {

	       private final ObjectdbService ejemploService;

	       @Autowired
	       public EjemploController(ObjectdbService ejemploService) {
	           this.ejemploService = ejemploService;
	       }

	       @PostMapping("/crearDatosDeEjemplo")
	       public String crearDatosDeEjemplo() {
	           ejemploService.crearDatosDeEjemplo();
	           return "Datos de ejemplo creados exitosamente.";
	       }
	   
	   
	    }
	   @RestController
	    @RequestMapping("/listadoempleados")
	    public class MongoController {

	        private final MongoDBService mongoService;

	        public MongoController(MongoDBService mongoService) {
	            this.mongoService = mongoService;
	        }

	        @GetMapping("/listaE")
	        @ResponseBody
	        public List<Empleado> listarEmpleados() {
	            return mongoService.listar();
	        }

	        @GetMapping("/anadirEmpleados")
	        @ResponseBody
	        public String anadirEmpleados() {
	            return mongoService.anadirEmpleados();
	        }
	    }
@RestController
@RequestMapping("/api/siniestros")
public class SiniestroController {

    private final ObjectdbService siniestroService;

    @Autowired
    public SiniestroController(ObjectdbService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @GetMapping("/cliente/{clienteId}")
    public List<SiniestroOB> obtenerSiniestrosPorCliente(@PathVariable Long clienteId) {
        return siniestroService.obtenerSiniestrosPorCliente(clienteId);
    }
}

}
