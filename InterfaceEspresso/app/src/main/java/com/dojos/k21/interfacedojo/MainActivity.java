package com.dojos.k21.interfacedojo;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.lula.myapplication.MESSAGE";
    private static final String CALCULADORA_URL = "http://172.18.0.1:8081/comissao";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) throws JSONException {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String valorVendaDigitado = editText.getText().toString();
        //String jsonValorComsissaoCalculado = executePost(CALCULADORA_URL, "valorVenda=" + valorVendaDigitado);
        //JSONObject jObject = new JSONObject(jsonValorComsissaoCalculado);
        //String valorComissaoCalculado = jObject.getString("valorComissao");

        //Deixei fixo para nao precisar da API de pe
        String valorComissaoCalculado = "100";

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String message = String.format("Para uma venda de %s o valor da comissão deve ser %s", formatter.format(Double.parseDouble(valorVendaDigitado)), formatter.format(Double.parseDouble(valorComissaoCalculado)));
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
