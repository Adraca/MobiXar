package mobixar.puydufou.serviceInvoker;

/**
 * Created by fra on 16/06/2015.
 */
public enum RemoteServices {

    GETALLACTIVITIES("PDFBussinessService/pdf/activity");

    String url;

    RemoteServices(String url){
        this.url = url;
    }
}