package mobixar.puydufou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import mobixar.puydufou.business.Dispatcher;
import mobixar.puydufou.business.LocalService;


public class MainActivity extends Activity {
    private Button btnActivity = null;
    private Button btnPlanning = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*btnActivity = (Button) findViewById(R.id.btnActivity);
        btnActivity.setOnClickListener(this);
        btnPlanning = (Button) findViewById(R.id.btnPlanning);
        btnPlanning.setOnClickListener(this);*/

        btnActivity = ((Button)this.findViewById(R.id.btnActivity));
        btnActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                callActivities();
            }
        });

        btnPlanning = ((Button)this.findViewById(R.id.btnPlanning));
        btnPlanning.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                callPlanning();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void callActivities() {
        Intent intent = new Intent(this, Activities.class);
        startActivity(intent);
    }

    public void callPlanning() {
        Intent intent = new Intent(this, Planning.class);
        startActivity(intent);
    }
}
