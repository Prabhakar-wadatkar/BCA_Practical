package com.prabhakarwadatkar.bcapractical;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Practical6Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical6);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_practical6, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_new) {
            Toast.makeText(this, "New selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.menu_save) {
            Toast.makeText(this, "Save selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.menu_exit) {
            Toast.makeText(this, "Exit selected", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}