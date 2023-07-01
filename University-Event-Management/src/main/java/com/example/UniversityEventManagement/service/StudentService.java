package com.example.UniversityEventManagement.service;

import com.example.UniversityEventManagement.model.Student;
import com.example.UniversityEventManagement.model.Type;
import com.example.UniversityEventManagement.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public void addStudentInfo(Student student) {
        studentRepo.save(student);
    }
    public Iterable<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }

    public String updateStudentDepartmentById(Integer id, Type department) {
        Optional<Student> student = studentRepo.findById(id);
        Student student1 = null;
        if(student.isPresent())
        {
            student1 = student.get();
        }
        else {
            return "Id not Found!!!";
        }
        student1.setDepartment(department);
        studentRepo.save(student1);
        return "Student type updated";
    }

    public String deleteStudentById(Integer id) {
        studentRepo.deleteById(id);
        return "Student deleted successfully of id "+id;
    }

    public Optional<Student> getRoomById(Integer id) {
        return studentRepo.findById(id);
    }

    public String addStudents(List<Student> students) {
        studentRepo.saveAll(students);
        return "rooms added"+students;
    }
}
