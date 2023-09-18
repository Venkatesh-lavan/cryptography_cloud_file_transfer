package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.VCMBean;
import com.dao.Dao;
import com.dao.PortNumber;

/**
 * Servlet implementation class VCMInitialize
 */
@WebServlet("/VCMInitialize")
public class VCMInitialize extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VCMInitialize() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		HttpSession session = request.getSession(false);
		String email = (String) session.getAttribute("uid");
		String ukey = PortNumber.getUserKey();
		String sql = "select * from vcmkey where userid='" + email + "'";
		boolean b = Dao.getStatus(sql);
		if (b == true) {
			sql = "update vcmkey set vcmkey='"+ukey+"' where userid='" + email + "'";
			int i = Dao.update(sql);
			if (i > 0) {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('VCM key is sent successfully...');");
				o.println("window.location='vcmrequest.jsp';</script>");
			} else {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('VCM Request not sent');");
				o.println("window.location='uhome.jsp';</script>");
			}
		} else {
			sql = "insert into vcmkey values(?,?,?)";
			VCMBean vb = new VCMBean();
			vb.setEmail(email);
			vb.setUkey(ukey);
			int i = Dao.setVkey(sql, vb);
			if (i > 0) {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('VCM key is sent successfully...');");
				o.println("window.location='vcmrequest.jsp';</script>");
			} else {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('VCM Request not sent');");
				o.println("window.location='uhome.jsp';</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
