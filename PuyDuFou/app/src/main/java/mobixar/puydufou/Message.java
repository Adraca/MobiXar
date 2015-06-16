package mobixar.puydufou;

/**
 * Created by fra on 16/06/2015.
 */
public class Message {

    private Object incomingData;
    private String askedService;
    public String statusCode;
    public String errorLog;


    public Message(Object data,String askedService){
        this.incomingData = data;
        this.askedService = askedService;
    }


    public Object getData(){
        return this.incomingData;
    }

    public String getAskedServ(){
        return this.askedService;
    }

    public void setAskedServ(String serviceName){
        askedService = serviceName;
    }

}
