package com.desmond.servlet;

import com.desmond.crud.UserService;
import com.desmond.entity.User;
import com.google.common.collect.Lists;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vadym on 15.11.2014.
 */
public class HTTPServise extends HttpServlet {


    private UserService service = new UserService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param = req.getParameter("button_id");
        String userId = req.getParameter("userId");

        //For create user
        String name = req.getParameter("inputName");
        String age = req.getParameter("inputAge");
        String isAdmin = req.getParameter("inputAdm");

        // For search
        String searchName = req.getParameter("searchName");

        switch (param){
            case "Show me all Users from BD":
                req.getSession().setAttribute("servletResponse", getUsers());
                break;

            case "reset":
                req.getSession().setAttribute("servletResponse", getUsers());
                break;

            case "hide":
                req.getSession().setAttribute("servletResponse", null);
                req.getSession().getId();
                break;

            case "delete":
                req.getSession().setAttribute("servletResponse", deleteFromBd(userId));
                break;

            case "edit":
                /*Nothing*/
                break;

            case "Create new user":
                req.getSession().setAttribute("servletResponse", createNewUser(name, age, isAdmin));
                break;

            case "Search":
                req.getSession().setAttribute("servletResponse", searchUsers(searchName));
                break;



            default:
                System.err.println("I don't know this 'param' xD");
                break;
        }

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }


    private List<User> deleteFromBd(String id){
        try {
            service.delete(Long.parseLong(id));
        } catch (NumberFormatException e) {
            System.err.println("Something wrong");
            System.exit(0);
        }
        List<User> users = Lists.newArrayList();
        for (User o : service.getAll()) {
            users.add(o);
        }
        return users;
    }

    private List<User> createNewUser(String name, String age, String isAdmin)
    {

        try {
            if(!findForCreate(name, age)){
                 service.add(new User(name, Integer.parseInt(age), isAdmin != null));
            } else {
                System.err.println("This user have already in BD or Incorrect type");
            }
        } catch (Exception ignore) {/*NOP*/}
        List<User> users = Lists.newArrayList();
        for (User o : service.getAll()) {
            users.add(o);
        }
        return users;
    }

    private boolean findForCreate(String name, String age)
    {
        for (User o : service.getAll()) {
            if(o.getName().equals(name) && o.getAge() == Integer.parseInt(age))
                return true;
        }
        return false;
    }

    private List<User> searchUsers(String searchName){
        List<User> users = Lists.newArrayList();
        for (User o : service.getAll()) {
            if(o.getName().equals(searchName)) {
                users.add(o);
            }
        }
        return users;
    }


    private List<User> getUsers(){

        List<User> users = Lists.newArrayList();
        for (User o : service.getAll()) {
            users.add(o);
        }
        return users;
    }
}
