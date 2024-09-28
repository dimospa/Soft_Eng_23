package tex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tex.service.*;
import tex.model.*;

@Controller
public class StudentController {
	
	private StudentService studentService;
	private ProfessorService professorService;
	
	public StudentController(StudentService studentService,ProfessorService professorService) {
		super();
		this.studentService = studentService;
		this.professorService=professorService;
	}
		
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/student")
	public String Student() {
		return "student";
	}
	
	@GetMapping("/professor")
	public String Professor() {
		return "professor";
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/apply")
	public String makeApplication(Model model) {
		List<Student> stu=studentService.getAllStudents();
		List<Subject> sub=professorService.getAllSubjects();
		model.addAttribute("subj", sub);
		model.addAttribute("stud", stu);
		model.addAttribute("applic", new Application());
		return "create_apply";
	}
	
	@PostMapping("/apply/save")
	public String saveApplication(@ModelAttribute("applic") Application application) {
		studentService.saveApplication(application);
		return "redirect:/subjects";
	}

}
