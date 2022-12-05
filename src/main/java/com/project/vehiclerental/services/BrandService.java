package com.project.vehiclerental.services;

import com.project.vehiclerental.models.Brand;
import com.project.vehiclerental.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;
    
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand findBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    //TODO: Implement updateBrand method
    public Brand updateBrand(Long id, Brand brand) {
        return brandRepository.save(brand);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
