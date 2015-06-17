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


public class Activities extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        /*String[] tabActivities = new String[]{
                "Le signe du Triomphe",
                "Les Vikings",
                "Le Bal des Oiseaux Fantômes"
        };

        final ArrayAdapter<String> adapterActivities = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tabActivities);
        ListView list = (ListView) findViewById(R.id.listActivities);
        list.setAdapter(adapterActivities);*/

        final ListView listView = (ListView) findViewById(R.id.listActivities);

        new Dispatcher().Route(LocalService.GETACTIVITIES, null);
        String[] values = new String[]{
                "Le signe du Triomphe",
                "Les Vikings",
                "Le Bal des Oiseaux Fantomes",
                "Le Secret de la Lance",
                "Mousquetaire de Richelieu",
                "Les Orgues de Feu",
                "Les Chevaliers de la Table Ronde",
                "L'Odysee du Puy du Fou",
                "Les Automates Musiciens",
                "Les Musiciens Traditionnels",
                "Les Grandes Eaux",
                "La Legande de Martin"
        };

        final ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                ActivityInfo.itemName = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(1000).alpha(1000).withEndAction(new Runnable() {

                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        view.setAlpha(1);
                        callActivityDetails();
                    }
                });
            }

        });
    }

    public void callActivityDetails() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
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
