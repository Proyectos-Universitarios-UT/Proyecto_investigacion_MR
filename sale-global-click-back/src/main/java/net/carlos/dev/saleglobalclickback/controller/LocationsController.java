package net.carlos.dev.saleglobalclickback.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import net.carlos.dev.saleglobalclickback.dto.LocationsDTO;
import net.carlos.dev.saleglobalclickback.service.LocationsService;
import net.carlos.dev.saleglobalclickback.vo.LocationsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.LocationsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.LocationsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/locations")
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @PostMapping
    public String save(@Valid @RequestBody LocationsVO vO) {
        return locationsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        locationsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody LocationsUpdateVO vO) {
        locationsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public LocationsDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return locationsService.getById(id);
    }

    @GetMapping
    public List<LocationsDTO> query(@Valid LocationsQueryVO vO,
                                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return locationsService.query(vO, page, size);
    }
}
