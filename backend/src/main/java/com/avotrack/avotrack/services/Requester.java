package com.avotrack.avotrack.services;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {

    public String makeRequest(String requestUrl) {
        String response = null;
        InputStream in = null;
        HttpURLConnection conn = null;
        try {
            if (requestUrl != null) {
                URL url = new URL(requestUrl);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
//                System.out.println(response);
            }
        } catch (Exception e) {
            System.out.println(response);
            e.printStackTrace();
        } finally {
            closeConnectionsAndBuffers(in, conn);
        }
        return response;
    }

    private void closeConnectionsAndBuffers(InputStream in, HttpURLConnection conn) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            conn.disconnect();
        }
    }


    private String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line).append('\n');
        }

        return sb.toString();
    }
}
