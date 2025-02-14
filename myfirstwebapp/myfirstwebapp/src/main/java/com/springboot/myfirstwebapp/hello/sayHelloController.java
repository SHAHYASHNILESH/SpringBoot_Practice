package com.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {

		return "Hello! What are you learning today?";

	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {

		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First Web App</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first web app with body");
		sb.append("</body>");
		sb.append("</html>");

		return sb.toString();

	}
	
	// say-hello-jsp => sayHello.jsp
	// /myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {

		return "sayHello";

	}
}
