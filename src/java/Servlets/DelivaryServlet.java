//Generated by 24HRS
package Servlets;

import Controllers.CustomerController;
import Models.Delivary;
import Controllers.DelivaryController;
import Controllers.InvoiceController;
import Controllers.SupplierController;
import Models.Customer;
import Models.Supplier;
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

@WebServlet(name = "DelivaryServlet", urlPatterns = {"/DelivaryServlet"})

public class DelivaryServlet extends HttpServlet {

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
                int emp_id = Integer.parseInt(request.getParameter("emp_id"));
                String address = request.getParameter("address");
                String cus_contact = request.getParameter("cus_contact");
                String status = request.getParameter("status");
                Delivary obj = new Delivary();
                obj.setInvoice_id(invoice_id);
                obj.setEmp_id(emp_id);
                obj.setAddress(address);
                obj.setCus_contact(cus_contact);
                obj.setStatus(status);
                obj.setDate_time(current_date);
                try {
                    DelivaryController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int delivary_id = Integer.parseInt(request.getParameter("delivary_id"));
                int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
                int emp_id = Integer.parseInt(request.getParameter("emp_id"));
                String address = request.getParameter("address");
                String cus_contact = request.getParameter("cus_contact");
                String status = request.getParameter("status");
                Delivary obj = new Delivary();
                obj.setDelivary_id(delivary_id);
                obj.setInvoice_id(invoice_id);
                obj.setEmp_id(emp_id);
                obj.setAddress(address);
                obj.setCus_contact(cus_contact);
                obj.setStatus(status);
                obj.setDate_time(current_date);
                try {
                    DelivaryController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int delivary_id = Integer.parseInt(request.getParameter("delivary_id"));
                Delivary obj = new Delivary();
                obj.setDelivary_id(delivary_id);
                try {
                    DelivaryController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Delivary> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = DelivaryController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getDelivary_id() + "_" + list.get(i).getInvoice_id() + "_" + list.get(i).getEmp_id() + "_" + list.get(i).getAddress() + "_" + list.get(i).getCus_contact() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
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
                    para.add("Delivery Report");
                    para.setAlignment(Element.ALIGN_CENTER);

                    doc.add(topic);
                    doc.add(d);
                    doc.add(para);
                    doc.add(Chunk.NEWLINE);
                    doc.add(Chunk.NEWLINE);

                    float x[] = {5, 15, 15, 15, 15, 15, 15};

                    PdfPTable table = new PdfPTable(x);
                    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

                    table.addCell("ID");
                    table.addCell("Invoice ID");
                    table.addCell("Driver ID");
                    table.addCell("Address");
                    table.addCell("Contact");
                    table.addCell("Status");
                    table.addCell("Date");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }

                    List<Delivary> list = new ArrayList<>();
                    list = DelivaryController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        table.addCell(list.get(i).getDelivary_id() + "");
                        table.addCell(list.get(i).getInvoice_id() + "");
                        table.addCell(list.get(i).getEmp_id() + "");
                        table.addCell(list.get(i).getAddress() + "");
                        table.addCell(list.get(i).getCus_contact() + "");
                        table.addCell(list.get(i).getStatus() + "");
                        table.addCell(list.get(i).getDate_time() + "");

                    }

                    doc.add(table);

                    doc.close();
                    response.getWriter().println("Report Created!");
                } catch (Exception ex) {
                    response.getWriter().println(ex);
                    //Error
                }

            } else if (action.equals("serch_customer_details")) {

                try {
                    int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
                    Customer temp = CustomerController.getInstance().Search(InvoiceController.getInstance().getCustomerID(invoice_id));
                    String b = temp.getContact_no() + "," + temp.getAddress();
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    // Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
