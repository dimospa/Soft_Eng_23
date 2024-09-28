package tex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tex.service.ProfessorService;
import tex.model.Professor;
import tex.dao.ProfessorRepository;
import tex.dao.SubjectRepository;
import tex.model.*;

@Controller
public class ProfessorController {

	private ProfessorService professorService;
	private ProfessorService subjectService;

	public ProfessorController(ProfessorService professorService,ProfessorService subjectService) {
		super();
		this.professorService = professorService;
		this.subjectService = subjectService;
	}
	
	@GetMapping("/subjects")
	public String listsubjects(Model model) {
		model.addAttribute("subjects",subjectService.getAllSubjects());
		return "subjects";
	}
	
	@GetMapping("/subjects/new")
	public String createSubjectsForm(Model model) {
		List<Professor> pro= professorService.getAllProfessor();		 
		model.addAttribute("pro", pro);
		model.addAttribute("subject", new Subject());	
		return "create_subjects";	
	}
	
	@PostMapping("/subjects/save")
	public String saveSubject(@ModelAttribute("subject") Subject subject) {
		subjectService.saveSubject(subject);
		return "redirect:/subjects";
	}
	
	@GetMapping("/getAll")
	public String getAll(Model model) {
		List<Subject> sub= professorService.getAllSubjects();
		model.addAttribute("subject",sub);
		return "subjects";
	}
	
	@GetMapping("/professors")
	public String listProfessor(Model model) {
		model.addAttribute("professors",professorService.getAllProfessor());
		return "professors";
	}
	
	@GetMapping("/professors/new")
	public String createProfessorForm(Model model) {		
		Professor professor=new Professor();
		model.addAttribute("professor", professor);
		return "create_professor";		
	}
	
	@PostMapping("/professors")
	public String saveProfessor(@ModelAttribute("professor") Professor professor) {
		professorService.saveProfessor(professor);
		return "redirect:/professors";
	}
	
	
	
}
