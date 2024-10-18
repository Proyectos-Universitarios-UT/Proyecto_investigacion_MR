package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.OrderDetailDTO;
import net.carlos.dev.saleglobalclickback.service.OrderDetailService;
import net.carlos.dev.saleglobalclickback.vo.OrderDetailQueryVO;
import net.carlos.dev.saleglobalclickback.vo.OrderDetailUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping
    public String save(@Valid @RequestBody OrderDetailVO vO) {
        return orderDetailService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        orderDetailService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody OrderDetailUpdateVO vO) {
        orderDetailService.update(id, vO);
    }

    @GetMapping("/{id}")
    public OrderDetailDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return orderDetailService.getById(id);
    }

    @GetMapping
    public List<OrderDetailDTO> query(@Valid OrderDetailQueryVO vO, @RequestParam("page") int page, @RequestParam("size") int size) {
        return orderDetailService.query(vO, page, size);
    }
}
