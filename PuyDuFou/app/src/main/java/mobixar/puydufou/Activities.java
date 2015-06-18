package mobixar.puydufou;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mobixar.puydufou.business.Dispatcher;
import mobixar.puydufou.business.LocalService;
import mobixar.puydufou.business.activity.ActivityBusiness;
import mobixar.puydufou.entity.ActivityEntity;


public class Activities extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        final ListView listView = (ListView) findViewById(R.id.listActivities);

        Dispatcher route = new Dispatcher();
        Message message = route.Route(LocalService.GETACTIVITIES, null);
        final List<ActivityEntity> listActivities = (ArrayList<ActivityEntity>) message.outcomingData;

        final ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        for(ActivityEntity nameActivity : listActivities) {
            list.add(listActivities.get(i).getName());
            i++;
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                String activityChoosen = (String) parent.getItemAtPosition(position);
                for(ActivityEntity a : listActivities) {
                    if(a.getName().equals(activityChoosen)) {
                        callActivityDetails(a.getId());

                    }
                }
                view.animate().setDuration(1000).alpha(1000).withEndAction(new Runnable() {

                    @Override
                    public void run() {
                        //adapter.notifyDataSetChanged();
                       // view.setAlpha(1);
                       // callActivityDetails();
                    }
                });
            }

        });
    }

    public void callActivityDetails(String idActivity) {
        Intent intentIdActivity = new Intent(Activities.this, DetailsActivity.class);
        intentIdActivity.putExtra("key", idActivity);

        startActivity(intentIdActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activities, menu);
        return true;
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
