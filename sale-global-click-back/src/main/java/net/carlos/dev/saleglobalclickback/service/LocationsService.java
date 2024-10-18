package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.LocationsDTO;
import net.carlos.dev.saleglobalclickback.entities.Locations;
import net.carlos.dev.saleglobalclickback.repository.LocationsRepository;
import net.carlos.dev.saleglobalclickback.vo.LocationsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.LocationsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.LocationsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class LocationsService {

    @Autowired
    private LocationsRepository locationsRepository;

    public UUID save(LocationsVO vO) {
        Locations bean = new Locations();
        BeanUtils.copyProperties(vO, bean);
        bean = locationsRepository.save(bean);
        return bean.getIdLocation();
    }

    public void delete(String id) {
        locationsRepository.deleteById(id);
    }

    public void update(String id, LocationsUpdateVO vO) {
        Locations bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        locationsRepository.save(bean);
    }

    public LocationsDTO getById(String id) {
        Locations original = requireOne(id);
        return toDTO(original);
    }

    public List<LocationsDTO> query(LocationsQueryVO vO, Integer page, Integer size) {
        return locationsRepository.findAll(vO.toSpecification(), vO.toPageable(page, size))
                .map(this::toDTO)
                .toList();

    }

    private LocationsDTO toDTO(Locations original) {
        LocationsDTO bean = new LocationsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Locations requireOne(String id) {
        return locationsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
