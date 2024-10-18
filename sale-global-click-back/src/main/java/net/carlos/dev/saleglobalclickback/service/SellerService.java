package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.SellerDTO;
import net.carlos.dev.saleglobalclickback.entities.Seller;
import net.carlos.dev.saleglobalclickback.repository.SellerRepository;
import net.carlos.dev.saleglobalclickback.vo.SellerQueryVO;
import net.carlos.dev.saleglobalclickback.vo.SellerUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.SellerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public UUID save(SellerVO vO) {
        Seller bean = new Seller();
        BeanUtils.copyProperties(vO, bean);
        bean = sellerRepository.save(bean);
        return bean.getIdSeller();
    }

    public void delete(String id) {
        sellerRepository.deleteById(UUID.fromString(id));
    }

    public void update(String id, SellerUpdateVO vO) {
        Seller bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        sellerRepository.save(bean);
    }

    public SellerDTO getById(String id) {
        Seller original = requireOne(id);
        return toDTO(original);
    }

    public List<SellerDTO> query(SellerQueryVO vO, Integer page, Integer size) {
        return sellerRepository.findAll(vO.toSpecification(), vO.toPageable(page, size))
                .map(this::toDTO)
                .toList();
    }

    private SellerDTO toDTO(Seller original) {
        SellerDTO bean = new SellerDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Seller requireOne(String id) {
        return sellerRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
