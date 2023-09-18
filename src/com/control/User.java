package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;
import com.dao.EmailUtility;
import com.dao.PortNumber;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String name = "";
		String sql = "select email, password, name from user where email='" + uid
				+ "' and password='" + pwd + "'";
		List<String> lt = Dao.getUser(sql);
		Iterator<String> itr = lt.iterator();
		String ukey = PortNumber.getUserKey();
		String content = "Please Verify Ukey:" + ukey +"\n http://localhost:8080/MJCC08_2020/ukeyverify.jsp";
		String recipient = uid;
		String subject = "Ukey for Validating User";
		int i = 0;
		HttpSession session = request.getSession();
		while (itr.hasNext()) {
			if (itr.next().equals(uid) && itr.next().equals(pwd)) {
				name = itr.next();
				i++;
			}
		}
		try {
			if (i == 1) {
				session.setAttribute("uid", uid);
				session.setAttribute("name", name);
				sql = "update user set Ukey='"+ukey+"' where email ='"+uid+"'";
				Dao.update(sql);
				EmailUtility.sendEmail(host, port, user, pass, recipient,
						subject, content);
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Please Verify with your mail');");
				o.println("window.location='user.jsp';</script>");
			} else {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Please enter valid Details');");
				o.println("window.location='user.jsp';</script>");
			}
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
