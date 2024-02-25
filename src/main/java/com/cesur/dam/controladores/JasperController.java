package com.cesur.dam.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesur.dam.bbdd.services.JasperService;

@Controller
@RequestMapping("jasper")
public class JasperController {

    private final JasperService jasperService;

    @Autowired
    public JasperController(JasperService jasperService) {
        this.jasperService = jasperService;
    }

    @GetMapping("generar")
    @ResponseBody
    public String generarInforme() {
        if (jasperService.generarInforme()) {
            return "Informe generado correctamente";
        } else {
            return "Error al generar el informe";
        }
    }
}
