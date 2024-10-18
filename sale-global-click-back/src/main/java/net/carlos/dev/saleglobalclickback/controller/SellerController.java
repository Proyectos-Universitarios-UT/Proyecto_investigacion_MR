package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.SellerDTO;
import net.carlos.dev.saleglobalclickback.service.SellerService;
import net.carlos.dev.saleglobalclickback.vo.SellerQueryVO;
import net.carlos.dev.saleglobalclickback.vo.SellerUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.SellerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public String save(@Valid @RequestBody SellerVO vO) {
        return sellerService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        sellerService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody SellerUpdateVO vO) {
        sellerService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SellerDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return sellerService.getById(id);
    }

    @GetMapping
    public List<SellerDTO> query(@Valid SellerQueryVO vO,
                                 @RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "size", required = false) Integer size) {
        return sellerService.query(vO, page, size);
    }
}
