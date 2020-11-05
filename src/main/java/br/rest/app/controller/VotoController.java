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

import br.rest.app.model.Voto;




@RestController
@RequestMapping("/votos")
public class VotoController {
	
	@PostMapping
	public ResponseEntity criar(@RequestBody Voto voto) {
		if(voto.getId() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id de voto não informado");
		else if (voto.getCandidatoId() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Candidato não informado");
		else if (voto.getEleitorId() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Eleitor não informado");
		else if (voto.getZonaId() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Zona não informada");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Voto criado com sucesso");
	}
	
	@GetMapping
    public ResponseEntity listar() {

    	List<Voto> list = new ArrayList<Voto>();

    	Voto v = new Voto();
    	v.setId(1l);
    	v.setCandidatoId(1l);
    	v.setEleitorId(1l);
    	v.setZonaId(1l);
    	list.add(v);

    	v = new Voto();
    	v.setId(2l);
    	v.setCandidatoId(4l);
    	v.setEleitorId(2l);
    	v.setZonaId(1l);
    	list.add(v);

    	v = new Voto();
    	v.setId(3l);
    	v.setCandidatoId(3l);
    	v.setEleitorId(3l);
    	v.setZonaId(2l);
    	list.add(v);  	

    	return ResponseEntity.status(HttpStatus.OK).body(list);
    }
	
	 @GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {    	  	

		 	Voto v = new Voto();
	    	v.setId(3l);
	    	v.setCandidatoId(3l);
	    	v.setEleitorId(3l);
	    	v.setZonaId(2l);
	    	
	        return ResponseEntity.status(HttpStatus.OK).body(v);

	 }
	 
	 @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Voto voto, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(voto);
	    }
	 
	 @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }

}
