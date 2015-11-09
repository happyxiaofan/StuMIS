package com.hrms.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.edu.entity.Cert;
import com.hrms.edu.manager.CertManager;

public class ListCertServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String item = request.getParameter("item");
		if(item.equals("edit")){
			CertManager cManager=new CertManager();
			List<Cert> certs=cManager.queryAllCerts();
			request.setAttribute("certs", certs);
			request.getRequestDispatcher("/WEB-INF/edu/alterCert.jsp").forward(request, response);
		}else if(item.equals("view")){
			String cId=request.getParameter("cId");
			String cName=request.getParameter("cName");
			String cStu=request.getParameter("cStu");
			String cTec=request.getParameter("cTec");
			String cDate=request.getParameter("cDate");
			
			Cert cert=new Cert();
			cert.setcId(cId);
			cert.setcName(cName);
			cert.setcStu(cStu);
			cert.setcTec(cTec);
			cert.setcDate(cDate);
			
			CertManager cManager=new CertManager();
			cManager.addCert(cert);
			
			List<Cert> certs=cManager.queryAllCerts();
			request.setAttribute("certs", certs);
			request.getRequestDispatcher("/WEB-INF/edu/viewCert.jsp").forward(request, response);
		}else if(item.equals("add")){
			CertManager cManager=new CertManager();
			List<Cert> certs=cManager.queryAllCerts();
			request.setAttribute("certs", certs);
			request.getRequestDispatcher("/WEB-INF/edu/alterCert.jsp").forward(request, response);
		}
	}
}
