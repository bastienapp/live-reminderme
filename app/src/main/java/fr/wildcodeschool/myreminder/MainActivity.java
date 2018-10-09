package fr.wildcodeschool.myreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ReminderModel> reminders = new ArrayList<>();
        reminders.add(new ReminderModel("Numéro de téléphone de jack : 06.14.85.47.25", "2018-09-24"));
        reminders.add(new ReminderModel("Taille du bureau : 150x200", "2018-09-26"));

        ListView listReminder = findViewById(R.id.list_reminder);
        ReminderAdapter adapter = new ReminderAdapter(MainActivity.this, reminders);
        listReminder.setAdapter(adapter);
    }
}
