package org.news.servlet;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.entity.BookManage;
import org.news.service.BookManageService;
import org.news.service.impl.BookManageServiceImpl;

/**
 * @author think
 */
@WebServlet(name="InsertServlet",urlPatterns="/InsertServlet")
public class InsertServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * ��ѯ��ϸ��Ϣ
     * @param request
     * @param response
     * @throws ParseException
     */
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out ;	
		String contextPath = request.getContextPath();
		BookManageService bookManageService =new BookManageServiceImpl();
		
		String name=request.getParameter("book");
		String author=request.getParameter("author");
		String dateString=request.getParameter("date");
		 //ʵ���ַ������������͵�ת��
	       Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString); 
		String typeString=request.getParameter("selectType");

		System.out.println(typeString);

		int type=Integer.parseInt(typeString);

		BookManage bookManage=new BookManage();
		bookManage.setName(name);
		bookManage.setAuthor(author);
		bookManage.setTime(date);
		bookManage.setType(type);
		
		try {
			out = response.getWriter();
			int result= bookManageService.insertBook(bookManage);
			 if (result == -1) {
	                out.print("<script type=\"text/javascript\">");
	                out.print("alert(\"û����ӳɹ�\");");
	                out.print("</script>");
	            } else if (result == 0) {
	                out.print("<script type=\"text/javascript\">");
	                out.print("alert(\"δ�ҵ������Ϣ\");");
	                out.print("location.href=\"" + contextPath
	                        + "/ListServlet?opr=list\";");
	                out.print("</script>");
	            } else {
	                out.print("<script type=\"text/javascript\">");
	                out.print("alert(\"�Ѿ���ӳɹ���Ϣ�����ȷ�Ϸ�����ҳ\");");
	                out.print("location.href=\"" + contextPath
	                        + "/ListServlet?opr=list\";");
	                out.print("</script>");
	            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
