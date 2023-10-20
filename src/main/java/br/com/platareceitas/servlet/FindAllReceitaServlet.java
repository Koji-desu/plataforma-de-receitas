package br.com.platareceitas.servlet;

import br.com.platareceitas.DAO.ReceitaDAO;
import br.com.platareceitas.MODEL.Receita;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-receitas")
public class FindAllReceitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Receita> receitas = new ReceitaDAO().findAllReceitas();

        req.setAttribute("receitas", receitas);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }

}