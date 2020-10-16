//Generated by 24HRS
package Servlets;

import Controllers.CustomerController;
import Models.Item_registration;
import Controllers.Item_registrationController;
import Controllers.StockController;
import Models.Customer;
import Models.Grn_details_List;
import Models.Stock;
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

@WebServlet(name = "Item_registrationServlet", urlPatterns = {"/Item_registrationServlet"})

public class Item_registrationServlet extends HttpServlet {

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
                String category = request.getParameter("category");
                String description = request.getParameter("description");
                double unit_price = Double.parseDouble(request.getParameter("unit_price"));
                Item_registration obj = new Item_registration();
                obj.setName(name);
                obj.setCategory(category);
                obj.setDescription(description);
                obj.setUnit_price(unit_price);
                obj.setDate_time(current_date);
                try {
                    Item_registrationController.getInstance().Save(obj);
                    Stock sobj = new Stock();
                    sobj.setItem_registration_id(Item_registrationController.getInstance().getLastID());
                    sobj.setOffer_presentage(0);
                    sobj.setQty(0);
                    sobj.setDate_time(current_date);
                    StockController.getInstance().Save(sobj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int item_registration_id = Integer.parseInt(request.getParameter("item_registration_id"));
                String name = request.getParameter("name");
                String category = request.getParameter("category");
                String description = request.getParameter("description");
                double unit_price = Double.parseDouble(request.getParameter("unit_price"));
                Item_registration obj = new Item_registration();
                obj.setItem_registration_id(item_registration_id);
                obj.setName(name);
                obj.setCategory(category);
                obj.setDescription(description);
                obj.setUnit_price(unit_price);
                obj.setDate_time(current_date);
                try {
                    Item_registrationController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int item_registration_id = Integer.parseInt(request.getParameter("item_registration_id"));
                Item_registration obj = new Item_registration();
                obj.setItem_registration_id(item_registration_id);
                try {
                    Item_registrationController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch_item")) {
                int item_registration_id = Integer.parseInt(request.getParameter("item_registration_id"));
                Item_registration obj = new Item_registration();
                obj.setItem_registration_id(item_registration_id);
                try {
                    Double unitPrice = Item_registrationController.getInstance().GetUnitPrice(item_registration_id);
                    response.getWriter().println(unitPrice);
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Item_registration> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = Item_registrationController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getItem_registration_id() + "_" + list.get(i).getName() + "_" + list.get(i).getCategory() + "_" + list.get(i).getDescription() + "_" + list.get(i).getUnit_price() + "_" + list.get(i).getDate_time() + "_";
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
                    para.add("Items Report");
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
                    table.addCell("Category");
                    table.addCell("Description");
                    table.addCell("Unit Price");
                    table.addCell("Date");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }

                    List<Item_registration> list = new ArrayList<>();
                    list = Item_registrationController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        table.addCell(list.get(i).getItem_registration_id() + "");
                        table.addCell(list.get(i).getName() + "");
                        table.addCell(list.get(i).getCategory() + "");
                        table.addCell(list.get(i).getDescription() + "");
                        table.addCell(list.get(i).getUnit_price() + "");
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
