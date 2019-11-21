package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bag")
public class BagServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Bag myBag = new Bag();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.append("<!DOCTYPE html>").append("<html>").append("<head>").append("<title>Form input</title>")
				.append("</head>").append("<body>").append("<form action=\"bag\" method=\"post\">")
				.append("Enter your ref: ").append("<input type=\"text\" id=\"ref\" name=\"ref\" />")
				.append("Enter your qty: ").append("<input type=\"text\" id=\"qty\" name=\"qty\" />")
				.append("<input type=\"submit\" value=\"Submit\" />").append("</form>").append("</body>")
				.append("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		PrintWriter out = response.getWriter();
		String title = "Resultat";
		String ref = request.getParameter("ref");
		String qty = request.getParameter("qty");
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		
		response.setContentType("text/html");	

		if (ref.isEmpty() || qty.isEmpty() || ref == null || qty == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			title = "Erreur sur la saisie de formulaire";
			out.println("<h1>Erreur sur la saisie de formulaire</h1>");
		}

		else {
			out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
					+ "<body bgcolor = \"#f0f0f0\">\n");
			out.println("<h1 align = \"center\">" + title + "</h1>\n" + "<ul>\n" + "  <li><b>Ref rence</b>: " + ref
					+ "\n" + "  <li><b>Quantite</b>: " + qty + "\n" + "</ul>\n" + "</body>" + "</html>");
		}
	}

}