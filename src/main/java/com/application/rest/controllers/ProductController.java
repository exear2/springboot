package com.application.rest.controllers;
import com.application.rest.controllers.dto.ProductDTO;
import com.application.rest.entities.Product;
import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {


        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<ProductDTO> productList = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productList);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException { //usar siempre un dto

        if(productDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        Product product= Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(productDTO.getMaker())
                .build();

        productService.save(product);

        return ResponseEntity.created(new URI("/api/product/save")).build();

    }


    @PostMapping("/saveAll")
    public  ResponseEntity<List<Product>> saveAll(@RequestBody List<ProductDTO> productDTOs) throws URISyntaxException
    { //usar siempre un dto

        // Verificar que todos los productos tengan un nombre no vacío
        for (ProductDTO dto : productDTOs) {
            if (dto.getName().isBlank()) {
                return ResponseEntity.badRequest().build();
            }
        }

        // Convertir DTOs a entidades
        List<Product> products = new ArrayList<>();
        for (ProductDTO dto : productDTOs) {
            Product product = Product.builder()
                    .name(dto.getName())
                    .price(dto.getPrice())
                    .maker(dto.getMaker()) // si Maker es una entidad, asegúrate de que esté correctamente asignada
                    .build();
            products.add(product);
        }

        // Guardar productos
        List<Product> savedProducts = productService.saveAll(products);

        // Devolver la respuesta con estado 201 Created y lista de productos guardados
        URI location = new URI("/api/product/saveAll"); // la URI puede ser diferente según la necesidad
        return ResponseEntity.created(location).body(savedProducts);
    }

}




