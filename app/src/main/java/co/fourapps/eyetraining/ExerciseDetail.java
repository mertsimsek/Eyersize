package co.fourapps.eyetraining;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import co.fourapps.eyetraining.Model.Exercise;


public class ExerciseDetail extends Activity {

    private ImageView icon;
    private TextView title, desc;
    private Button done;
    private ArrayList<Exercise> list;
    private int position;
    private Gson g;
    private ViewFlipper flipper;
    private int[] imgIds;

    private Runnable runnable;

    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        g = new Gson();

        sp = getSharedPreferences("Exercises", MODE_PRIVATE);
        edit = sp.edit();

        Type collectionType = new TypeToken<ArrayList<Exercise>>() {
        }.getType();

        flipper = (ViewFlipper) findViewById(R.id.detail_icon);
        title = (TextView) findViewById(R.id.detail_title);
        desc = (TextView) findViewById(R.id.detail_desc);
        done = (Button) findViewById(R.id.done_button);

        position = getIntent().getExtras().getInt("position");
        list = g.fromJson(getIntent().getExtras().getString("list"), collectionType);

        title.setText(list.get(position).getName());
        desc.setText(list.get(position).getDesc());

        imgIds = list.get(position).getImgIds();
        ImageView temp;

        for (int i = 0; i < imgIds.length; i++) {
            temp = new ImageView(ExerciseDetail.this);
            temp.setImageResource(imgIds[i]);
            flipper.addView(temp);
        }

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setDone(true);

                edit.putString(getIntent().getExtras().getString("routine"), g.toJson(list));
                edit.commit();
                finish();
            }
        });
    }

    private void changeImagesPeriodically() {
        runnable = new Runnable() {
            int i = 0;

            public void run() {
                flipper.setDisplayedChild((++i) % imgIds.length);
                flipper.postDelayed(this, 3000);
            }
        };
        flipper.postDelayed(runnable, 3000);
    }

    private void stopSwitching() {
        try {
            flipper.removeCallbacks(runnable);
        } catch (Exception e) {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (imgIds.length != 0)
            changeImagesPeriodically();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (imgIds.length != 0)
            stopSwitching();
    }
}
