package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @author liangchuancan
 * @description 课程内容接口
 * @date 2022年02月12日 21:57
 */
public interface CourseContentMapper {

    // 查询课程下的章节与课时信息
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    // 回显章节对应的课程信息
    public Course findCourseByCourseId(Integer courseId);

    // 新增章节
    public void saveSection(CourseSection section);

    // 更新章节
    public void updateSection(CourseSection section);

    // 修改章节状态
    public void updateSectionStatus(CourseSection section);
}
