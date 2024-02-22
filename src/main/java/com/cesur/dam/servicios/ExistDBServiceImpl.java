package com.cesur.dam.servicios;

import java.io.StringReader;

import org.springframework.stereotype.Service;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XPathQueryService;

import com.cesur.dam.Entidades.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

@Service
public class ExistDBServiceImpl implements ExistDBService {
    
    private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc";

    private XPathQueryService obtenerServicioXPath() throws Exception {
        String driver = "org.exist.xmldb.DatabaseImpl"; //Driver
        Class cl = Class.forName(driver);//Cargar el driver
        Database database = (Database) cl.newInstance(); //Instancia de la BD
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database); //Registrar la BD
        //Accedemos a la colección
        Collection col =DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/", "admin", "");

        XPathQueryService service =(XPathQueryService) col.getService("XPathQueryService", "1.0");
        service.setProperty("pretty", "true");
        service.setProperty("encoding", "ISO-8859-1");

        return service;
    }

    @Override
    public String listado() {
        try {    
            XPathQueryService service = obtenerServicioXPath();

            //Consulta a lanzar
            ResourceSet result = service.query("doc('empleados')/empleados");
            ResourceIterator i = result.getIterator();
            while (i.hasMoreResources()) { //Procesamos el resultado
                Resource r = i.nextResource();
                String xml = (String) r.getContent();
                System.out.println(xml);
                
                EmpleadosEB empleados = obtenerEmpleados(xml);
                                
                System.out.println(empleados.getEmpleados());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return "OK";
    }
    
    private EmpleadosEB obtenerEmpleados(String xml) throws Exception {
    	JAXBContext jaxbContext = JAXBContext.newInstance(EmpleadosEB.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(xml);
        return (EmpleadosEB) unmarshaller.unmarshal(reader);

    }

    @Override
    public String insertar() {
        
        try {
            String sQuery = "update insert <empleado><nombre>Empleado 6</nombre><puesto>Puesto 6</puesto><salario>60000</salario></empleado>" +
                    " into doc('empleados')/empleados";
            XPathQueryService service = obtenerServicioXPath();
            service.query(sQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        return "OK";
    }
    
}
