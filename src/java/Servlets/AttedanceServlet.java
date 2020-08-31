package Servlets;

import Models.Attedance;
import Controllers.AttedanceController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AttedanceServlet", urlPatterns = {"/AttedanceServlet"})

public class AttedanceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int employee_id = Integer.parseInt(request.getParameter("employee_id"));
                String month = request.getParameter("month");
                double no_of_days = Double.parseDouble(request.getParameter("no_of_days"));
                double no_of_ot = Double.parseDouble(request.getParameter("no_of_ot"));
                double bonus = Double.parseDouble(request.getParameter("bonus"));
                double advance = Double.parseDouble(request.getParameter("advance"));
                Attedance obj = new Attedance();
                obj.setEmployee_id(employee_id);
                obj.setMonth(month);
                obj.setNo_of_days(no_of_days);
                obj.setNo_of_ot(no_of_ot);
                obj.setBonus(bonus);
                obj.setAdvance(advance);
                obj.setDate_time(current_date);
                try {
                    AttedanceController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int attendance_id = Integer.parseInt(request.getParameter("attendance_id"));
                int employee_id = Integer.parseInt(request.getParameter("employee_id"));
                String month = request.getParameter("month");
                double no_of_days = Double.parseDouble(request.getParameter("no_of_days"));
                double no_of_ot = Double.parseDouble(request.getParameter("no_of_ot"));
                double bonus = Double.parseDouble(request.getParameter("bonus"));
                double advance = Double.parseDouble(request.getParameter("advance"));
                Attedance obj = new Attedance();
                obj.setAttendance_id(attendance_id);
                obj.setEmployee_id(employee_id);
                obj.setMonth(month);
                obj.setNo_of_days(no_of_days);
                obj.setNo_of_ot(no_of_ot);
                obj.setBonus(bonus);
                obj.setAdvance(advance);
                obj.setDate_time(current_date);
                try {
                    AttedanceController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int attendance_id = Integer.parseInt(request.getParameter("attendance_id"));
                Attedance obj = new Attedance();
                obj.setAttendance_id(attendance_id);
                try {
                    AttedanceController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Attedance> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = AttedanceController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getAttendance_id() + "_" + list.get(i).getEmployee_id() + "_" + list.get(i).getMonth() + "_" + list.get(i).getNo_of_days() + "_" + list.get(i).getNo_of_ot() + "_" + list.get(i).getBonus() + "_" + list.get(i).getAdvance() + "_" + list.get(i).getDate_time() + "_";
                        stringList.add(s);
                    }
                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    //Error
                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
