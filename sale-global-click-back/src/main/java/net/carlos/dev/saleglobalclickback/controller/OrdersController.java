package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.OrdersDTO;
import net.carlos.dev.saleglobalclickback.service.OrdersService;
import net.carlos.dev.saleglobalclickback.vo.OrdersQueryVO;
import net.carlos.dev.saleglobalclickback.vo.OrdersUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public String save(@Valid @RequestBody OrdersVO vO) {
        return ordersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        ordersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody OrdersUpdateVO vO) {
        ordersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public OrdersDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return ordersService.getById(id);
    }

    @GetMapping
    public List<OrdersDTO> query(@Valid OrdersQueryVO vO, @RequestParam("page") int page, @RequestParam("size") int size) {
        return ordersService.query(vO, page, size);
    }
}
