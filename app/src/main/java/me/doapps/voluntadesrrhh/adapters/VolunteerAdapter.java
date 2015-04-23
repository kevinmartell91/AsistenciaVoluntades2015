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
import me.doapps.voluntadesrrhh.models.Volunteer_DTO;

/**
 * Created by jonathan on 22/04/2015.
 */
public class VolunteerAdapter extends BaseAdapter {
    private ArrayList<Volunteer_DTO> volunteer_dtos;
    private Context context;
    private LayoutInflater inflater;

    public VolunteerAdapter(ArrayList<Volunteer_DTO> volunteer_dtos, Context context){
        this.volunteer_dtos = volunteer_dtos;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return volunteer_dtos.size();
    }

    @Override
    public Object getItem(int position) {
        return volunteer_dtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        Volunteer_DTO volunteer_dto = volunteer_dtos.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_volunteer, parent, false);
            holder = new Holder();

            holder.img_profile = (ImageView) convertView.findViewById(R.id.img_profile);
            holder.txt_fullname = (TextView) convertView.findViewById(R.id.txt_fullname);
            holder.txt_state = (TextView) convertView.findViewById(R.id.txt_state);
            holder.img_state = (ImageView)convertView.findViewById(R.id.img_state);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.txt_fullname.setText(volunteer_dto.getName()+" "+volunteer_dto.getLast_name());
        holder.txt_state.setText("peligro");
        if(volunteer_dto.getGender() == 2){
            holder.img_profile.setImageResource(R.drawable.image_profile_default_female);
        }
        if(volunteer_dto.getState()==1){
            holder.img_state.setImageResource(R.drawable.ic_good);
        }
        else{
            if(volunteer_dto.getState()==2){
                holder.img_state.setImageResource(R.drawable.ic_middle);
            }
            else{
                holder.img_state.setImageResource(R.drawable.ic_bad);
            }
        }

        return convertView;
    }

    /****/
    class Holder{
        ImageView img_profile;
        ImageView img_state;
        TextView txt_fullname;
        TextView txt_state;
    }
}
