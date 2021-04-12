package com.cloud_project.demo.accessingmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path = "/")
public class WebController {


    @Autowired
    private CourseRepo courseRepo;


    @GetMapping("/")
    public String root(){
        return "redirect:/all";
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewCourse(@RequestParam String subjectCode, @RequestParam int courseCode,@RequestParam String title, @RequestParam String description){
        Course c = new Course();
        c.setCourseCode(courseCode);
        c.setCourseName(title);
        c.setDescription(description);
        c.setSubjectCode(subjectCode);
        courseRepo.save(c);
        return "Saved Course";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Course> getAllCourses() {
        return courseRepo.findAll();
    }
}
