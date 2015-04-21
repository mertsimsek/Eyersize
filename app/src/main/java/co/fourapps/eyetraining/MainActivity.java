package co.fourapps.eyetraining;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import co.fourapps.eyetraining.Model.Exercise;


public class MainActivity extends Activity {

    private Button routineTwoButton, routineThreeButton, routineOneButton;
    private ProgressDialog pd;
    private List<Exercise> day16R1, day712R1, day1318R1, day1924R1, day2530R1, day3160R1, totalListR1, day16R2, day712R2, day1318R2, day1924R2, day2530R2, day3160R2, totalListR2, day16R3, day712R3, day1318R3, day1924R3, day2530R3, day3160R3, totalListR3;
    private Gson g;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        g = new Gson();
        sp = getSharedPreferences("Exercises", MODE_PRIVATE);
        edit = sp.edit();

        boolean isNotFirst = sp.contains("routineOneTotal");

        if (isNotFirst) {
            Type collectionType = new TypeToken<ArrayList<Exercise>>() {
            }.getType();
            totalListR1 = g.fromJson(sp.getString("routineOneTotal", ""), collectionType);
            totalListR2 = g.fromJson(sp.getString("routineTwoTotal", ""), collectionType);
            totalListR3 = g.fromJson(sp.getString("routineThreeTotal", ""), collectionType);
        } else {
            day16R1 = new ArrayList<Exercise>();
            day712R1 = new ArrayList<Exercise>();
            day1318R1 = new ArrayList<Exercise>();
            day1924R1 = new ArrayList<Exercise>();
            day2530R1 = new ArrayList<Exercise>();
            day3160R1 = new ArrayList<Exercise>();

            day16R2 = new ArrayList<Exercise>();
            day712R2 = new ArrayList<Exercise>();
            day1318R2 = new ArrayList<Exercise>();
            day1924R2 = new ArrayList<Exercise>();
            day2530R2 = new ArrayList<Exercise>();
            day3160R2 = new ArrayList<Exercise>();

            day16R3 = new ArrayList<Exercise>();
            day712R3 = new ArrayList<Exercise>();
            day1318R3 = new ArrayList<Exercise>();
            day1924R3 = new ArrayList<Exercise>();
            day2530R3 = new ArrayList<Exercise>();
            day3160R3 = new ArrayList<Exercise>();

            pd = new ProgressDialog(this);
            pd.setMessage("Loading...");
            pd.setCancelable(false);

            new CreateExercises().execute();
        }


        routineTwoButton = (Button) findViewById(R.id.routine_two);
        routineThreeButton = (Button) findViewById(R.id.routine_three);
        routineOneButton = (Button) findViewById(R.id.routine_one);


        routineTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RoutineOneActivity.class);
                i.putExtra("routine", 2);
                startActivity(i);
            }
        });

        routineThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RoutineOneActivity.class);
                i.putExtra("routine", 3);
                startActivity(i);
            }
        });

        routineOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, RoutineOneActivity.class);
                i.putExtra("routine", 1);
                startActivity(i);

            }
        });


    }

    private void closeProgress() {
        pd.dismiss();
    }

    private class CreateExercises extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            String[] exercisesR116 = getResources().getStringArray(R.array.routine11);
            String[] exercisesR1712 = getResources().getStringArray(R.array.routine12);
            String[] exercisesR11318 = getResources().getStringArray(R.array.routine13);
            String[] exercisesR11924 = getResources().getStringArray(R.array.routine14);
            String[] exercisesR12530 = getResources().getStringArray(R.array.routine15);
            String[] exercisesR13160 = getResources().getStringArray(R.array.routine16);


            String[] exercisesR216 = getResources().getStringArray(R.array.routine21);
            String[] exercisesR2712 = getResources().getStringArray(R.array.routine22);
            String[] exercisesR21318 = getResources().getStringArray(R.array.routine23);
            String[] exercisesR21924 = getResources().getStringArray(R.array.routine24);
            String[] exercisesR22530 = getResources().getStringArray(R.array.routine25);
            String[] exercisesR23160 = getResources().getStringArray(R.array.routine26);

            String[] exercisesR316 = getResources().getStringArray(R.array.routine31);
            String[] exercisesR3712 = getResources().getStringArray(R.array.routine32);
            String[] exercisesR31318 = getResources().getStringArray(R.array.routine33);
            String[] exercisesR31924 = getResources().getStringArray(R.array.routine34);
            String[] exercisesR32530 = getResources().getStringArray(R.array.routine35);
            String[] exercisesR33160 = getResources().getStringArray(R.array.routine36);

            for (String line : exercisesR116) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day16R1.add(temp);

            }
            for (String line : exercisesR1712) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day712R1.add(temp);

            }
            for (String line : exercisesR11318) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day1318R1.add(temp);

            }
            for (String line : exercisesR11924) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day1924R1.add(temp);

            }
            for (String line : exercisesR12530) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day2530R1.add(temp);

            }
            for (String line : exercisesR13160) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day3160R1.add(temp);

            }


            for (String line : exercisesR216) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day16R2.add(temp);

            }
            for (String line : exercisesR2712) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day712R2.add(temp);

            }
            for (String line : exercisesR21318) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day1318R2.add(temp);

            }
            for (String line : exercisesR21924) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day1924R2.add(temp);

            }
            for (String line : exercisesR22530) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day2530R2.add(temp);

            }
            for (String line : exercisesR23160) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day3160R2.add(temp);

            }


            for (String line : exercisesR316) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day16R3.add(temp);

            }
            for (String line : exercisesR3712) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day712R3.add(temp);

            }
            for (String line : exercisesR31318) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day1318R3.add(temp);

            }
            for (String line : exercisesR31924) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day1924R3.add(temp);

            }
            for (String line : exercisesR32530) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day2530R3.add(temp);

            }
            for (String line : exercisesR33160) {

                Exercise temp;
                String name, time;
                String[] tempLine = line.split("/");
                name = tempLine[0];
                time = tempLine[1];
                temp = new Exercise(name, false, time, false);
                day3160R3.add(temp);

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            totalListR1 = new ArrayList<Exercise>();
            totalListR2 = new ArrayList<Exercise>();
            totalListR3 = new ArrayList<Exercise>();


            totalListR1.add(new Exercise("Day 1 - 6", false, "", true));
            totalListR1.addAll(day16R1);
            totalListR1.add(new Exercise("Day 7 - 12", false, "", true));
            totalListR1.addAll(day712R1);
            totalListR1.add(new Exercise("Day 13 - 18", false, "", true));
            totalListR1.addAll(day1318R1);
            totalListR1.add(new Exercise("Day 19 - 24", false, "", true));
            totalListR1.addAll(day1924R1);
            totalListR1.add(new Exercise("Day 25 - 30", false, "", true));
            totalListR1.addAll(day2530R1);
            totalListR1.add(new Exercise("Day 31 - 60", false, "", true));
            totalListR1.addAll(day3160R1);


            totalListR2.add(new Exercise("Day 1 - 6", false, "", true));
            totalListR2.addAll(day16R2);
            totalListR2.add(new Exercise("Day 7 - 12", false, "", true));
            totalListR2.addAll(day712R2);
            totalListR2.add(new Exercise("Day 13 - 18", false, "", true));
            totalListR2.addAll(day1318R2);
            totalListR2.add(new Exercise("Day 19 - 24", false, "", true));
            totalListR2.addAll(day1924R2);
            totalListR2.add(new Exercise("Day 25 - 30", false, "", true));
            totalListR2.addAll(day2530R2);
            totalListR2.add(new Exercise("Day 31 - 60", false, "", true));
            totalListR2.addAll(day3160R2);


            totalListR3.add(new Exercise("Day 1 - 6", false, "", true));
            totalListR3.addAll(day16R3);
            totalListR3.add(new Exercise("Day 7 - 12", false, "", true));
            totalListR3.addAll(day712R3);
            totalListR3.add(new Exercise("Day 13 - 18", false, "", true));
            totalListR3.addAll(day1318R3);
            totalListR3.add(new Exercise("Day 19 - 24", false, "", true));
            totalListR3.addAll(day1924R3);
            totalListR3.add(new Exercise("Day 25 - 30", false, "", true));
            totalListR3.addAll(day2530R3);
            totalListR3.add(new Exercise("Day 31 - 60", false, "", true));
            totalListR3.addAll(day3160R3);

            edit.putString("routineOneTotal", g.toJson(totalListR1));
            edit.putString("routineTwoTotal", g.toJson(totalListR2));
            edit.putString("routineThreeTotal", g.toJson(totalListR3));
            edit.commit();
            closeProgress();
        }
    }


}
