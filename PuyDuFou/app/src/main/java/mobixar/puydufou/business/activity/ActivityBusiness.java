package mobixar.puydufou.business.activity;

import java.util.HashMap;
import java.util.Hashtable;

import mobixar.puydufou.Message;
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
        service.execute(params);
    }
}
