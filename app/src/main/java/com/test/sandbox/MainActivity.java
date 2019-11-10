package com.test.sandbox;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    private static EditText textFieldQuestion =  null;
    private static ListView hanaView = null;
    private static HanaAdapter hanaAdapter = null;
    private static ImageButton buttonSend = null;
    private static Thread tr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hanaAdapter =  new HanaAdapter(this);
        hanaView = findViewById(R.id.listView);
        buttonSend = findViewById(R.id.sendButton);
        textFieldQuestion = findViewById(R.id.questionField);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hanaEntryMessage();
            }
        }, 2000);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hanaEntryMessage();
            }
        }, 3000);

        hanaView.setAdapter(hanaAdapter);
    }

    private void sendMessage(String message, Boolean isHana){
        HanaMessage hn = new HanaMessage(message, !isHana);
        hanaAdapter.add(hn);
        hanaView.setSelection(hanaView.getCount() - 1);
    }

    public void sendMessageButton(View view){
        hanaHardCoded();
        textFieldQuestion.getText().clear();
    }

    Boolean it = false;
    private void hanaEntryMessage(){
        if(it){
            sendMessage("Nice to meet you! Mr. Macorol.", true);
        } else {
            sendMessage("Hi I'm Hana, your new virtual friend!", true);
            it = true;
        }
    }

    int iter = 0;
    private void hanaHardCoded(){
        Handler handler = new Handler();
        switch(iter){
            case 0:
                sendMessage(textFieldQuestion.getText().toString(), false);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sendMessage("How are you? I had analyzed your personality" +
                                " assessment, and I saw that you have very low score in " +
                                "conscientiousness, do you find yourself struggling to do" +
                                " things you need to do due to the procrastination or do you " +
                                "find yourself as an untidy person? ", true);
                    }
                }, 2000);
                iter++;
                break;
            case 1:
                sendMessage(textFieldQuestion.getText().toString(), false);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(textFieldQuestion.getText().toString().equalsIgnoreCase("no")){
                            sendMessage("Really? But can you share some stories where you got really " +
                                    "stressed out due to procrastination or being untidy", true);
                        } else {
                            sendMessage("Can you share some story?", true);
                        }
                    }
                }, 2000);
                iter++;
                break;
            case 2:
                sendMessage(textFieldQuestion.getText().toString(), false);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sendMessage(" Wow Interesting, we will be basing our activity to improve " +
                                "your conscientiousness, so be ready! I'll keep you posted! But first please fill out " +
                                "your daily activities in the planner!", true);
                    }
                }, 2000);
                iter++;
                hanaHardCoded();
                break;
            case 3:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sendMessage(" Good Morning Mr. Macorol! As a part of your daily activities " +
                                "please write down below things you want to achieve today, and a put a certain time " +
                                "on when do you want to finish the task beside every task.", true);
                    }
                }, 10000);
                iter++;
                break;
            case 4:
                sendMessage(textFieldQuestion.getText().toString(), false);
                iter++;
                hanaHardCoded();
                break;
            case 5:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sendMessage(" How was your sleep? How good is it Mr. Macorol? ", true);
                    }
                }, 10000);
                iter++;
                break;
            case 6:
                sendMessage(textFieldQuestion.getText().toString(), false);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sendMessage(" I see! I'll remind you if you need to do something later! Have a good day!  ", true);
                    }
                }, 2000);
                iter++;
                break;
            default:
                sendMessage(textFieldQuestion.getText().toString(), false);
        }

    }
}
