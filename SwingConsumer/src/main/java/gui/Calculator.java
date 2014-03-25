package gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static gui.OperationParser.parse;

public class Calculator {
    // Query parameters can be/should be part of the contract(But not the url)
    public static String calculate(int firstValue, int secondValue) throws Exception {
    // "$url$?a=$value1$&$b=$value2$"
        String url = "http://localhost:8080/calculator?a=" + firstValue  + "&b=" + secondValue;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        return parse(response.toString());
    }


}
