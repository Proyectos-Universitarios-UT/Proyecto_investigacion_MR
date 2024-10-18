package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.OrderDetailDTO;
import net.carlos.dev.saleglobalclickback.entities.OrderDetail;
import net.carlos.dev.saleglobalclickback.repository.OrderDetailRepository;
import net.carlos.dev.saleglobalclickback.vo.OrderDetailQueryVO;
import net.carlos.dev.saleglobalclickback.vo.OrderDetailUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.OrderDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public UUID save(OrderDetailVO vO) {
        OrderDetail bean = new OrderDetail();
        BeanUtils.copyProperties(vO, bean);
        bean = orderDetailRepository.save(bean);
        return bean.getIdOrderDetail();
    }

    public void delete(String id) {
        orderDetailRepository.deleteById(id);
    }

    public void update(String id, OrderDetailUpdateVO vO) {
        OrderDetail bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        orderDetailRepository.save(bean);
    }

    public OrderDetailDTO getById(String id) {
        OrderDetail original = requireOne(id);
        return toDTO(original);
    }

    public List<OrderDetailDTO> query(OrderDetailQueryVO vO, int page, int size) {
        return orderDetailRepository.findAll(vO.toSpecification(), vO.toPageable(page, size))
                .map(this::toDTO)
                .toList();
    }

    private OrderDetailDTO toDTO(OrderDetail original) {
        OrderDetailDTO bean = new OrderDetailDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private OrderDetail requireOne(String id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
