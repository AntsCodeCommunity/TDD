package org.example;

import java.io.IOException;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

/**
 * @author antscode
 */
@Log4j2
@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student("AntsCode", "man");
		Gson gson = new Gson();
		response.setHeader("Content-Type", "application/json");
		response.getWriter().print(gson.toJson(student));
	}

}
