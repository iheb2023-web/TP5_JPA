package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ISportDao;
import dao.SportDaoImpl;
import metier.entities.Sport;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ISportDao metier;

    @Override
    public void init() throws ServletException {
        metier = new SportDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String path=request.getServletPath();
        if (path.equals("/index.do"))
        {
            request.getRequestDispatcher("sports.jsp").forward(request,response);
        }
        else if (path.equals("/chercher.do"))
        {
            String motCle=request.getParameter("motCle");
            List<Sport> prods = metier.sportParMC(motCle);
            request.setAttribute("sports", prods);
            request.getRequestDispatcher("sports.jsp").forward(request,response);
        }
        else if (path.equals("/saisie.do") )
        {
            request.getRequestDispatcher("saisieSport.jsp").forward(request,response);
        }
        else if (path.equals("/save.do") && request.getMethod().equals("POST"))
        {
            String nom=request.getParameter("nom");
            String description = request.getParameter("description");
            String dateFondationStr = request.getParameter("date_fondation");
            Sport p = metier.save(new Sport(nom, description, dateFondationStr));
            request.setAttribute("sport", p);
            request.getRequestDispatcher("confirmation.jsp").forward(request,response);
        }
        else if (path.equals("/supprimer.do"))
        {
            Long id= Long.parseLong(request.getParameter("id"));
            metier.deleteSport(id);
            response.sendRedirect("chercher.do?motCle=");
        }
        else if (path.equals("/editer.do") )
        {
            Long id= Long.parseLong(request.getParameter("id"));
            Sport p = metier.getSport(id);
            request.setAttribute("sport", p);
            request.getRequestDispatcher("editerSport.jsp").forward(request,response);
        }
        else if (path.equals("/update.do") )
        {
            Long id = Long.parseLong(request.getParameter("id"));
            String nom=request.getParameter("nom");
            String description = request.getParameter("description");
            String dateFondationStr = request.getParameter("date_fondation");
            Sport p = new Sport();
            p.setIdSport(id);
            p.setNomSport(nom);
            p.setDescription(description);
            p.setDateFondation(dateFondationStr);
            metier.updateSport(p);
            request.setAttribute("sport", p);
            request.getRequestDispatcher("confirmation.jsp").forward(request,response);
        }
        else
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
