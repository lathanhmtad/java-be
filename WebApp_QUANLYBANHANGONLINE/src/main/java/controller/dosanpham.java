package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import context.SQLSEVERDataAccess;
import javax.servlet.ServletContext;

/**
 *
 * @author AD
 */
@WebServlet(urlPatterns = { "/dosanpham" })
public class dosanpham extends HttpServlet {
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			ServletContext context = request.getServletContext();
			String realpath = context.getRealPath("/images");
			MultipartRequest multi = new MultipartRequest(request, "E:/WebProjects/WebApp_QUANLYBANHANGONLINE/src/main/webapp/images");// "C:/Users/AD/Documents/NetBeansProjects/WebApp_QUANLYBANHANGONLINE/web/images"
			String TENSANPHAM = multi.getParameter("txtTensanpham");
			String DONGIA = multi.getParameter("txtDongia");
			String SOLUONG = multi.getParameter("txtSoluong");
			String MADANHMUC = multi.getParameter("selMadanhmuc");
			String MOTA = multi.getParameter("txtMota");
			String fileName = multi.getFilesystemName("file");
			SQLSEVERDataAccess con = new SQLSEVERDataAccess();
			String SQL = " insert into tbSANPHAM(TENSANPHAM,DONGIA,SOLUONG,HINHANH,MOTA,MADANHMUC)"
					+ "values(?,?,?,?,?,?)";
			Object[] param = { TENSANPHAM, DONGIA, SOLUONG, fileName, MOTA, MADANHMUC };
			int k = con.ExecuteSQL(SQL, param);
			response.sendRedirect("index.jsp");
		} catch (Exception ex) {

		}

	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}
}// </editor-fold>