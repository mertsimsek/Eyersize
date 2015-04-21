package co.fourapps.eyetraining.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import co.fourapps.eyetraining.Model.Exercise;
import co.fourapps.eyetraining.R;

/**
 * Created by mertsimsek on 19/11/14.
 */
public class RoutineOneAdapter extends ArrayAdapter<Exercise> {

    private ArrayList<Exercise> list;
    private Context c;
    private Exercise temp;
    private LayoutInflater inflater ;
    private View view;

    public RoutineOneAdapter(Context context, ArrayList<Exercise> objects) {
        super(context,R.layout.child_astigmat,objects);
        this.c = context;
        this.list = objects;
        inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Exercise getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        temp = list.get(position);
        view=inflater.inflate(R.layout.child_astigmat, null, false);

        ViewHolder.name = (TextView) view.findViewById(R.id.astigmat_child_name);
        ViewHolder.time = (TextView) view.findViewById(R.id.astigmat_child_time);
        ViewHolder.isDone = (CheckBox) view.findViewById(R.id.astigmat_child_isdone);

        ViewHolder.name.setText(temp.getName());
        ViewHolder.time.setText(temp.getTime());
        ViewHolder.isDone.setClickable(false);
        ViewHolder.isDone.setFocusable(false);

        if(temp.isDone())
            ViewHolder.isDone.setChecked(true);
        else
            ViewHolder.isDone.setChecked(false);

        if(temp.isHeader()) {
            ViewHolder.isDone.setVisibility(View.INVISIBLE);
            ViewHolder.time.setVisibility(View.INVISIBLE);
            ViewHolder.name.setTextColor(Color.WHITE);
            view.setBackgroundColor(Color.BLACK);
        }

        return view;
    }

    public void refreshList(ArrayList<Exercise> list) {
        this.list = list;
    }

    private static class ViewHolder {

        static TextView name;
        static TextView time;
        static CheckBox isDone;

    }
}
