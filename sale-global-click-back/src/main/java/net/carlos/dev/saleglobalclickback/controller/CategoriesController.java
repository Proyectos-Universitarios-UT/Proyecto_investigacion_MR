package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.CategoriesDTO;
import net.carlos.dev.saleglobalclickback.service.CategoriesService;
import net.carlos.dev.saleglobalclickback.vo.CategoriesQueryVO;
import net.carlos.dev.saleglobalclickback.vo.CategoriesUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.CategoriesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    public String save(@Valid @RequestBody CategoriesVO vO) {
        return categoriesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") UUID id) {
        categoriesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") UUID id,
                       @Valid @RequestBody CategoriesUpdateVO vO) {
        categoriesService.update(String.valueOf(id), vO);
    }

    @GetMapping("/{id}")
    public CategoriesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return categoriesService.getById(id);
    }

    @GetMapping
    public List<CategoriesDTO> query(@Valid CategoriesQueryVO vO,
                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return categoriesService.query(vO, page, size);
    }
}
