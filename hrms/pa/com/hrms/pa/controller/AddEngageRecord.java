package com.hrms.pa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pa.entity.EngageRecordEmp;
import com.hrms.pa.manager.UserManager;

public class AddEngageRecord extends HttpServlet {

	
	public AddEngageRecord() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String item = request.getParameter("item");
		if (item.equals("query")) {
			request.getRequestDispatcher("pa/addEngageRecord.jsp").forward(request, response);
			
		}else if (item.equals("add")) {
			int recordno = Integer.parseInt(request.getParameter("recordno"));
			String emp_id = request.getParameter("emp_id");
			String emp_name = request.getParameter("emp_name");
			String emp_post = request.getParameter("emp_post");
			String emp_date = request.getParameter("emp_date");
			
			EngageRecordEmp eremp = new EngageRecordEmp();
			eremp.setRecordno(recordno);
			eremp.setEmp_id(emp_id);
			eremp.setEmp_name(emp_name);
			eremp.setEmp_post(emp_post);
			eremp.setEmp_date(emp_date);
			
			UserManager userManager = new UserManager();
			
			userManager.addEngageRecord(eremp);
			List<EngageRecordEmp> eremps = userManager.queryEngageRecordEmps();
			request.setAttribute("eremps", eremps);
			request.getRequestDispatcher("/WEB-INF/pa/engageRecord.jsp").forward(request, response);
		}else if (item.equals("view")) {
			String recordno = request.getParameter("recordno");
			String emp_id = request.getParameter("emp_id");
			String emp_name = request.getParameter("emp_name");
			String emp_post = request.getParameter("emp_post");
			String emp_date = request.getParameter("emp_date");
			
			EngageRecordEmp eremp = new EngageRecordEmp();
			eremp.setRecordno(Integer.parseInt(recordno));
			eremp.setEmp_id(emp_id);
			eremp.setEmp_name(emp_name);
			eremp.setEmp_post(emp_post);
			eremp.setEmp_date(emp_date);
			
			request.setAttribute("eremp", eremp);
			request.getRequestDispatcher("/WEB-INF/pa/updateEngageRecord.jsp").forward(request, response);
		}

	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
