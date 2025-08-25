package com.prabhakarwadatkar.bcapractical;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Practical20Activity extends AppCompatActivity {
    private EditText messageInput;
    private TextView responseTextView;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical20);

        messageInput = findViewById(R.id.message_input);
        responseTextView = findViewById(R.id.response_text);
        Button sendButton = findViewById(R.id.send_button);
        Button fetchButton = findViewById(R.id.fetch_button);

        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("messages");

        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();
            if (!message.isEmpty()) {
                // Send message to Firebase with a unique ID
                String messageId = databaseReference.push().getKey();
                databaseReference.child(messageId).setValue(message)
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(Practical20Activity.this, "Message sent", Toast.LENGTH_SHORT).show();
                            messageInput.setText("");
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(Practical20Activity.this, "Error sending message", Toast.LENGTH_SHORT).show();
                            responseTextView.setText("Error: " + e.getMessage());
                        });
            } else {
                Toast.makeText(this, "Enter a message", Toast.LENGTH_SHORT).show();
            }
        });

        fetchButton.setOnClickListener(v -> {
            responseTextView.setText("Fetching data...");
            // Fetch all messages from Firebase
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    StringBuilder messages = new StringBuilder();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String message = snapshot.getValue(String.class);
                        messages.append(message).append("\n");
                    }
                    if (messages.length() > 0) {
                        responseTextView.setText(messages.toString());
                    } else {
                        responseTextView.setText("No messages found");
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    responseTextView.setText("Error: " + databaseError.getMessage());
                }
            });
        });
    }
}