package cn.rknight.controller;

import cn.rknight.model.Student;
import cn.rknight.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    @RequestMapping(value = "/helloWorld")
    public String helloWorld() {
        return "{\"errorMsg\":\"helloWorld\"}";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> queryStudents() {
        return studentService.queryStudents();
    }

}