package mobixar.puydufou.business.activity;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;

import mobixar.puydufou.Message;
import mobixar.puydufou.entity.ActivityEntity;
import mobixar.puydufou.serviceInvoker.HttpMethod;
import mobixar.puydufou.serviceInvoker.RemoteServices;
import mobixar.puydufou.serviceInvoker.serviceProvider;

/**
 * Created by fra on 16/06/2015.
 */
public class ActivityBusiness implements ILocalBussiness{


    @Override
    public Message ctrlDispatcher(Message msg) {
        getAllActivities(msg);
       /* if(msg.getAskedServ().equals("getAllActivities")) {

        }else {
            msg.errorLog = "Unable to find the asked service";
        }*/
        return msg;
    }

    private void getAllActivities(Message message){

        Hashtable<String,String> params = new Hashtable<>();
        params.put("currentDate", "08-12-92");
        serviceProvider service = new serviceProvider();
        service.buildUrl("10.0.2.2", "8080", RemoteServices.GETALLACTIVITIES, HttpMethod.GET);
        AsyncTask<Hashtable<String, String>, Void, String> response = service.execute(params);
        try {
            String resString = response.get();
            ArrayList<ActivityEntity> arrayEntity = new ArrayList<>();
            JSONArray arr = new JSONArray(resString);

            for (int i = 0; i < arr.length(); i++) {
                arrayEntity.add(new Gson().fromJson(arr.getString(i), ActivityEntity.class));
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
