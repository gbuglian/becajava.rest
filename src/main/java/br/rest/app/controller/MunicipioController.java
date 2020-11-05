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

import br.rest.app.model.Municipio;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Municipio municipio) {
		if(municipio.getId() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id não informado");
		else if(municipio.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado");
		else if(municipio.getPopulacao() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nº do titulo não informado");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Eleitor criado com sucesso!");
	}
	
	@GetMapping
    public ResponseEntity listar() {

    	List<Municipio> list = new ArrayList<Municipio>();

    	Municipio m = new Municipio();
    	m.setId(1l);
    	m.setNome("João Ramalho");
    	m.setPopulacao(14000l);
    	list.add(m);

    	m = new Municipio();
     	m.setId(2l);
    	m.setNome("Pirituba");
    	m.setPopulacao(1400l);
    	list.add(m);

    	m = new Municipio();
    	m.setId(3l);
    	m.setNome("Aricanduva");
    	m.setPopulacao(19000l);
    	list.add(m);  	

    	return ResponseEntity.status(HttpStatus.OK).body(list);
    }
	
	@GetMapping(path = "/{id}")
    public ResponseEntity byId(@PathVariable Long id) {    	  	

		Municipio m = new Municipio();
     	m.setId(4l);
    	m.setNome("Manaus");
    	m.setPopulacao(15200l);

        return ResponseEntity.status(HttpStatus.OK).body(m);
    }
	
	@PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Municipio municipio, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(municipio);
    }
	
	 @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
}
