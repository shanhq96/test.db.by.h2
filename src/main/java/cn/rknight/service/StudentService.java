package cn.rknight.service;

import cn.rknight.mapper.StudentMapper;
import cn.rknight.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class StudentService {

    private final StudentMapper studentMapper;


    public List<Student> queryStudents() {
        return studentMapper.queryStudents();
    }


}
