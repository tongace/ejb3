package com.dxc.ejb3.caller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.ejb3.ContainerManageTransaction;

@WebServlet({"/stateless2" })
public class Stateless2Caller extends HttpServlet {

	private static final long serialVersionUID = -6625541435158737911L;

	@EJB
	ContainerManageTransaction helloBean;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();

		String message = helloBean.hello();

		writer.println(message);
	}
}
