package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.NotificationsDTO;
import net.carlos.dev.saleglobalclickback.entities.Notifications;
import net.carlos.dev.saleglobalclickback.repository.NotificationsRepository;
import net.carlos.dev.saleglobalclickback.vo.NotificationsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.NotificationsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.NotificationsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class NotificationsService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    public UUID save(NotificationsVO vO) {
        Notifications bean = new Notifications();
        BeanUtils.copyProperties(vO, bean);
        bean = notificationsRepository.save(bean);
        return bean.getIdNotification();
    }

    public void delete(String id) {
        notificationsRepository.deleteById(id);
    }

    public void update(String id, NotificationsUpdateVO vO) {
        Notifications bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        notificationsRepository.save(bean);
    }

    public NotificationsDTO getById(String id) {
        Notifications original = requireOne(id);
        return toDTO(original);
    }

    public List<NotificationsDTO> query(NotificationsQueryVO vO, int page, int size) {
        return notificationsRepository.findAll(vO.toSpecification(), vO.toPageable(page, size))
                .map(this::toDTO)
                .toList();

    }

    private NotificationsDTO toDTO(Notifications original) {
        NotificationsDTO bean = new NotificationsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Notifications requireOne(String id) {
        return notificationsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
