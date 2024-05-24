package com.gestion.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.productos.model.Producto;
import com.gestion.productos.service.ProductoService;

@RestController
public class ProductoController {

	
	@Autowired
	private ProductoService service;
	
	@GetMapping("/productos")
	public List<Producto> listProduct(){
		return service.listAll();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> findProduct(@PathVariable int id) {
		try {
			Producto producto = service.findByID(id);
			return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/productos")
	public void SaveProduct(@RequestBody Producto producto) {
		service.saveProducto(producto);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Producto producto, @PathVariable int id){
		try {
			Producto productoExistente = service.findByID(id);
			
			productoExistente.setNombre(producto.getNombre());
			productoExistente.setPrecio(producto.getPrecio());
			service.saveProducto(productoExistente);
			return new ResponseEntity<Producto>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/productos/{id}")
	public void deleteProduct(@PathVariable int id) {
		service.deleteId(id);
	}
	
}
