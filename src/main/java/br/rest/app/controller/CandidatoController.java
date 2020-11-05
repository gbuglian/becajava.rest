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

import br.rest.app.model.Candidato;

@RestController
@RequestMapping("/candidato/")
public class CandidatoController {
	
	@PostMapping
	public ResponseEntity criar(@RequestBody Candidato candidato) {
		
		if(candidato.getId() <= 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID do Candidato não informado");	
		else if(candidato.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome do Candidato não informado!");
		else if (candidato.getNumero() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Número de Candidato não informado!");
		else if (candidato.getTipo() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de Candidatura não informado!");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Candidato Criado com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity listar() {
		
		List<Candidato> list = new ArrayList<Candidato>();
		
		Candidato c = new Candidato();
		c.setId(1l);
		c.setNome("Gabriel do Povo");
		c.setNumero("22678");
		c.setTipo("Vereador");
		list.add(c);
		
		c = new Candidato();
		c.setId(2l);
		c.setNome("Gabriel da Roça");
		c.setNumero("87632");
		c.setTipo("Vereador");
		list.add(c);
		
		c = new Candidato();
		c.setId(3l);
		c.setNome("Gabriel da Quebrada");
		c.setNumero("64735");
		c.setTipo("Vereador");
		list.add(c);
		
		c = new Candidato();
		c.setId(4l);
		c.setNome("Gabriel da Padaria");
		c.setNumero("12345");
		c.setTipo("Vereador");
		list.add(c);
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long Id) {
		
		Candidato c = new Candidato();
		c.setId(1l);
		c.setNome("Gabriel da Mercearia");
		c.setNumero("54321");
		c.setTipo("Vereador");
		
		return ResponseEntity.status(HttpStatus.OK).body(c);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Candidato candidato, @PathVariable Long Id) {
		return ResponseEntity.status(HttpStatus.OK).body(candidato);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long Id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
