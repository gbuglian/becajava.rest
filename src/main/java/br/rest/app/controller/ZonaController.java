package br.rest.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rest.app.model.Zona;

@RestController
@RequestMapping("/zona")
public class ZonaController {

	@PostMapping
    public ResponseEntity criar(@RequestBody Zona zona) {    	    	
    	if (zona.getId() == null)    	
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id não informado.");
    	else if (zona.getNumero() == "")
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Numero da Zona não informado.");
    	else
    		return ResponseEntity.status(HttpStatus.CREATED).body("Zona criado com sucesso!");
    }
	
	@GetMapping
    public ResponseEntity listar() {

    	List<Zona> list = new ArrayList<Zona>();

    	Zona z = new Zona();
    	z.setId(1l);
    	z.setNumero("1235");
    	list.add(z);

    	z = new Zona();
    	z.setId(2l);
    	z.setNumero("13579");
    	list.add(z);

    	z = new Zona();
    	z.setId(3l);
    	z.setNumero("24680");
    	list.add(z);   	

    	return ResponseEntity.status(HttpStatus.OK).body(list);
    }
	
	 @GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {    	  	

	    	Zona z = new Zona();
	    	z.setId(4l);
	    	z.setNumero("9753");

	        return ResponseEntity.status(HttpStatus.OK).body(z);
	    }
	 
	 @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Zona zona, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(zona);
	    }
	 
	 @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
}
