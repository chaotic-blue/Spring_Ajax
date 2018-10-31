package com.company.hellospring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mailController {

	@Autowired
	JavaMailSender emailSender;

	// 메일 발송
	@RequestMapping("sendMail.do")
	public void sendMail(HttpServletResponse response) throws IOException {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("jhw211@naver.com"); //메시지 받는 주소
        message.setSubject("test Mail"); 
        message.setText("테스트 메일 입니다. ㅎㅎ");
        emailSender.send(message);
        response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<script>")
		.append("alert('메일 발송 성공');")
		.append("location.href='./getUsers.do'") 
		.append("</script>");
// getUsers.do 페이지로 넘어가서 실행
	}
}
