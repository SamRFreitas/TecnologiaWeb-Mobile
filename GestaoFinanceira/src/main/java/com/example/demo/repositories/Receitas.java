package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.Receita;

public interface Receitas  extends JpaRepository <Receita, Long>{

}
