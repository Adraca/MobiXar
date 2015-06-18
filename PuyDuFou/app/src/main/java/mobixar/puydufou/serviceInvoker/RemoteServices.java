package mobixar.puydufou.serviceInvoker;

/**
 * Created by fra on 16/06/2015.
 */
public enum RemoteServices {

    GETALLACTIVITIES("PDFBussinessService/pdf/activity/all", "application/json"),
    GETRATINGACTIVITIES("PDFBussinessService/pdf/rating", "text/plain"),
    GETSCHEDULES("PDFBussinessService/pdf/schedule", "application/json"),
    NOTEACTIVITY("PDFBussinessService/pdf/activity","text/plain");

    String url;
    String dataType;

    RemoteServices(String url, String dataType){
        this.url = url;
        this.dataType = dataType;
    }
}
