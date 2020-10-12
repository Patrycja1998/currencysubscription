package zmijewska.p.currencysubscription;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;



@Configuration
public class Subscription {

    private static HttpURLConnection httpURLConnection;



    public String Connection(String baseCurrency) throws JSONException {

        BufferedReader bufferedReader;
        String line;
        StringBuffer responseContent = new StringBuffer();


        try {
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + baseCurrency);
            httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            int status = httpURLConnection.getResponseCode();

            if (status > 299) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                while ((line = bufferedReader.readLine()) != null) {
                    responseContent.append(line);
                }

                bufferedReader.close();
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                while ((line = bufferedReader.readLine()) != null) {
                    responseContent.append(line);
                }

                bufferedReader.close();
            }

            parse(responseContent.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        } finally {
            httpURLConnection.disconnect();
        }

        return parse(responseContent.toString());

    }

    public String parse(String responseBody) throws JSONException {

        JSONObject object = new JSONObject(responseBody);
        String baseCurrency = object.getString("base");
        String rates = object.getString("rates");
        LocalDate date = LocalDate.parse(object.getString("date"));


        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Date: ");
        stringBuilder.append(date);
        stringBuilder.append("\n");
        stringBuilder.append("Base currency: ");
        stringBuilder.append(baseCurrency);
        stringBuilder.append("\n");
        stringBuilder.append("Currency rates: ");
        stringBuilder.append(rates);

        return stringBuilder.toString();

    }


}