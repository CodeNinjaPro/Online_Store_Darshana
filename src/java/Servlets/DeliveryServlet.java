package Servlets;

import Models.Delivery;
import Controllers.DeliveryController;
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

@WebServlet(name = "DeliveryServlet", urlPatterns = {"/DeliveryServlet"})

public class DeliveryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
                String address = request.getParameter("address");
                String status = request.getParameter("status");
                String driver_contact = request.getParameter("driver_contact");
                Delivery obj = new Delivery();
                obj.setInvoice_id(invoice_id);
                obj.setAddress(address);
                obj.setStatus(status);
                obj.setDriver_contact(driver_contact);
                obj.setDate_time(current_date);
                try {
                    DeliveryController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
                int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
                String address = request.getParameter("address");
                String status = request.getParameter("status");
                String driver_contact = request.getParameter("driver_contact");
                Delivery obj = new Delivery();
                obj.setDelivery_id(delivery_id);
                obj.setInvoice_id(invoice_id);
                obj.setAddress(address);
                obj.setStatus(status);
                obj.setDriver_contact(driver_contact);
                obj.setDate_time(current_date);
                try {
                    DeliveryController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int delivery_id = Integer.parseInt(request.getParameter("delivery_id"));
                Delivery obj = new Delivery();
                obj.setDelivery_id(delivery_id);
                try {
                    DeliveryController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Delivery> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = DeliveryController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getDelivery_id() + "_" + list.get(i).getInvoice_id() + "_" + list.get(i).getAddress() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDriver_contact() + "_" + list.get(i).getDate_time() + "_";
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
