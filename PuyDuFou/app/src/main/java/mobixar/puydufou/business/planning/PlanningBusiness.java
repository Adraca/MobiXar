package mobixar.puydufou.business.planning;

import mobixar.puydufou.Message;
import mobixar.puydufou.Planning;
import mobixar.puydufou.business.ILocalBussiness;

/**
 * Created by fra on 19/06/2015.
 */
public class PlanningBusiness implements ILocalBussiness {

    private static Planning currentPlanning;

    private  PlanningBusiness(){}

    @Override
    public Message ctrlDispatcher(Message trame) {

        if(trame.getAskedServ() == "getPlanning"){
            //...
        }
        return null;
    }

    public static Planning getPlanning(){
        if(currentPlanning.equals(null)){
            currentPlanning = new Planning();
        }
        return currentPlanning;
    }
}
