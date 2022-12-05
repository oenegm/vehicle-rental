package com.project.vehiclerental.controllers;

import com.project.vehiclerental.services.BrandService;
import com.project.vehiclerental.models.Brand;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getBrands() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.getAllBrands());
    }

    @GetMapping("{id}")
    public ResponseEntity<Brand> findBrandByID(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.findBrandById(id));
    }

    @PostMapping
    public ResponseEntity<Brand> addBrand(@Valid @RequestBody Brand brand) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(brandService.saveBrand(brand));
    }

    @PutMapping("{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @Valid @RequestBody Brand brand) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.updateBrand(id, brand));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable long id) {
        brandService.deleteBrand(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
