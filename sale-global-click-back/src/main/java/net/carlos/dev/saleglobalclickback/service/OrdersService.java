package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.OrdersDTO;
import net.carlos.dev.saleglobalclickback.entities.Orders;
import net.carlos.dev.saleglobalclickback.repository.OrdersRepository;
import net.carlos.dev.saleglobalclickback.vo.OrdersQueryVO;
import net.carlos.dev.saleglobalclickback.vo.OrdersUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.OrdersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public UUID save(OrdersVO vO) {
        Orders bean = new Orders();
        BeanUtils.copyProperties(vO, bean);
        bean = ordersRepository.save(bean);
        return bean.getIdOrders();
    }

    public void delete(String id) {
        ordersRepository.deleteById(id);
    }

    public void update(String id, OrdersUpdateVO vO) {
        Orders bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        ordersRepository.save(bean);
    }

    public OrdersDTO getById(String id) {
        Orders original = requireOne(id);
        return toDTO(original);
    }

    public List<OrdersDTO> query(OrdersQueryVO vO, int page, int size) {
        return ordersRepository.findAll(vO.toSpecification(), vO.toPageable(page, size))
                .map(this::toDTO)
                .toList();
    }

    private OrdersDTO toDTO(Orders original) {
        OrdersDTO bean = new OrdersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Orders requireOne(String id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
