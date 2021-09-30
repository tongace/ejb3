package com.dxc.ejb3.caller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.ejb3.BeanManageTransaction;

@WebServlet({"/stateful2" })
public class Stateful2Caller extends HttpServlet{
	private static final long serialVersionUID = 968610820567880155L;
	@EJB
	BeanManageTransaction helloBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();

		String message;
		try {
			message = helloBean.hello();
		}catch (Exception e) {
			e.printStackTrace();
			message= e.getMessage();
		}

		writer.println(message);
	}
}
