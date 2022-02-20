package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author liangchuancan
 * @description
 * @date 2022年01月20日 23:33
 */
public interface CourseService {

    // 多条件查询课程信息
    public List<Course> findCourseByCondition(CourseVo courseVo);

    // 添加课程和讲师信息
    public void saveCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    // 根据id获取课程信息
    public CourseVo findCourseById(int id);

    // 修改课程和讲师信息
    public void updateCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    // 修改课程状态
    public void updateCourseStatus(int courseId, int status);
}
