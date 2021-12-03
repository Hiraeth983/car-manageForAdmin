package demo;

import implement.StationDaoImpl;
import model.Station;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getStationById")
public class getStationById extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String stationId = request.getParameter("stationId");
        StationDaoImpl sdi = new StationDaoImpl();
        try {
            Station station = null;
            station = sdi.selectStationById(stationId);
            if (station != null) {
                response.getWriter().print(JSONArray.fromObject(station));
            } else {
                response.getWriter().print("暂无数据");
            }

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

