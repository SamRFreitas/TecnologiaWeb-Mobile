package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.models.Mes;

public interface Meses  extends JpaRepository <Mes,Long> {

}
