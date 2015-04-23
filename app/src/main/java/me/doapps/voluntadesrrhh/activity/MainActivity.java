package me.doapps.voluntadesrrhh.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import me.doapps.voluntadesrrhh.R;
import me.doapps.voluntadesrrhh.adapters.StateAdapter;
import me.doapps.voluntadesrrhh.adapters.VolunteerAdapter;
import me.doapps.voluntadesrrhh.models.State_DTO;
import me.doapps.voluntadesrrhh.models.Volunteer_DTO;
import me.doapps.voluntadesrrhh.utils.FontUtil;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private ArrayList<Volunteer_DTO> volunteer_dtos = new ArrayList<Volunteer_DTO>();
    private VolunteerAdapter volunteer_adapter;

    private Button btn_save;
    private Button btn_update;
    private ListView list_volunteer;

    private String today;

    private TextView txt_today;
    private TextView textMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        today = formater.format(calendar.getTime());

        txt_today = (TextView) findViewById(R.id.txt_today);
        textMain = (TextView) findViewById(R.id.textMain);
        txt_today.setText(today);
        textMain.setTypeface(FontUtil.setRalewayExtraBold(this));

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_update = (Button) findViewById(R.id.btn_update);
        list_volunteer = (ListView) findViewById(R.id.list_volunteer);

        list_volunteer.setOnItemClickListener(this);


        volunteer_dtos.clear();
        volunteer_dtos.add(new Volunteer_DTO(1, "Kevin", "Martel", 1, 1, 1));
        volunteer_dtos.add(new Volunteer_DTO(1, "Agustin", "Samillán", 1, 1, 1));
        volunteer_dtos.add(new Volunteer_DTO(1, "Jonathan", "Nolasco", 1, 1, 1));
        volunteer_dtos.add(new Volunteer_DTO(1, "La china", "Zombie", 1, 2, 1));
        volunteer_dtos.add(new Volunteer_DTO(1, "El chino", "Zombie", 1, 1, 1));

        volunteer_adapter = new VolunteerAdapter(volunteer_dtos, this);
        list_volunteer.setAdapter(volunteer_adapter);
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

    @Override
    public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
        ArrayList<State_DTO> state_dtos = new ArrayList<State_DTO>();
        state_dtos.add(new State_DTO("Llegó temprano", 1));
        state_dtos.add(new State_DTO("Llegó tarde", 2));
        state_dtos.add(new State_DTO("No llegó", 3));

        StateAdapter value_adapter = new StateAdapter(state_dtos, this);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setAdapter(value_adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                ListView listView = ((AlertDialog) dialogInterface).getListView();
                int state = ((State_DTO) listView.getAdapter().getItem(which)).getState();
                Log.e("asistencia", state + "");

                ((Volunteer_DTO) parent.getAdapter().getItem(position)).setState(state);
                volunteer_adapter.notifyDataSetChanged();
                String temp_dtos = "";
                for (int j = 0; j < volunteer_dtos.size(); j++) {
                    temp_dtos = temp_dtos + volunteer_dtos.get(j).getName() + " - " + volunteer_dtos.get(j).getState() + "\n";
                }
                Log.e("volunteer dtoss", temp_dtos);
            }
        });
        builder.create();
        builder.show();
    }
}
