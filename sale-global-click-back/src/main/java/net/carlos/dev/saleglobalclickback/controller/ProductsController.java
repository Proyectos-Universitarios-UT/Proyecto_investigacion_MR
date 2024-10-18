package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.ProductsDTO;
import net.carlos.dev.saleglobalclickback.service.ProductsService;
import net.carlos.dev.saleglobalclickback.vo.ProductsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.ProductsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.ProductsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping
    public String save(@Valid @RequestBody ProductsVO vO) {
        return productsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        productsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ProductsUpdateVO vO) {
        productsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ProductsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return productsService.getById(id);
    }

    @GetMapping
    public List<ProductsDTO> query(@Valid ProductsQueryVO vO, @RequestParam("page") int page, @RequestParam("size") int size) {
        return productsService.query(vO, page, size);
    }
}
