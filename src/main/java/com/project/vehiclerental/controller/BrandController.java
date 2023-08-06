package com.project.vehiclerental.controller;

import com.project.vehiclerental.dto.BrandDto;
import com.project.vehiclerental.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@RequiredArgsConstructor
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
    public ResponseEntity<BrandDto> updateBrand(
            @PathVariable("brandId") Long brandId,
            @Valid @RequestBody BrandDto brandDto
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(brandService.updateBrand(brandId, brandDto));
    }

    @DeleteMapping("{brandId}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("brandId") long brandId) {
        brandService.deleteBrand(brandId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}

