package com.example.lab5student.Controller;

import com.example.lab5student.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        students.add(student);
        return "student added";
    }

    @GetMapping("/{index}/name")
    public String name(@PathVariable int index){
       return students.get(index).getName();
    }
    @GetMapping("/{index}/age")
    public int age(@PathVariable int index){
        return students.get(index).getAge();
    }

    @GetMapping("/{index}/college/status")
    public boolean isGraduated(@PathVariable int index){
        return students.get(index).isGraduated();
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        return students;
    }

    @PutMapping("/{index}/update")
    public String update(@PathVariable int index, @RequestBody Student student){
        students.set(index,student);
        return "student updated";
    }
    @DeleteMapping("/{index}/delete")
    public String delete(@PathVariable int index){
        students.remove(index);
        return "student deleted";
    }
}
