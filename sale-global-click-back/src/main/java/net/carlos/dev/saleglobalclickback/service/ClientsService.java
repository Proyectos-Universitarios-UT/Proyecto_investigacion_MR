package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.ClientsDTO;
import net.carlos.dev.saleglobalclickback.entities.Clients;
import net.carlos.dev.saleglobalclickback.repository.ClientsRepository;
import net.carlos.dev.saleglobalclickback.vo.ClientsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.ClientsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.ClientsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    public UUID save(ClientsVO vO) {
        Clients bean = new Clients();
        BeanUtils.copyProperties(vO, bean);
        bean = clientsRepository.save(bean);
        return bean.getIdClient();
    }

    public void delete(String id) {
        clientsRepository.deleteById(UUID.fromString(id));
    }

    public void update(String id, ClientsUpdateVO vO) {
        Clients bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        clientsRepository.save(bean);
    }

    public ClientsDTO getById(String id) {
        Clients original = requireOne(id);
        return toDTO(original);
    }

    public List<ClientsDTO> query(ClientsQueryVO vO, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Clients> result = clientsRepository.findAll(vO.toSpecification(), pageable);
        return result.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private ClientsDTO toDTO(Clients original) {
        ClientsDTO bean = new ClientsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Clients requireOne(String id) {
        return clientsRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
