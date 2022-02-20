package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月12日 22:32
 */
@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId) {
        return courseContentMapper.findSectionAndLessonByCourseId(courseId);
    }

    @Override
    public Course findCourseByCourseId(Integer courseId) {
        return courseContentMapper.findCourseByCourseId(courseId);
    }

    @Override
    public void saveSection(CourseSection section) {
        // 补全信息
        Date date = new Date();
        section.setCreateTime(date);
        section.setUpdateTime(date);
        // 调用接口
        courseContentMapper.saveSection(section);
    }

    @Override
    public void updateSection(CourseSection section) {
        // 补全信息
        Date date = new Date();
        section.setUpdateTime(date);
        // 调用接口
        courseContentMapper.updateSection(section);
    }

    @Override
    public void updateSectionStatus(int courseId, int status) {
        //封装数据
        CourseSection section = new CourseSection();
        section.setStatus(status);
        section.setId(courseId);
        section.setUpdateTime(new Date());

        //调用Dao
        courseContentMapper.updateSectionStatus(section);
    }
}
