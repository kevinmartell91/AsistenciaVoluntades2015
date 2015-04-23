package me.doapps.voluntadesrrhh.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.doapps.voluntadesrrhh.R;
import me.doapps.voluntadesrrhh.models.State_DTO;

/**
 * Created by jonathan on 22/04/2015.
 */
public class StateAdapter extends BaseAdapter {
    private ArrayList<State_DTO> state_dtos;
    private Context context;
    private LayoutInflater inflater;

    public StateAdapter(ArrayList<State_DTO> state_dtos, Context context) {
        this.state_dtos = state_dtos;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return state_dtos.size();
    }

    @Override
    public Object getItem(int position) {
        return state_dtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        State_DTO value_dto = state_dtos.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_state, parent, false);
            holder = new Holder();

            holder.txt_value_name = (TextView) convertView.findViewById(R.id.txt_value_name);
            holder.img_value = (ImageView) convertView.findViewById(R.id.img_value);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.txt_value_name.setText(value_dto.getName());
        switch (value_dto.getState()) {
            case 1:
                holder.img_value.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_good));
                break;
            case 2:
                holder.img_value.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_middle));
                break;
            case 3:
                holder.img_value.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_bad));
                break;
            default:
                holder.img_value.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_good));
                break;
        }
        return convertView;
    }

    /**/
    class Holder {
        TextView txt_value_name;
        ImageView img_value;
    }
}
