package com.gestion.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.productos.model.Producto;
import com.gestion.productos.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repo;
	
	public List<Producto> listAll(){
		return repo.findAll();
	}
	
	public void saveProducto(Producto producto) {
		 repo.save(producto);
	}
	
	public Producto findByID(Integer id) {
		return repo.findById(id).get();
	}
	
	public void deleteId(Integer id) {
		repo.deleteById(id);
	}
	
}
