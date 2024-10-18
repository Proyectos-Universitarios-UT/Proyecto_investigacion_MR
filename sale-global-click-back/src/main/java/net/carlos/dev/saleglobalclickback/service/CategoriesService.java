package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.CategoriesDTO;
import net.carlos.dev.saleglobalclickback.entities.Categories;
import net.carlos.dev.saleglobalclickback.repository.CategoriesRepository;
import net.carlos.dev.saleglobalclickback.vo.CategoriesQueryVO;
import net.carlos.dev.saleglobalclickback.vo.CategoriesUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.CategoriesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public UUID save(CategoriesVO vO) {
        Categories bean = new Categories();
        BeanUtils.copyProperties(vO, bean);
        bean = categoriesRepository.save(bean);
        return bean.getIdCategory();
    }

    public void delete(UUID id) {
        categoriesRepository.deleteById(id);
    }

    public void update(String id, CategoriesUpdateVO vO) {
        Categories bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        categoriesRepository.save(bean);
    }

    public CategoriesDTO getById(String id) {
        Categories original = requireOne(id);
        return toDTO(original);
    }

    public List<CategoriesDTO> query(CategoriesQueryVO vO, int page, int size) {
        Page<Categories> categoriesPage = categoriesRepository.findAll(vO.toSpecification(), PageRequest.of(page, size));
        return categoriesPage.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private CategoriesDTO toDTO(Categories original) {
        CategoriesDTO bean = new CategoriesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Categories requireOne(String id) {
        return categoriesRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
