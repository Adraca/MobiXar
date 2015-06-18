package mobixar.puydufou.business;

/**
 * Created by fra on 16/06/2015.
 */
public enum LocalService {

    GETACTIVITIES("activities/getAllActivities"),
    GETRATING("activities/getRatingActivities"),
    GETSCHEDULE("activities/getSchedules");

    public String uri;

      LocalService(String uri){
        this.uri = uri;
    }




}
