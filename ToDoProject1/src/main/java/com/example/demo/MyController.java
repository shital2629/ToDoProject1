package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@Autowired
	ProjectRepo prepo;
	@Autowired
	TaskRepo trepo;
	
	@RequestMapping("/")
	public String home()
	{
		return "redirect:projecthome";
	}
	
	@RequestMapping("task{tid}delete{pid}")
	public String deleteTask(@PathVariable int tid,@PathVariable int pid)
	{
		Project project=prepo.findById(pid).get();
		Task deleteTask=null;
		for(Task t:project.tasks)
		{
			if(t.id==tid)
				deleteTask=t;
		}
		project.tasks.remove(deleteTask);
		prepo.save(project);
		String s="redirect:viewtask"+pid;
		return s;
	}

	@RequestMapping("task{tid}close{pid}")
	public String closeTask(@PathVariable int tid,@PathVariable int pid)
	{
		Project project=prepo.findById(pid).get();
		for(Task t:project.tasks)
		{
			if(t.id==tid)
				t.status=false;
		}
		prepo.save(project);
		return "redirect:viewtask"+pid;
	}
	
	
	@RequestMapping("tasksave{id}")
	public String savetask(Task task,@PathVariable int id)
	{
		System.out.println(task+" "+id);
		Project project=prepo.findById(id).get();
		project.tasks.add(task);
		prepo.save(project);
		return "redirect:viewtask"+id;	
	}
	
	
	@RequestMapping("addtask{id}")
	public String addTask(@PathVariable int id,Model m)
	{
		Project project=prepo.findById(id).get();
		Task task=new Task();
		m.addAttribute("project", project);
		m.addAttribute("task", task);
		return "addtask.jsp";		
	}
	@RequestMapping("viewtask{id}")
	public String viewtask(@PathVariable int id,Model m)
	{
		Project project=prepo.findById(id).get();
		m.addAttribute("project", project);
		return "tasklist.jsp";
	}
	@RequestMapping("projecthome")
	public String projectHome(Model m)
	{
		List<Project> plist=prepo.findAll();
		m.addAttribute("plist", plist);
		return "projecthome.jsp";		
	}
	
	@RequestMapping("projectadd")
	public String projectAdd(Model m)
	{
		Project project=new Project();
		m.addAttribute("project", project);
		return "addproject.jsp";
	}
	
	@RequestMapping("projectsave")
	public String projectSave(Project project)
	{
		prepo.save(project);
		return "redirect:projecthome";
	}
	
	@RequestMapping("projectdelete{id}")
	public String deleteproject(@PathVariable int id)
	{
		prepo.deleteById(id);
		return "redirect:projecthome";
	}
}