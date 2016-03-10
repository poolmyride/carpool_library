package sample.carpool.delvelogic.poolmyridesample.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import carpool.delvelogic.library.api.CarpoolRequest;
import sample.carpool.delvelogic.poolmyridesample.Adapter.MenuAdapter;
import sample.carpool.delvelogic.poolmyridesample.R;

public class MainActivity extends AppCompatActivity {

    private ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarpoolRequest.init(this);
        mainListView = (ListView) findViewById(R.id.mainListView);
        String[] fetchCarpool = getResources().getStringArray(R.array.fetch_carpool);

        mainListView.setAdapter(new MenuAdapter(this, fetchCarpool));

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                switch (position) {

                    case 0:
                        i = new Intent(MainActivity.this, LatestCarpoolActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(MainActivity.this, LocationCarpoolActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(MainActivity.this, RouteCarpoolActivity.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(MainActivity.this, RealTimeUserCarpoolActivity.class);
                        startActivity(i);
                        break;

                }

            }
        });

    }
}
