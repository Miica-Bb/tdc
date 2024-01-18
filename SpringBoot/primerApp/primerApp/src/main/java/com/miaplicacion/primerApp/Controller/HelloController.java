package com.miaplicacion.primerApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping ("/hello")
    public String sayHello() {
        return "Hola Mundo! Esto es una prueba";
    }
    
    @GetMapping ("/message")
    public String sayMessage() {
        return "SpringBoot es una herramienta para desarrollar APIs en Java";
    }
    
    @GetMapping ("/info/{nombre}/{edad}/{profesion}")
    public String sayInfo(@PathVariable String nombre, @PathVariable int edad, @PathVariable String profesion) {
        return "Tu nombre es: " + nombre + 
                ". Tu edad es: " + edad + 
                ". Tu profesión es: " + profesion;
    }
    
    @GetMapping ("/bye/{nombre}")
    public String sayGoodbye(@PathVariable String nombre) {
        return "Adiós " + nombre;
    }
    
    @GetMapping ("/suma/{numUno}/{numDos}")
    public String sumarNumeros(@PathVariable int numUno, @PathVariable int numDos) {
        int resultado = numUno + numDos;
        return "El resultado de la suma es: " + resultado;
    }
    
    @GetMapping("/estadoPeso")
    public String determinarPeso(@RequestParam double imc) {
        if(imc >= 1 && imc <= 18.5) {
            return "Peso insuficiente";
        } else if (imc >= 18.6 && imc <= 24.9) {
            return "peso normal";
        } else if (imc >= 25.0 && imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30) {
            return "Obesidad";
        } else {
            return "Ingreso incorrecto";
        }
    }
}
