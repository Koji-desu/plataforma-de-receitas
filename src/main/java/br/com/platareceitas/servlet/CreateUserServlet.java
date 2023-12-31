package br.com.platareceitas.servlet;
import br.com.platareceitas.DAO.UserDAO;
import br.com.platareceitas.MODEL.User;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException {

        req.getRequestDispatcher("cadastro.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String userName = request.getParameter("nome");
        String email = request.getParameter("email");
        String password = request.getParameter("senha");
        String confPassword = request.getParameter("confSenha");

        User usuario = new User(id, userName, email, password);
        UserDAO userDAO = new UserDAO();


        try{
            userDAO.createUser(usuario);
            request.getSession().setAttribute("loggedUser", email);
            response.sendRedirect("/");
        } catch(Exception x) {
            System.out.println("Error");
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }



        }


    }


