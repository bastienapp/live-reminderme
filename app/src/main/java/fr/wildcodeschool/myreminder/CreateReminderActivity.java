package fr.wildcodeschool.myreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);

        Button send = findViewById(R.id.bt_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText tvDescription = findViewById(R.id.tv_description);
                EditText tvDate = findViewById(R.id.tv_date);
                String description = tvDescription.getText().toString();
                String date = tvDate.getText().toString();

                // enregistrer un nouvel objet reminder dans Firebase
                ReminderModel reminder = new ReminderModel(description, date);
                // appel de ma base de données
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                // appel de la référence qui va stocker les données
                DatabaseReference reminderRef = database.getReference("reminder");
                reminderRef.push().setValue(reminder);
            }
        });
    }
}
