package mobixar.puydufou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import mobixar.puydufou.business.Dispatcher;
import mobixar.puydufou.business.LocalService;
import mobixar.puydufou.entity.ActivityEntity;
import mobixar.puydufou.entity.ScheduleEntity;


public class DetailsActivity extends Activity {

    private String textNameActivity;
    private String textStoryActivity;

    Dispatcher route = new Dispatcher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.textNameActivity = ActivityInfo.itemName;

        //Get idActivity
        Intent i = getIntent();
        Bundle b = i.getExtras();
        String idActivity = b.getString("key");

        //Afficher nom
        Message message = route.Route(LocalService.GETACTIVITIES, null);
        final List<ActivityEntity> listActivities = (ArrayList<ActivityEntity>) message.outcomingData;

        for(ActivityEntity nameEntity : listActivities) {
            if(idActivity.equals(nameEntity.getId())) {
                TextView textName = (TextView) findViewById(R.id.textNameActivity);
                textName.setText(nameEntity.getName());
            }
        }

        //Afficher rating
        /*Message messageRating = route.Route(LocalService.GETRATING, idActivity);
        String ratingActivity = (String) messageRating.outcomingData;
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingStar);
        ratingBar.setNumStars(5);
        ratingBar.setRating(Float.valueOf(ratingActivity));*/

        //Afficher story
        final ListView listStory = (ListView) findViewById(R.id.listStoryActivity);
        Message messageStory = route.Route(LocalService.GETACTIVITIES, null);
        List<ActivityEntity> storyActivity = (ArrayList<ActivityEntity>) messageStory.outcomingData;

        final ArrayList<String> arrStory = new ArrayList<String>();
        int iIncStory = 0;
        for(ActivityEntity story : storyActivity) {
            if(storyActivity.get(iIncStory).getName().equals(((TextView)findViewById(R.id.textNameActivity)).getText())) {
                arrStory.add(storyActivity.get(iIncStory).getStory());
                break;
            }
            iIncStory++;
        }

        final StableArrayAdapter adapterStory = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, arrStory);
        listStory.setAdapter(adapterStory);

        //Afficher schedule
        final ListView listSchedule = (ListView) findViewById(R.id.listScheduleActivity);
        Message messageSchedule = route.Route(LocalService.GETSCHEDULE, idActivity);
        List<ScheduleEntity> scheduleActivity = (ArrayList<ScheduleEntity>) messageSchedule.outcomingData;

        final ArrayList<String> arrSchedule = new ArrayList<String>();
        int iIncSchedule = 0;
        for(ScheduleEntity schedule : scheduleActivity) {

            arrSchedule.add(scheduleActivity.get(iIncSchedule).getTime());
            iIncSchedule++;
        }

        final StableArrayAdapter adapterSchedule = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, arrSchedule);
        listSchedule.setAdapter(adapterSchedule);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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
