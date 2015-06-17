package mobixar.puydufou.serviceInvoker;

import android.os.AsyncTask;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class serviceProvider extends  AsyncTask<Hashtable<String, String>, Void, String> {


    public String hostAddress;
    public String port;
    public RemoteServices serviceAsked;
    public HttpMethod method;

    @Override
    protected String doInBackground(Hashtable<String, String>... params) {


        String res = "";

        try {
            if (method == HttpMethod.POST)
                res = readResponse(postRequest(params[0]));
            else if (method == HttpMethod.GET)
                res = readResponse(getRequest(params[0]));
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return res;
    }

    private HttpResponse postRequest(Hashtable<String, String> params){

        HttpClient client = new DefaultHttpClient();
        HttpResponse httpResponse = null;
        try {

            List<NameValuePair> formparams = new ArrayList<NameValuePair>();

            for (String key : params.keySet()) {
                formparams.add(new BasicNameValuePair(key, params.get(key)));
            }

            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
            String globalURL = this.hostAddress + port + serviceAsked.url;

            HttpPost httppost = new HttpPost(globalURL);
            httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httppost.setEntity(entity);

            httpResponse = client.execute(httppost);

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            client.getConnectionManager().shutdown();
        }

        return httpResponse;
    }

    private  HttpResponse getRequest(Hashtable<String, String> params){
        HttpResponse response = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(hostAddress + port + serviceAsked.url);//"http://localhost:8080/RESTfulExample/json/product/get");
            getRequest.addHeader("accept", "application/json");

            response = httpClient.execute(getRequest);
        }catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }



        return response;
    }

    private String readResponse(HttpResponse response) throws IOException{

        BufferedReader rd = new BufferedReader
                (new InputStreamReader(response.getEntity().getContent()));
        String res ="";

        String line = "";
        while((line = rd.readLine()) != null){
            res += line;
        }
        return res;
    }

}
