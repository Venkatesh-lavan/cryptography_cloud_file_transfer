package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.KeyRequestBean;
import com.dao.Dao;
import com.dao.EmailUtility;

/**
 * Servlet implementation class SendKeys
 */
@WebServlet("/SendKeys")
public class SendKeys extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendKeys() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String to = request.getParameter("to");
		String fname = request.getParameter("fname");
		String da = request.getParameter("da");
		System.out.println(da+" "+fname);
		String sql = "select rk,cmk,dek from upload where date1='"+da+"' and filename='"+fname+"'";
		List<String> lt = Dao.getRequest(sql);
		Iterator<String> itr = lt.iterator();
		String rk = "", cmk = "", dek = "";
		while(itr.hasNext()){
			rk = itr.next();
			cmk = itr.next();
			dek = itr.next();
		}
		Date d = new Date();
		String da1 = "" + d;
		KeyRequestBean kb = new KeyRequestBean();
		kb.setTo(to);
		kb.setFname(fname);
		kb.setDa(da);
		kb.setRk(rk);
		kb.setCmk(cmk);
		kb.setDek(dek);
		kb.setDa1(da1);
		String content = "File Keys Root Key:" + rk +"\n Consumer Master Key:"+ cmk +"\n Data Encryption Key:"+dek+"\n Enter These keys for File name="+fname+" and Date="+da;
		String recipient = to;
		String subject = "Ukey for Validating User";
		try {
			sql = "insert into keyreceived values(?,?,?,?,?,?,?)";
			int i = Dao.sendKeys(sql, kb);
			if(i > 0){
				EmailUtility.sendEmail(host, port, user, pass, recipient, subject, content);
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Keys are sent to mail successfully');");
				o.println("window.location='keyre.jsp';</script>");
			} else {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Keys are not sent');");
				o.println("window.location='keyre.jsp';</script>");
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
