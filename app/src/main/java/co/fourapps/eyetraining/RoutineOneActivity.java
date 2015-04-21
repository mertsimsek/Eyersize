package co.fourapps.eyetraining;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import co.fourapps.eyetraining.Adapter.RoutineOneAdapter;
import co.fourapps.eyetraining.Model.Exercise;


public class RoutineOneActivity extends Activity {

    private ListView list;
    private RoutineOneAdapter routineOneAdapter;


    private ArrayList<Exercise> totalList;
    private Gson g;
    private SharedPreferences sp;

    private String keyString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astigmat);

        int choice = getIntent().getExtras().getInt("routine");

        switch (choice) {
            case 1:
                keyString = "routineOneTotal";
                break;
            case 2:
                keyString = "routineTwoTotal";
                break;
            case 3:
                keyString = "routineThreeTotal";
                break;
            default:
                keyString = "";
                break;
        }


        g = new Gson();
        sp = getSharedPreferences("Exercises", MODE_PRIVATE);

        Type collectionType = new TypeToken<ArrayList<Exercise>>() {
        }.getType();
        totalList = g.fromJson(sp.getString(keyString, ""), collectionType);

        list = (ListView) findViewById(R.id.astigmat_list);
        routineOneAdapter = new RoutineOneAdapter(this, totalList);
        list.setAdapter(routineOneAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!routineOneAdapter.getItem(position).isHeader()) {
                    Intent i = new Intent(RoutineOneActivity.this, ExerciseDetail.class);
                    i.putExtra("list", sp.getString(keyString, ""));
                    i.putExtra("position", position);
                    i.putExtra("routine", keyString);
                    startActivity(i);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Type collectionType = new TypeToken<ArrayList<Exercise>>() {
        }.getType();
        totalList = g.fromJson(sp.getString(keyString, ""), collectionType);
        routineOneAdapter.refreshList(totalList);
        routineOneAdapter.notifyDataSetChanged();
    }
}
