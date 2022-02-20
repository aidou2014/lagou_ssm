package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangchuancan
 * @description
 * @date 2022年02月12日 22:33
 */
@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService contentService;

    /**
     * 依据课程id查询章节和课时信息
     */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(Integer courseId) {
        // 调用service
        List<CourseSection> courseSections = contentService.findSectionAndLessonByCourseId(courseId);
        // 响应
        return new ResponseResult(true, 200, "章节及课时查询成功", courseSections);
    }

    /**
     * 回显章节对应的课程信息
     */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId) {
        // 调用service
        Course course = contentService.findCourseByCourseId(courseId);
        // 响应
        return new ResponseResult(true, 200, "查询课程信息成功", course);
    }

    /**
     * 新增或修改章节信息
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveSection(@RequestBody CourseSection section) {

        if (section.getId() == null) {
            // 新增
            contentService.saveSection(section);
            // 响应
            return new ResponseResult(true, 200, "章节新增成功", null);
        } else {
            // 更新
            contentService.updateSection(section);
            // 响应
            return new ResponseResult(true, 200, "章节更新成功", null);
        }
    }

    /**
     * 修改课程状态
     */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateCourseStatus(int id, int status) {
        // 调用service，传递参数，完成课程状态的变更
        contentService.updateSectionStatus(id, status);
        // 响应数据
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);

        return new ResponseResult(true, 200, "章节状态变更成功", map);
    }

}
