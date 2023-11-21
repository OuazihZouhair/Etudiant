package com.mba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class EtudiantResponseDTO {
	private Integer idEtudiant;
	private Double apogee;
	private String nom;
	private String email;
}
