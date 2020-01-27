package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import entity.Task;
import service.TaskService;
/*
"/tasks/{id:[\\d]+}/edit"
*/
@Controller
public class TMViewController {

	@Autowired
	private TaskService service;
	
	@Autowired
	@Qualifier("taskValidator")
	private Validator taskValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(taskValidator);
	}
	
	@ModelAttribute("task")
	public Task getTask(){
		return new Task(0,"0");
	}
	
	@GetMapping("/")
	public String getRoot() {
		return  "redirect:/tasks";
	}
	
	@GetMapping("/tasks")
	public String getTasks(Model model){
		model.addAttribute("tasks", service.getTasksList());
		return "tasks";
	}
	
	@PostMapping("/tasks")
	public String addOrUpdateTask(@Validated @ModelAttribute("task") Task task, BindingResult bindingResult, Model model, HttpServletRequest req) {
		if(bindingResult.hasErrors()) {
			return "formTask";
		}
		System.out.println("ContentType: " + req.getContentType() + "\n" + "Locale: " + req.getLocale() + "\nCharset: " + req.getCharacterEncoding());
		System.out.println("!!!!" + task.getDescription() + "!!!!!!!");
		service.addOrUpdateTask(task);
		return "redirect:/tasks/" + task.getId();
	}
	
	@GetMapping("/tasks/{id}")
	public String viewTask(@PathVariable("id") int id, Model model) {
		model.addAttribute("task", service.getTask(id));
		return "viewTask";
	}
	
	@GetMapping("/tasks/add")
	public String addTask(Model model) {
		return "formTask";
	}
	
	@GetMapping("/tasks/{id}/update")
	public String updateTask(@PathVariable("id") int id, Model model) {
		model.addAttribute("task", service.getTask(id));
		return "formTask";
	}
	
	@GetMapping("/tasks/{id}/delete")
	public String deleteTask(@PathVariable("id") int id, Model model) {
		service.deleteTask(id);
		model.addAttribute("tasks", service.getTasksList());
		return "redirect:/tasks";
	}
}
