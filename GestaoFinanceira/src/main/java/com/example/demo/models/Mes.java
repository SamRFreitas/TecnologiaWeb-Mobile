package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Mes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
        @NotBlank
	private String nome;
        @NotNull
        @Min(1)
	private float saldo;
	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public float getSaldo() 
	{
		return saldo;
	}
	public void setSaldo(float saldo) 
	{
		this.saldo = saldo;
	}
	
	
}
