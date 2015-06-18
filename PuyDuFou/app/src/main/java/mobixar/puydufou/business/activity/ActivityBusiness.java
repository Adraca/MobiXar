package mobixar.puydufou.business.activity;

import android.os.AsyncTask;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ExecutionException;

import mobixar.puydufou.Message;
import mobixar.puydufou.entity.ActivityEntity;
import mobixar.puydufou.entity.ScheduleEntity;
import mobixar.puydufou.serviceInvoker.HttpMethod;
import mobixar.puydufou.serviceInvoker.RemoteServices;
import mobixar.puydufou.serviceInvoker.serviceProvider;

/**
 * Created by fra on 16/06/2015.
 */
public class ActivityBusiness implements ILocalBussiness{


    @Override
    public Message ctrlDispatcher(Message msg) {
       if(msg.getAskedServ().equals("getAllActivities")) {
           msg = getAllActivities(msg);
        }else if(msg.getAskedServ().equals("getRatingActivities")) {
           msg = getRatingActivities(msg);
       }else if(msg.getAskedServ().equals("getSchedules")) {
           msg = getSchedules(msg);
       }else if(msg.getAskedServ().equals("noteActivity")){
            msg = setNoteToActivity(msg);
       }
       else{
            msg.errorLog = "Unable to find the asked service";
        }
        return msg;
    }

    private Message setNoteToActivity(Message msg) {

        Hashtable<String, String> params = (Hashtable) msg.getData();
        serviceProvider service = new serviceProvider();
        service.buildUrl("10.0.2.2", "8080", RemoteServices.NOTEACTIVITY, HttpMethod.GET);
        AsyncTask<Hashtable<String, String>, Void, String> response = service.execute(params);
        ArrayList<ScheduleEntity> arrEntity = new ArrayList<>();

        return  msg;
    }

    private Message getSchedules(Message message) {

        Hashtable<String,String> params = new Hashtable<>();
        params.put("idActivity", (String) message.getData());

        serviceProvider service = new serviceProvider();
        service.buildUrl("10.0.2.2", "8080", RemoteServices.GETSCHEDULES, HttpMethod.GET);
        AsyncTask<Hashtable<String, String>, Void, String> response = service.execute(params);
        ArrayList<ScheduleEntity> arrEntity = new ArrayList<>();

        try {
            String resString = response.get();
            JSONArray arr = new JSONArray(resString);

            for (int i = 0; i < arr.length(); i++) {
                arrEntity.add(new Gson().fromJson(arr.getString(i), ScheduleEntity.class));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        message.outcomingData = arrEntity;
        return  message;
    }

    public Message getAllActivities(Message message){

        Hashtable<String,String> params = new Hashtable<>();
        serviceProvider service = new serviceProvider();
        service.buildUrl("10.0.2.2", "8080", RemoteServices.GETALLACTIVITIES, HttpMethod.GET);
        AsyncTask<Hashtable<String, String>, Void, String> response = service.execute(params);
        ArrayList<ActivityEntity> arrayEntity = new ArrayList<>();
        try {
            String resString = response.get();
            JSONArray arr = new JSONArray(resString);

            for (int i = 0; i < arr.length(); i++) {
                arrayEntity.add(new Gson().fromJson(arr.getString(i), ActivityEntity.class));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        message.outcomingData = arrayEntity;
        return message;
    }

    private Message rankActivity(Message message){


        return message;
    }

    public Message getRatingActivities(Message message) {
        Hashtable<String,String> params = new Hashtable<>();
        params.put("idActivity", (String) message.getData());
        serviceProvider service = new serviceProvider();
        service.buildUrl("10.0.2.2", "8080", RemoteServices.GETRATINGACTIVITIES, HttpMethod.GET);
        AsyncTask<Hashtable<String, String>, Void, String> response = service.execute(params);
        String rate = "";
        try {
           rate = response.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        message.outcomingData = rate;
        return message;
    }
}
