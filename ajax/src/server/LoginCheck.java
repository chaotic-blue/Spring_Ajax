package server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
      
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userid 파라미터 -> DB 중복체크 -> 중복체크 -> 결과 전송
    	response.setContentType("text/html; charset=UTF-8");
    	//1. 파라미터
		String userid = request.getParameter("userid");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Aut	o-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/xml;");
		StringBuffer sb = new StringBuffer();
		//2. DB 중복체크 (admin 넘어오면 중복, 
		if(userid != null && userid.equals("admin")) {
			//1. string
			//response.getWriter().println("사용불가");
			//2.json
			//response.getWriter().println("{ \"userid\":\""+userid+"\", \"result\"
			//1.string, json, xml
			//response.getWriter().println("{ \"userid\":\""+ userid +"\" , \"result\":false}");
			sb.append("<datas>");
			sb.append("<userid>").append(userid).append("</userid>");
			sb.append("<result>").append(false).append("</result>");
			sb.append("</datas>");
			response.getWriter().println(sb.toString());
		}else {
			//response.getWriter().println("{ \"userid\":\""+ userid +"\" , \"result\":true)");
			sb.append("<datas>");
			sb.append("<userid>").append(userid).append("</userid>");
			sb.append("<result>").append(true).append("</result>");
			sb.append("</datas>");
			response.getWriter().println(sb.toString());
		}
    }


	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
