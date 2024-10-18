package net.carlos.dev.saleglobalclickback.service;

import net.carlos.dev.saleglobalclickback.dto.ReviewsDTO;
import net.carlos.dev.saleglobalclickback.entities.Reviews;
import net.carlos.dev.saleglobalclickback.repository.ReviewsRepository;
import net.carlos.dev.saleglobalclickback.vo.ReviewsQueryVO;
import net.carlos.dev.saleglobalclickback.vo.ReviewsUpdateVO;
import net.carlos.dev.saleglobalclickback.vo.ReviewsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public UUID save(ReviewsVO vO) {
        Reviews bean = new Reviews();
        BeanUtils.copyProperties(vO, bean);
        bean = reviewsRepository.save(bean);
        return bean.getIdReview();
    }

    public void delete(String id) {
        reviewsRepository.deleteById(id);
    }

    public void update(String id, ReviewsUpdateVO vO) {
        Reviews bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        reviewsRepository.save(bean);
    }

    public ReviewsDTO getById(String id) {
        Reviews original = requireOne(id);
        return toDTO(original);
    }

    public List<ReviewsDTO> query(ReviewsQueryVO vO, Integer page, Integer size) {
        return reviewsRepository.findAll(vO.toSpecification(), vO.toPageable(page, size))
                .map(this::toDTO).
                toList();
    }

    private ReviewsDTO toDTO(Reviews original) {
        ReviewsDTO bean = new ReviewsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Reviews requireOne(String id) {
        return reviewsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
