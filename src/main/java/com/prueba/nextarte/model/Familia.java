package com.prueba.nextarte.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "family_members", schema = "public")
@Data
public class Familia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "relation")
	private String parentesco;
	
    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.EAGER)
	private Usuario usuarioId;

	@Column(name = "first_name")
	private String PrimerNombre;
	
	@Column(name = "second_name")
	private String SegundoNombre;
	
	@Column(name = "first_last_name")
	private String PrimerApellido;
	
	@Column(name = "second_last_name")
	private String SegundoApellido;
	
	@Column(name = "document_type")
	private String tipoIdentificacion;
		
	@Column(name = "document_number")
	private Integer numeroIdendificacion;
	
	@Column(name = "age")
	private Integer edad;

}
