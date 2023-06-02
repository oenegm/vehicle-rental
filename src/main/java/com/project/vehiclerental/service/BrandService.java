package com.project.vehiclerental.service;

import com.project.vehiclerental.dto.BrandDto;
import com.project.vehiclerental.entity.Brand;
import com.project.vehiclerental.exception.BrandNotFoundException;
import com.project.vehiclerental.mapper.BrandMapper;
import com.project.vehiclerental.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll()
                .stream().parallel()
                .map(brandMapper::toDto)
                .toList();
    }

    public BrandDto findBrand(Long id) {
        return brandMapper.toDto(
                brandRepository.findById(id)
                        .orElseThrow(() -> new BrandNotFoundException(id))
        );
    }

    public BrandDto saveBrand(BrandDto brandDto) {
        return brandMapper.toDto(
                brandRepository.save(
                        brandMapper.toEntity(brandDto)
                )
        );
    }

    public BrandDto updateBrand(Long id, BrandDto brandDto) {
        Brand updatedBrand = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        BeanUtils.copyProperties(brandDto, updatedBrand, "id");

        return brandMapper.toDto(
                brandRepository.save(updatedBrand)
        );
    }

    public void deleteBrand(Long brandId) {
        brandRepository.deleteById(brandId);
    }
}
