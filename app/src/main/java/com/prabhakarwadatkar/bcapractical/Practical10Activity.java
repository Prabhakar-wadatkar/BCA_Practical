package com.prabhakarwadatkar.bcapractical;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

public class Practical10Activity extends AppCompatActivity {
    private static final int REQUEST_READ_SMS = 2;
    private ListView smsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical10);

        smsListView = findViewById(R.id.sms_list);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_SMS},
                    REQUEST_READ_SMS);
        } else {
            loadSMS();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_READ_SMS && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            loadSMS();
        } else {
            Toast.makeText(this, "Permission denied to read SMS", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadSMS() {
        ArrayList<String> smsList = new ArrayList<>();
        Uri smsUri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(smsUri, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String body = cursor.getString(cursor.getColumnIndex("body"));
                smsList.add("From: " + address + "\nMessage: " + body);
            }
            cursor.close();
        } else {
            Toast.makeText(this, "No SMS found", Toast.LENGTH_SHORT).show();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, smsList);
        smsListView.setAdapter(adapter);
    }
}