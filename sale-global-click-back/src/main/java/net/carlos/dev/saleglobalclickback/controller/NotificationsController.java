package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.NotificationsDTO;
import net.carlos.dev.saleglobalclickback.service.NotificationsService;
import net.carlos.dev.saleglobalclickback.vo.NotificationsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.NotificationsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.NotificationsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    @Autowired
    private NotificationsService notificationsService;

    @PostMapping
    public String save(@Valid @RequestBody NotificationsVO vO) {
        return notificationsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        notificationsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody NotificationsUpdateVO vO) {
        notificationsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public NotificationsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return notificationsService.getById(id);
    }

    @GetMapping
    public List<NotificationsDTO> query(@Valid NotificationsQueryVO vO, @RequestParam("page") int page, @RequestParam("size") int size) {
        return notificationsService.query(vO, page, size);
    }
}
