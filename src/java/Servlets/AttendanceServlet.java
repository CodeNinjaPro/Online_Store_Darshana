//Generated by 24HRS
package Servlets;

import Models.Attendance;
import Controllers.AttendanceController;
import Controllers.DelivaryController;
import Models.Delivary;
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

@WebServlet(name = "AttendanceServlet", urlPatterns = {"/AttendanceServlet"})

public class AttendanceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int emp_id = Integer.parseInt(request.getParameter("emp_id"));
                String month = request.getParameter("month");
                double no_of_days = Double.parseDouble(request.getParameter("no_of_days"));
                double no_of_ot = Double.parseDouble(request.getParameter("no_of_ot"));
                double advance = Double.parseDouble(request.getParameter("advance"));
                Attendance obj = new Attendance();
                obj.setEmp_id(emp_id);
                obj.setMonth(month);
                obj.setNo_of_days(no_of_days);
                obj.setNo_of_ot(no_of_ot);
                obj.setAdvance(advance);
                obj.setDate_time(current_date);
                try {
                    AttendanceController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int attendance_id = Integer.parseInt(request.getParameter("attendance_id"));
                int emp_id = Integer.parseInt(request.getParameter("emp_id"));
                String month = request.getParameter("month");
                double no_of_days = Double.parseDouble(request.getParameter("no_of_days"));
                double no_of_ot = Double.parseDouble(request.getParameter("no_of_ot"));
                double advance = Double.parseDouble(request.getParameter("advance"));
                Attendance obj = new Attendance();
                obj.setAttendance_id(attendance_id);
                obj.setEmp_id(emp_id);
                obj.setMonth(month);
                obj.setNo_of_days(no_of_days);
                obj.setNo_of_ot(no_of_ot);
                obj.setAdvance(advance);
                obj.setDate_time(current_date);
                try {
                    AttendanceController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int attendance_id = Integer.parseInt(request.getParameter("attendance_id"));
                Attendance obj = new Attendance();
                obj.setAttendance_id(attendance_id);
                try {
                    AttendanceController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Attendance> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = AttendanceController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getAttendance_id() + "_" + list.get(i).getEmp_id() + "_" + list.get(i).getMonth() + "_" + list.get(i).getNo_of_days() + "_" + list.get(i).getNo_of_ot() + "_" + list.get(i).getAdvance() + "_" + list.get(i).getDate_time() + "_";
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
                    para.add("Attendance Report");
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
                    table.addCell("Employee ID");
                    table.addCell("Month");
                    table.addCell("No of Days");
                    table.addCell("No of OT");
                    table.addCell("Advance");
                    table.addCell("Date");

                    table.setHeaderRows(1);

                    PdfPCell[] cells = table.getRow(0).getCells();
                    for (int i = 0; i < cells.length; i++) {
                        cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }

                    List<Attendance> list = new ArrayList<>();
                    list = AttendanceController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        table.addCell(list.get(i).getAttendance_id() + "");
                        table.addCell(list.get(i).getEmp_id() + "");
                        table.addCell(list.get(i).getMonth() + "");
                        table.addCell(list.get(i).getNo_of_days() + "");
                        table.addCell(list.get(i).getNo_of_ot() + "");
                        table.addCell(list.get(i).getAdvance() + "");
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