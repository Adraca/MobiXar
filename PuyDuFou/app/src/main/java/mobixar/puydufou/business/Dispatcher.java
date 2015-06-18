package mobixar.puydufou.business;

import java.lang.reflect.Method;
import java.util.Hashtable;
import mobixar.puydufou.Message;

public class Dispatcher {

    private Hashtable<String, String> routingTable;

    public Dispatcher(){

        routingTable = new Hashtable<String, String>();
        routingTable.put("activities", "mobixar.puydufou.business.activity.ActivityBusiness");
    }

    public Message Route(LocalService service, Object data) {

        Message t = new Message(data, service.uri);
        String[] parts = getPartsOfUrl(service.uri, "/");
        String className = routingTable.get(parts[0]);

        t.setAskedServ(parts[1]);


        try {
            Class<?> classToInvoke = Class.forName(className);
            Method methodAsked = classToInvoke.getMethod("ctrlDispatcher", Message.class);
            t = (Message) methodAsked.invoke(classToInvoke.newInstance(), t);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    private String[] getPartsOfUrl(String url, String splitChar) {
        String[] parts = url.split(splitChar);
        return parts;
    }

}
