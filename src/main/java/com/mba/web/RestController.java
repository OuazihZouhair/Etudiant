package com.mba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mba.dto.EtudiantRequestDTO;
import com.mba.dto.EtudiantResponseDTO;
import com.mba.repositories.EtudiantRepository;
import com.mba.service.EtudiantServiceInterfce;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
public class RestController {

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	EtudiantServiceInterfce etudiantServiceInterface;
	
	
	@GetMapping("/etudiants")
	public List<EtudiantResponseDTO> getAll(){
		return etudiantServiceInterface.ListeEtudiant();
	}
	
	@GetMapping("/etudiants/{id}")
	public EtudiantResponseDTO getOneById(@PathVariable ("id") Integer id) {
		return etudiantServiceInterface.etudiantById(id);
	}
	
	@PostMapping("/etudiants")
	public void save(@RequestBody EtudiantRequestDTO e) {
		etudiantServiceInterface.add(e);
	}
	
	@DeleteMapping("/etudiants/{id}")
	public void supprimer(@PathVariable Integer id) {
		etudiantServiceInterface.supp(id);
	}
	
	@PutMapping("/etudiants/{id}")
	public void put(@PathVariable ("id") Integer id,
			@RequestBody EtudiantRequestDTO c){
		
		etudiantServiceInterface.update(id, c);
	}

}
