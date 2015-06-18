package mobixar.puydufou;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.Time;
import java.util.Hashtable;

import mobixar.puydufou.business.Dispatcher;
import mobixar.puydufou.business.LocalService;


public class Planning extends Activity {

    private final Dispatcher router = new Dispatcher();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_planning, menu);

       fillActivityList("8", "17");
        return true;
    }

    private void fillActivityList(String h1, String h2) {
        Hashtable<String, String> params = new Hashtable<>();
        params.put("beguin", h1);
        params.put("end", h2);

        router.Route(LocalService.ACTIVITYRANGE, params);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
