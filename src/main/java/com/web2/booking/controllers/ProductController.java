package com.web2.booking.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web2.booking.DTO.Product.CreateProductInputDTO;
import com.web2.booking.DTO.Product.CreateProductOutputDTO;
import com.web2.booking.DTO.Product.DeleteProductOutputDTO;
import com.web2.booking.DTO.Product.ProductOutputDTO;
import com.web2.booking.DTO.Product.UpdateProductInputDTO;
import com.web2.booking.models.ProductModel;
import com.web2.booking.services.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {
  @Autowired
  ProductService productService;

  @GetMapping("/by-date")
  public ResponseEntity<List<ProductModel>> getAllProductsByDate(
      @RequestParam(required = false) String category,
      @RequestParam(required = false) String saindoDe,
      @RequestParam(required = false) String indoPara,
      @RequestParam(required = false) String date,
      @RequestParam(required = false) Integer pessoas) {

    LocalDate dataConvertida = date != null ? LocalDate.parse(date) : null;

    List<ProductModel> response = productService.searchProductsByDate(dataConvertida, category, saindoDe, indoPara,
        pessoas);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  ResponseEntity<ProductOutputDTO> getProductById(@PathVariable UUID id) {
    ProductOutputDTO response = productService.getProduct(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  ResponseEntity<List<ProductOutputDTO>> getAllProducts() {
    List<ProductOutputDTO> response = productService.findAll();
    return ResponseEntity.ok(response);
  }

  @PostMapping("/{idUser}")
  ResponseEntity<CreateProductOutputDTO> createProduct(@RequestBody CreateProductInputDTO product, @PathVariable String idUser) {
    CreateProductOutputDTO response = productService.saveProduct(product, idUser);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  ResponseEntity<ProductOutputDTO> updateProduct(@PathVariable UUID id,
      @RequestBody UpdateProductInputDTO product) {
    ProductOutputDTO response = productService.updateProduct(id, product);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<DeleteProductOutputDTO> deleteProductById(@PathVariable UUID id) {

    DeleteProductOutputDTO response = productService.deleteProduct(id);
    return ResponseEntity.ok(response);
  }

}
