package com.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bean.UploadBean;
import com.dao.Dao;
import com.dao.PortNumber;
import com.dao.Test;

/**
 * Servlet implementation class Upload
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
		HttpSession session = request.getSession(false);
		String uid = (String) session.getAttribute("uid");
		String fname = request.getParameter("fname");
		Part img = request.getPart("photo");
		InputStream photo = null;
		if(img != null){
			photo = img.getInputStream();
		}
		String content = img.getContentType();
		String rk = PortNumber.getKeys();
		String cmk = PortNumber.getKeys();
		String ecmk = Test.encryption(cmk, rk);
		String dek = PortNumber.getKeys();
		String edek = Test.encryption(dek, cmk);
		Date d = new Date();
		String da = "" + d;
		UploadBean ub = new UploadBean();
		ub.setUid(uid);
		ub.setFname(fname);
		ub.setPhoto(photo);
		ub.setContent(content);
		ub.setRk(rk);
		ub.setCmk(cmk);
		ub.setEcmk(ecmk);
		ub.setDek(dek);
		ub.setEdek(edek);
		ub.setDa(da);
		String sql = "insert into upload values(?,?,?,?,?,?,?,?,?,?,AES_ENCRYPT(?,?))";
		int i = Dao.upload(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('File Uploaded Sucessfully...');");
			o.println("window.location='fileupload.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('File not Uploaded');");
			o.println("window.location='fileupload.jsp';</script>");
		}
	}

}
