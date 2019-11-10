package com.test.sandbox;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class HanaAdapter extends BaseAdapter {

    ArrayList<HanaMessage> messages = new ArrayList<>();
    Context context;

    public HanaAdapter(Context context) {
        this.context = context;
    }


    public void add(HanaMessage message) {
        this.messages.add(message);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        MessageViewHolder holder = new MessageViewHolder();
        LayoutInflater messageInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        HanaMessage message = messages.get(i);

        if (message.isBelongsToCurrentUser()) {
            convertView = messageInflater.inflate(R.layout.messages, null);
            holder.messageBody = convertView.findViewById(R.id.message_body_my_message);
            convertView.setTag(holder);
            holder.messageBody.setText(message.getText());
        } else {
            convertView = messageInflater.inflate(R.layout.other_messages, null);
            holder.name = convertView.findViewById(R.id.name);
            holder.messageBody = convertView.findViewById(R.id.message_body_other_message);
            convertView.setTag(holder);
            holder.messageBody.setText(message.getText());
        }

        return convertView;
    }

}

class MessageViewHolder {
    public TextView name;
    public TextView messageBody;
}