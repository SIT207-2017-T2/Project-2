package darkeung.example.com.sit207ass2nchu;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    public void GotoSecondActivity(View view) {
        Intent intent = new Intent(this, Second. class);
        startActivity(intent);
    }

    public void file3(View view) {
        Intent intent = new Intent(this, three. class);
        startActivity(intent);
    }

    // Inflate the options menu from XML
    @Override


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
            startActivity(new Intent(this,rate.class));


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

    //Alert Dialog For Exit pops up
    void Exit() {

        new AlertDialog.Builder(HomeActivity.this)
                .setTitle(" Exit")
                .setMessage("Exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()


                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Execution the function of Exiting if click yes
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        System.exit(0);
                    }
                })
                //Stay on the page if click no
                .setNegativeButton("No", null)
                .show();
    }
    //Alert Dialog For Rating pops up
    void Rating() {

        new AlertDialog.Builder(HomeActivity.this)
                .setTitle("Rate")
                .setMessage("Rate Us?")
                .setPositiveButton("Go", new DialogInterface.OnClickListener()


                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Execution the function of jumping to Rating Page if click yes
                        Intent intent = new Intent(HomeActivity.this, rate.class);
                        startActivity(intent);
                    }
                })
                //Stay on the page if click no
                .setNegativeButton("Not Now", null)
                .show();
    }
}



