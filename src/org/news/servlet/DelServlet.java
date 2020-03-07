package org.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.service.BookManageService;
import org.news.service.impl.BookManageServiceImpl;

/**
 * @author think
 */
@WebServlet(name="DelServlet",urlPatterns="/DelServlet")
public class DelServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

    /**
     * 通过ID来删除信息
     * @param request
     * @param response
     */
	public void del(HttpServletRequest request, HttpServletResponse response) {
		
		String idString=request.getParameter("id");
		
		int id =Integer.parseInt(idString);
		
		BookManageService bookManageService =new BookManageServiceImpl();
			try {
			int result=	bookManageService.del(id);

			} catch (Exception e) {
				 e.printStackTrace();
			}		
			 try {
					request.getRequestDispatcher("ListServlet?opr=list").forward(
					        request, response);
				} catch (ServletException e) {				
					e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
				}
		
		
		}

}
