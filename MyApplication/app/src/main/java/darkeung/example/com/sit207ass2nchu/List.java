package darkeung.example.com.sit207ass2nchu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by User on 2/28/2017.
 */

public class List extends AppCompatActivity {

    private static final String TAG = "ListDataActivity";

    SQLdphelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new SQLdphelper(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        //set an onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);

                Cursor data = mDatabaseHelper.getItemID(name); //get the id associated with that name
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if(itemID > -1){
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    Intent editScreenIntent = new Intent(List.this, Edit.class);
                    editScreenIntent.putExtra("id",itemID);
                    editScreenIntent.putExtra("name",name);
                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("No ID associated with that name");
                }
            }
        });
    }
    // Handle action bar item clicks here.
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

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}