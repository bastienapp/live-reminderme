package fr.wildcodeschool.myreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ReminderModel> mReminders = new ArrayList<>();
    ReminderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO charger les reminder de Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // cibler la référence des données à charger
        DatabaseReference reminderRef = database.getReference("reminder");
        reminderRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // on vide la liste
                mReminders.clear();
                for (DataSnapshot reminderSnapshot : dataSnapshot.getChildren()) {
                    ReminderModel reminder =
                            reminderSnapshot.getValue(ReminderModel.class);
                    mReminders.add(reminder);
                }
                // mettre à jour l'adapter
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });


        ListView listReminder = findViewById(R.id.list_reminder);
        mAdapter = new ReminderAdapter(MainActivity.this, mReminders);
        listReminder.setAdapter(mAdapter);
    }
}
