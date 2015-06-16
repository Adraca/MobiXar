package mobixar.puydufou.business.activity;

import mobixar.puydufou.Message;

/**
 * Created by fra on 16/06/2015.
 */
public class ActivityBusiness implements ILocalBussiness{


    @Override
    public Message ctrlDispatcher(Message msg) {

        if(msg.getAskedServ().equals("getAllActivities")) {
            getAllActivities();
        }else {
            msg.errorLog = "Unable to find the asked service";
        }
        return msg;
    }

    private void getAllActivities(){
        System.out.println();
    }
}
