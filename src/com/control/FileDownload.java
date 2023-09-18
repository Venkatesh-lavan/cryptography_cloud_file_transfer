package com.control;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
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
		String rk = request.getParameter("rk");
		String cmk = request.getParameter("cmk");
		String dek = request.getParameter("dek");
		String da = request.getParameter("da");
		String sql = "select * from upload where rk ='"+rk+"' and cmk='"+cmk+"' and dek='"+dek+"' and date1='"+da+"'";
		ResultSet rs = Dao.getData(sql);
		try {
			rs = Dao.getData(sql);
			OutputStream o = response.getOutputStream();
			if(rs.next()){
				response.setContentType(rs.getString(4));
				o.write(rs.getBytes(3));
			}else{
				response.sendRedirect("filedownload.jsp");
			}
			o.flush();
			o.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
