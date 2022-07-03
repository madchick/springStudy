package com.haksik.haksikapi.courseprice.service;

import com.haksik.haksikapi.courseprice.model.CoursePriceEntity;
import com.haksik.haksikapi.courseprice.model.CoursePriceRequest;
import com.haksik.haksikapi.courseprice.repository.CoursePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CoursePriceService {

    @Autowired
    private CoursePriceRepository coursePriceRepository;

    public CoursePriceEntity add(CoursePriceRequest coursePriceRequest) {
        CoursePriceEntity coursePriceEntity = new CoursePriceEntity();
        coursePriceEntity.setMenuId(coursePriceRequest.getMenuId());
        coursePriceEntity.setCourseId(coursePriceRequest.getCourseId());
        coursePriceEntity.setCoursePrice(coursePriceRequest.getCoursePrice());
        coursePriceEntity.setEnabled(true);

        return this.coursePriceRepository.save(coursePriceEntity);
    }

    public CoursePriceEntity updateById(CoursePriceRequest coursePriceRequest) {
        CoursePriceEntity coursePriceEntity = this.searchById(coursePriceRequest.getMenuId(), coursePriceRequest.getCourseId());

        coursePriceEntity.setCoursePrice(coursePriceRequest.getCoursePrice());
        coursePriceEntity.setEnabled(coursePriceRequest.getCoursePriceEnabled());

        coursePriceEntity.setModifiedDate(LocalDateTime.now());

        return this.coursePriceRepository.save(coursePriceEntity);
    }

    public void deleteById(CoursePriceRequest coursePriceRequest) {
        CoursePriceEntity coursePriceEntity = this.searchById(coursePriceRequest.getMenuId(), coursePriceRequest.getCourseId());
        coursePriceEntity.setEnabled(false);

        this.coursePriceRepository.save(coursePriceEntity);
    }

    public CoursePriceEntity searchById(Long menuId, Long courseId) {
        return this.coursePriceRepository.findByMenuIdAndCourseId(menuId,courseId);
    }

    public List<CoursePriceEntity> searchByMenuId(Long menuId) { return this.coursePriceRepository.findByMenuId(menuId); }

}
