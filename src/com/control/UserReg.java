package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.Dao;
import com.dao.PortNumber;

/**
 * Servlet implementation class UserReg
 */
@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String mob = request.getParameter("mob");
		String ip = request.getParameter("ip");
		int port1 = Integer.parseInt(request.getParameter("port"));
		String ukey = PortNumber.getUserKey();
		UserBean ub = new UserBean();
		ub.setName(name);
		ub.setEmail(email);
		ub.setPwd(pwd);
		ub.setMob(mob);
		ub.setIp(ip);
		ub.setPort(port1);
		ub.setUkey(ukey);
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
			int i = Dao.setUser(sql, ub);
			if(i > 0){
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Register Successfully...');");
				o.println("window.location='user.jsp';</script>");
			}else{
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Please enter valid Details');");
				o.println("window.location='userreg.jsp';</script>");
			}
	}

}
