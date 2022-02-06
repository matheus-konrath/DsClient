package com.bootcamp.trabalho.capitulo1.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.trabalho.capitulo1.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
