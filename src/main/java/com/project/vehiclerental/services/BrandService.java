package com.project.vehiclerental.services;

import com.project.vehiclerental.exceptions.BrandNotFoundException;
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

    public Brand updateBrand(Long id, Brand brand) {
        Brand oldBrand = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        oldBrand.setName(brand.getName());
        oldBrand.setCountry(brand.getCountry());
        oldBrand.setImageURL(brand.getImageURL());

        return brandRepository.save(oldBrand);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
