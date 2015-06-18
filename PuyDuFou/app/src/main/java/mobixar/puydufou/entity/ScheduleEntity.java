package mobixar.puydufou.entity;

/**
 * Created by Adrien on 18/06/2015.
 */
public class ScheduleEntity {

    private String id;
    private String idActivity;
    private String time;

    public String getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
