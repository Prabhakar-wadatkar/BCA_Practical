package com.prabhakarwadatkar.bcapractical;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView practicalListView;
    private String[] practicals = {
            "1. Hello World",
            "2. Simple Calculator",
            "3. Activity using Fragment",
            "4. Multiple Activities",
            "5. Content Provider",
            "6. Menu Application",
            "7. Intent Filter",
            "8. Broadcast Receiver",
            "9. Alert Dialog Box",
            "10. Show SMS",
            "11. Compound Control",
            "12. Geo Location",
            "13. Animate Bitmap",
            "14. Simple Animation",
            "15. Video View",
            "16. Advanced Animation",
            "17. New Thread for Service",
            "18. Progress Bar",
            "19. Video View",
            "20. Send/Receive Data from Server"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        practicalListView = findViewById(R.id.practical_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, practicals);
        practicalListView.setAdapter(adapter);

        practicalListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(MainActivity.this, Practical1Activity.class);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, Practical2Activity.class);
                    break;
                case 2:
                    intent = new Intent(MainActivity.this, Practical3Activity.class);
                    break;
                case 3:
                    intent = new Intent(MainActivity.this, Practical4Activity.class);
                    break;
                case 4:
                    intent = new Intent(MainActivity.this, Practical5Activity.class);
                    break;
                case 5:
                    intent = new Intent(MainActivity.this, Practical6Activity.class);
                    break;
                case 6:
                    intent = new Intent(MainActivity.this, Practical7Activity.class);
                    break;
                case 7:
                    intent = new Intent(MainActivity.this, Practical8Activity.class);
                    break;
                case 8:
                    intent = new Intent(MainActivity.this, Practical9Activity.class);
                    break;
                case 9:
                    intent = new Intent(MainActivity.this, Practical10Activity.class);
                    break;
                case 10:
                    intent = new Intent(MainActivity.this, Practical11Activity.class);
                    break;
                case 11:
                    intent = new Intent(MainActivity.this, Practical12Activity.class);
                    break;
                case 12:
                    intent = new Intent(MainActivity.this, Practical13Activity.class);
                    break;
                case 13:
                    intent = new Intent(MainActivity.this, Practical14Activity.class);
                    break;
                case 14:
                    intent = new Intent(MainActivity.this, Practical15Activity.class);
                    break;
                case 15:
                    intent = new Intent(MainActivity.this, Practical16Activity.class);
                    break;
//                case 16:
//                    intent = new Intent(MainActivity.this, Practical17Activity.class);
//                    break;
//                case 17:
//                    intent = new Intent(MainActivity.this, Practical18Activity.class);
//                    break;
//                case 18:
//                    intent = new Intent(MainActivity.this, Practical19Activity.class);
//                    break;
//                case 19:
//                    intent = new Intent(MainActivity.this, Practical20Activity.class);
//                    break;
                default:
                    return;
            }
            startActivity(intent);
        });
    }
}