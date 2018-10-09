package fr.wildcodeschool.myreminder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ReminderAdapter extends ArrayAdapter<ReminderModel> {

    public ReminderAdapter(Context context, List<ReminderModel> reminders) {
        super(context, 0, reminders);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        ReminderModel reminder = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_reminder, parent, false);
        }

        TextView tvReminder = convertView.findViewById(R.id.tv_reminder);
        TextView tvCreationDate = convertView.findViewById(R.id.tv_creation_date);

        // Populate the data from the object into the template view
        tvReminder.setText(reminder.getReminder());
        tvCreationDate.setText(reminder.getCreateDate());

        // Return the completed view to render on screen
        return convertView;
    }
}