package com.mba;

import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mba.entities.Etudiant;
import com.mba.repositories.EtudiantRepository;

@SpringBootApplication
public class EtudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantApplication.class, args);
	}

@Bean
	CommandLineRunner start(EtudiantRepository etudiantRepository) {
		return args->{
			for(int i=0;i<10;i++) {
				Etudiant e = Etudiant.builder()
						.apogee(Math.random()*9999)
						.email(null)
						.nom(null)
						.build();
				
				etudiantRepository.save(e);
			}
			
			List<Etudiant> liste=etudiantRepository.findAll();
			System.out.println("------------------------------------");
			System.out.println("Id ------- apogee--------------------email---------nom");
			for(Etudiant et : liste) {
				System.out.println(et.getIdEtudiant()+" -------- "+et.getApogee()+" -------- "+et.getEmail()+" --------- " + et.getNom());
			}
	
			System.out.println("------------------------------------");
		};
	
	}
}
