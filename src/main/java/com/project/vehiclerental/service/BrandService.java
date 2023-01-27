package com.project.vehiclerental.service;

import com.project.vehiclerental.dto.BrandDto;
import com.project.vehiclerental.exception.BrandNotFoundException;
import com.project.vehiclerental.entity.Brand;
import com.project.vehiclerental.mapper.BrandMapper;
import com.project.vehiclerental.repository.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BrandService {
    private final BrandMapper brandMapper;
    private final BrandRepository brandRepository;

    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .parallel()
                .map(brandMapper::toDto)
                .collect(Collectors.toList());
    }

    public BrandDto findBrand(Long id) {
        return brandMapper.toDto(brandRepository.findById(id).orElseThrow(() -> new BrandNotFoundException(id)));
    }

    public BrandDto saveBrand(BrandDto brandDto) {
        return brandMapper.toDto(brandRepository.save(brandMapper.toEntity(brandDto)));
    }

    public BrandDto updateBrand(Long id, BrandDto brandDto) {
        Brand updatedBrand = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        BeanUtils.copyProperties(brandDto, updatedBrand, "id");

        return brandMapper.toDto(brandRepository.save(updatedBrand));
    }

    public BrandDto deleteBrand(Long id) {
        Brand deletedBrand = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id));

        brandRepository.delete(deletedBrand);

        return brandMapper.toDto(deletedBrand);
    }
}
