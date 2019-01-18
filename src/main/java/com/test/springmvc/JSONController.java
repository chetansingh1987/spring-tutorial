package com.test.springmvc;


import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.datamanagement.hibernate.dto.EmployeeDTO;

@Controller
@RequestMapping("/rest")
public class JSONController {

	@RequestMapping(value="/test/{empId}",method=RequestMethod.GET)
	public @ResponseBody EmployeeDTO getEmployee(@PathVariable int empId) throws Exception {
		return MyBeanManager.getBean(HibernateTester.class).getEmployee(empId);
	}
	
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public RedirectView  method(HttpServletResponse httpServletResponse) {
        return new RedirectView("http://localhost:1092/httpfe");
    }	
}