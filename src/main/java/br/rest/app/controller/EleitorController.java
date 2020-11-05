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

import br.rest.app.model.Eleitor;

@RestController
@RequestMapping("/eleitor")
public class EleitorController {
	
	@PostMapping
	public ResponseEntity criar(@RequestBody Eleitor eleitor) {
		if(eleitor.getId() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id não informado");
		if(eleitor.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado");
		else if(eleitor.getTituloNum() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nº do titulo não informado");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Eleitor criado com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity listar() {
		
		List<Eleitor> list = new ArrayList<Eleitor>();
		
		Eleitor e = new Eleitor();
		e.setId(1l);
    	e.setNome("Jamal");
    	e.setTituloNum("2468");
    	list.add(e);

    	e = new Eleitor();
		e.setId(2l);
    	e.setNome("Marta");
    	e.setTituloNum("1235");
    	list.add(e);
    	
    	e = new Eleitor();
		e.setId(3l);
    	e.setNome("Jhow");
    	e.setTituloNum("1357");
    	list.add(e);	

    	return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(path = "/{id}")
    public ResponseEntity byId(@PathVariable Long Id) {    	  	

    	Eleitor e = new Eleitor();
    	e.setId(3l);
    	e.setNome("Paulo");
    	e.setTituloNum("97531");

        return ResponseEntity.status(HttpStatus.OK).body(e);
    }
	
	 @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Eleitor eleitor, @PathVariable Long Id) {
	        return ResponseEntity.status(HttpStatus.OK).body(eleitor);
	    }
	 
	 @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long Id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }

}
