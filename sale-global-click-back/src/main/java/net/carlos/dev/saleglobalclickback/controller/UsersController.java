package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.UsersDTO;
import net.carlos.dev.saleglobalclickback.service.UsersService;
import net.carlos.dev.saleglobalclickback.vo.UsersQueryVO;
import net.carlos.dev.saleglobalclickback.vo.UsersUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public String save(@Valid @RequestBody UsersVO vO) {
        return usersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        usersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody UsersUpdateVO vO) {
        usersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UsersDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return usersService.getById(id);
    }

    @GetMapping("/all")
    public List<UsersDTO> query(@Valid UsersQueryVO vO,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        return usersService.query(vO, page, size);
    }
}
