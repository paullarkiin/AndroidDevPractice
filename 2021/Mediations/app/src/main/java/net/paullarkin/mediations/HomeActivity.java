package net.paullarkin.mediations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openNext(View view)
    {
        Intent intent = new Intent(getApplicationContext(), TimersActivity.class);
        startActivity(intent);
    }

}