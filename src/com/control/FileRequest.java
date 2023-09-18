package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.KeyBean;
import com.dao.Dao;

/**
 * Servlet implementation class FileRequest
 */
@WebServlet("/FileRequest")
public class FileRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String na = request.getParameter("na");
		String fname = request.getParameter("fname");
		String da = request.getParameter("da");
		HttpSession session = request.getSession(false);
		String uid = (String) session.getAttribute("uid");
		String sql = "select * from keyrequest where from='"+uid+"' and date1='"+da+"'";
		boolean b = Dao.getStatus(sql);
		if(b == true){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Request Already Sent...');");
			o.println("window.location='filedownload.jsp';</script>");
		}else{
			KeyBean kb = new KeyBean();
			kb.setUid(uid);
			kb.setFname(fname);
			kb.setNa(na);
			kb.setDa(da);
			sql = "insert into keyrequest values(?,?,?,?,?)";
			int i = Dao.sendRequest(sql, kb);
			if(i > 0){
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Request Sent Sucessfully...');");
				o.println("window.location='filedownload.jsp';</script>");
			}else{
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Request not sent');");
				o.println("window.location='filedownload.jsp';</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
