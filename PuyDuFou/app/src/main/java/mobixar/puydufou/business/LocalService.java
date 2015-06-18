package mobixar.puydufou.business;

/**
 * Created by fra on 16/06/2015.
 */
public enum LocalService {

    GETACTIVITIES("activities/getAllActivities"),
    GETRATING("activities/getRatingActivities"),
    GETSCHEDULE("activities/getSchedules"),
    NOTEACTIVITY("activities/noteActivity"),
    ACTIVITYRANGE("activities/getActivityInRange");

    public String uri;

      LocalService(String uri){
        this.uri = uri;
    }




}
