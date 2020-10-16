//Generated by 24HRS
package Servlets;

import Models.Customer;
import Controllers.CustomerController;
import Controllers.InvoiceController;
import Models.Invoice;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
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

@WebServlet(name = "CustomerServlet", urlPatterns = {"/CustomerServlet"})

public class CustomerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String contact_no = request.getParameter("contact_no");
                String email = request.getParameter("email");
                Customer obj = new Customer();
                obj.setName(name);
                obj.setAddress(address);
                obj.setContact_no(contact_no);
                obj.setEmail(email);
                obj.setDate_time(current_date);
                try {
                    CustomerController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                String contact_no = request.getParameter("contact_no");
                String email = request.getParameter("email");
                Customer obj = new Customer();
                obj.setCustomer_id(customer_id);
                obj.setName(name);
                obj.setAddress(address);
                obj.setContact_no(contact_no);
                obj.setEmail(email);
                obj.setDate_time(current_date);
                try {
                    CustomerController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                Customer obj = new Customer();
                obj.setCustomer_id(customer_id);
                try {
                    CustomerController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Customer> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = CustomerController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getCustomer_id() + "_" + list.get(i).getName() + "_" + list.get(i).getAddress() + "_" + list.get(i).getContact_no() + "_" + list.get(i).getEmail() + "_" + list.get(i).getDate_time() + "_";
                        stringList.add(s);
                    }
                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    //Error
                }

            } else if (action.equals("report")) {
                try {
                    String file = "C:/xampp/htdocs/Reports/report.pdf";

                    Document doc = new Document();

                    PdfWriter.getInstance(doc, new FileOutputStream(file));
                    doc.open();

                    Paragraph topic = new Paragraph();
                    topic.add("Arunonanda Supermarket");
                    topic.setAlignment(Element.ALIGN_LEFT);

                    Paragraph d = new Paragraph();
                    d.add(current_date);
                    d.setAlignment(Element.ALIGN_LEFT);

                    Paragraph para = new Paragraph();
                    para.add("Customer Report");
                    para.setAlignment(Element.ALIGN_CENTER);

                    doc.add(topic);
                    doc.add(d);
                    doc.add(para);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);

                    float x[] = {5, 15, 15, 15, 15, 15};

                    PdfPTable table = new PdfPTable(x);
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                    table.addCell("ID");
                    table.addCell("Name");
                    table.addCell("Address");
                    table.addCell("Contact Number");
                    table.addCell("Email");
                    table.addCell("Date");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }

                    List<Customer> list = new ArrayList<>();
                    list = CustomerController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        table.addCell(list.get(i).getCustomer_id() + "");
                        table.addCell(list.get(i).getName() + "");
                        table.addCell(list.get(i).getAddress() + "");
                        table.addCell(list.get(i).getContact_no() + "");
                        table.addCell(list.get(i).getEmail() + "");
                        table.addCell(list.get(i).getDate_time() + "");

                    }

                    doc.add(table);

                    doc.close();
                    response.getWriter().println("Report Created!");
                } catch (Exception ex) {
                    response.getWriter().println(ex);
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
