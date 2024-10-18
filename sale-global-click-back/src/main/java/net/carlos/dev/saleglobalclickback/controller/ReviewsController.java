package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.ReviewsDTO;
import net.carlos.dev.saleglobalclickback.service.ReviewsService;
import net.carlos.dev.saleglobalclickback.vo.ReviewsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.ReviewsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.ReviewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping
    public String save(@Valid @RequestBody ReviewsVO vO) {
        return reviewsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        reviewsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ReviewsUpdateVO vO) {
        reviewsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ReviewsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return reviewsService.getById(id);
    }

    @GetMapping
    public List<ReviewsDTO> query(@Valid ReviewsQueryVO vO,
                                  @RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return reviewsService.query(vO, page, size);
    }
}
