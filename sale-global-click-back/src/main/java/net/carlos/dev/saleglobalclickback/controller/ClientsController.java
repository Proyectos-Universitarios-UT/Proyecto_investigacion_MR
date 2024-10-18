package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.ClientsDTO;
import net.carlos.dev.saleglobalclickback.service.ClientsService;
import net.carlos.dev.saleglobalclickback.vo.ClientsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.ClientsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.ClientsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping
    public String save(@Valid @RequestBody ClientsVO vO) {
        return clientsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        clientsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody ClientsUpdateVO vO) {
        clientsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ClientsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return clientsService.getById(id);
    }

    @GetMapping
    public List<ClientsDTO> query(@Valid ClientsQueryVO vO,
                                  @RequestParam(value = "page", defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return clientsService.query(vO, page, size);
    }
}
