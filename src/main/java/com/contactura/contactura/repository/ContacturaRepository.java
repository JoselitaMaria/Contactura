package com.contactura.contactura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactura.contactura.model.Contact;

//aqui tranformei em uma irteface para que possamos usar os metodos padrões do JPA

@Repository // definição do repositorio ps.nesse caso não é obrigatorio mais é uma boa pratica
public interface ContacturaRepository extends JpaRepository<Contact, Long> {
	//Long esta sendo passado para que a responsabilidade de criar o long (id)para do banco de dados 
}
//Jpa repository é uma interface onde tem métodos padrões , evitando assim que todos sejam escritos a mão 