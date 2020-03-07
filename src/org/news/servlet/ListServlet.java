package org.news.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.entity.BookManage;
import org.news.service.BookManageService;
import org.news.service.impl.BookManageServiceImpl;

/**
 * @author think
 */
@WebServlet(name="ListServlet",urlPatterns="/ListServlet")
public class ListServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * ≤È—Ø
     * @param request
     * @param response
     */
	public void list(HttpServletRequest request, HttpServletResponse response) {

		List<BookManage> list = null;
		BookManageService bookManageService = new BookManageServiceImpl();
		try {
			list = bookManageService.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
			list = new ArrayList<BookManage>();
		}
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
