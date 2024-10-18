package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.UsersDTO;
import net.carlos.dev.saleglobalclickback.entities.Users;
import net.carlos.dev.saleglobalclickback.repository.UsersRepository;
import net.carlos.dev.saleglobalclickback.vo.UsersQueryVO;
import net.carlos.dev.saleglobalclickback.vo.UsersUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.UsersVO;
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
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UUID save(UsersVO vO) {
        Users bean = new Users();
        BeanUtils.copyProperties(vO, bean);
        bean = usersRepository.save(bean);
        return bean.getIdUser();
    }

    public void delete(String id) {
        usersRepository.deleteById(UUID.fromString(id));
    }

    public void update(String id, UsersUpdateVO vO) {
        Users bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        usersRepository.save(bean);
    }

    public UsersDTO getById(String id) {
        Users original = requireOne(id);
        return toDTO(original);
    }

    public List<UsersDTO> query(UsersQueryVO vO, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Users> usersPage = usersRepository.findAll(vO.toSpecification(), pageable);
        return usersPage.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private UsersDTO toDTO(Users original) {
        UsersDTO bean = new UsersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Users requireOne(String id) {
        return usersRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
