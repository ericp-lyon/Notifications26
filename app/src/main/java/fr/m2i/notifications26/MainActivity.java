package fr.m2i.notifications26;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static fr.m2i.notifications26.Tools.showNotification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNotification(this,  "test");

;    }
}
