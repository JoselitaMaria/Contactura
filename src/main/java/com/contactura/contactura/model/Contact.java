package com.contactura.contactura.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//
@AllArgsConstructor// construtores padrões
@NoArgsConstructor	// construtores vazios
@Data	// É a anotação do lombok que tras todas as informações sobre gets e sets
@Entity// declaração do JPA para informar que essa classe é uma entidade

public class Contact {
	
	@Id // define que o primeiro long é uma chave primaria no identificador do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)// informa que o id é uma sequence,é um valor que é gerado dinamicamente definido como log classe pq passa nulo no java e o banco de dados tem a responsabilidade de criar o Id
	private long id;
	
	private String name;
	private String email;
	private String Phone;

}