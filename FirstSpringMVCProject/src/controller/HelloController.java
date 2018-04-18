package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/parent")
public class HelloController {
	// Uses annotation mapping to display content based on url map
	// http://localhost:8080/FirstSpringMVCProject/welcome
	@RequestMapping("/welcome/{name}")
	public ModelAndView helloWorld(@PathVariable("name") String name) {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "hello "+name);
		
		return model;
	}
	
	@RequestMapping(value = "/Login.html", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("Login");
		
		return model;
	} 
	
	@RequestMapping(value = "/Logged.html", method = RequestMethod.POST)
	public ModelAndView logged(@RequestParam("user") String user, @RequestParam("pass") String pass) {
		ModelAndView model = new ModelAndView("Logged");
		model.addObject("user", user);
		model.addObject("pass", pass);
		
		return model;
	}
}

// Non-anotation way of writing the view
/** 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
 
public class HelloController extends AbstractController{
 
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage", "Hi User, welcome to the first Spring MVC Application");
		
		return modelandview;
	}
}

**/