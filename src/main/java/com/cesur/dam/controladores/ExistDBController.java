package com.cesur.dam.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesur.dam.servicios.*;
@Controller
@RequestMapping("/existdb")
public class ExistDBController {

    @Autowired
    protected ExistDBService existDBService;

    @PostMapping("/listado")
    @ResponseBody
    public String listado() {
        existDBService.listado();
        return "OK";
    }

    @PutMapping("/insertar")
    @ResponseBody
    public String insertar() {
        return existDBService.insertar();
    }
    
}
