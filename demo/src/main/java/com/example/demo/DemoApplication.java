package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public String home () {
		System.out.println("hola");
		return "hola mundo!! :D";
	}

	//Ejemplo de métodos ???
	@RequestMapping("/altas")
	public String altas(){
		return "altas";
	}

	@RequestMapping("/bajas")
	public String bajas(){
		return "bajas";
	}

	@RequestMapping("/cambios")
	public String cambios(){
		return "cambios";
	}

	@RequestMapping("/consultas")
	public String consultas(){
		return "consultas";
	}

	//Ejemplo de métodos REST SI adecuados al estilo RESTFUL
	@RequestMapping(value = "/sistema", method = RequestMethod.POST)
	public String altasREST(){
		return "altas";
	}

	@RequestMapping(value = "/sistema", method = RequestMethod.DELETE)
	public String bajasREST(){
		return "bajas";
	}

	@RequestMapping(value = "/sistema", method = RequestMethod.PUT)
	public String cambiosREST(){
		return "cambios";
	}

	@RequestMapping(value = "/sistema", method = RequestMethod.GET)
	public String consultasREST(){
		return "consultas";
	}
}

