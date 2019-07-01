package com.iff.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.iff.model.Produto;

public interface Produtos extends JpaRepository <Produto, Long>{

}