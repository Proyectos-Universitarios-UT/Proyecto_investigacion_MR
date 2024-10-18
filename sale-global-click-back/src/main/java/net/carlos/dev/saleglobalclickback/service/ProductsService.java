package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.ProductsDTO;
import net.carlos.dev.saleglobalclickback.entities.Products;
import net.carlos.dev.saleglobalclickback.repository.ProductsRepository;
import net.carlos.dev.saleglobalclickback.vo.ProductsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.ProductsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.ProductsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public UUID save(ProductsVO vO) {
        Products bean = new Products();
        BeanUtils.copyProperties(vO, bean);
        bean = productsRepository.save(bean);
        return bean.getIdProducts();
    }

    public void delete(String id) {
        productsRepository.deleteById(id);
    }

    public void update(String id, ProductsUpdateVO vO) {
        Products bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productsRepository.save(bean);
    }

    public ProductsDTO getById(String id) {
        Products original = requireOne(id);
        return toDTO(original);
    }

    public List<ProductsDTO> query(ProductsQueryVO vO, int page, int size) {
        return productsRepository.findAll(vO.toSpecification(), vO.toPageable(page, size))
                .map(this::toDTO)
                .toList();
    }

    private ProductsDTO toDTO(Products original) {
        ProductsDTO bean = new ProductsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Products requireOne(String id) {
        return productsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
