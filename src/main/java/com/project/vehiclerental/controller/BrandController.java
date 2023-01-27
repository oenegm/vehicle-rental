package com.project.vehiclerental.controller;

import com.project.vehiclerental.dto.BrandDto;
import com.project.vehiclerental.service.BrandService;
import com.project.vehiclerental.entity.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandController {
    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandDto>> getBrands() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.getAllBrands());
    }

    @GetMapping("{brandId}")
    public ResponseEntity<BrandDto> findBrand(@PathVariable("brandId") Long brandId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.findBrand(brandId));
    }

    @PostMapping
    public ResponseEntity<BrandDto> addBrand(@Valid @RequestBody BrandDto brandDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(brandService.saveBrand(brandDto));
    }

    @PutMapping("{brandId}")
    public ResponseEntity<BrandDto> updateBrand(@PathVariable("brandId") Long brandId, @Valid @RequestBody BrandDto brandDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.updateBrand(brandId, brandDto));
    }

    @DeleteMapping("{brandId}")
    public ResponseEntity<BrandDto> deleteBrand(@PathVariable("brandId") long brandId) {

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(brandService.deleteBrand(brandId));
    }
}
