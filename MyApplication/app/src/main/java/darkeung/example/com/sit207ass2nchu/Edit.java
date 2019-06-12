package darkeung.example.com.sit207ass2nchu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User on 2/28/2017.
 */

public class Edit extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private Button btn_save,btn_delete;
    private EditText edit;

    SQLdphelper mDatabaseHelper;

    private String Event;
    private int ID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        btn_save = (Button) findViewById(R.id.btnSave);
        btn_delete = (Button) findViewById(R.id.btnDelete);
        edit = (EditText) findViewById(R.id.editable_item);
        mDatabaseHelper = new SQLdphelper(this);

        //get the intent extra from the ListDataActivity
        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        ID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        //now get the name we passed as an extra
        Event = receivedIntent.getStringExtra("name");

        //set the text to show the current selected name
        edit.setText(Event);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = edit.getText().toString();
                if(!item.equals("")){
                    mDatabaseHelper.updateName(item,ID,Event);
                    toastMessage("You have successfully added");
                }else{
                    toastMessage("You must enter somthing");
                }
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(ID,Event);
                edit.setText("");
                toastMessage("removed from database");
            }
        });


    }



    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.add)
        {
            Toast.makeText(this, "Share menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Add_event.class));

        }
        else if(id==R.id.action_rate)
        {
            Toast.makeText(this, "Attach menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, rate.class));


        }
        else if(id==R.id.action_home) {
            Toast.makeText(this, "Settings menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HomeActivity.class));
        }
        else if(id==R.id.action_contact) {
            Toast.makeText(this, "Settings menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, contact.class));
        }
        else if(id==R.id.list)
        {
            Toast.makeText(this, "Settings menu is Clicked", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, List.class));


        }
        return super.onOptionsItemSelected(item);
    }
}

