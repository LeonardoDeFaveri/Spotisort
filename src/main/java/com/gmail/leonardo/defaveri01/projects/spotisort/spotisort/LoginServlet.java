package com.gmail.leonardo.defaveri01.projects.spotisort.spotisort;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.*;

import com.gmail.leonardo.defaveri01.Utils;

import javax.servlet.annotation.*;

/**
 * This servlet is used to retrieve the authentication token
 * from Spotify
 */
@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        HttpURLConnection connection = null;
        try {
            StringBuilder query = new StringBuilder();
            query.append("response_type=code&");
            query.append("client_id=a7e4e80a2d4043dab69e2a8af74dbc0d&");
            query.append("redirect_uri=" + URLEncoder.encode(Utils.BASE_URL, "UTF-8") + "&");
            query.append("scope=playlist-modify-private");

            URL url = new URL(Utils.AUTH_URL + "?" + query.toString());
            
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
              connection.disconnect();
            }
        }
    }

    public void destroy() {}
}