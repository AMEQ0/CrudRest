package com.gestion.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.productos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	
}
