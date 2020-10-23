package ru.nehodov.products.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dagger.hilt.android.AndroidEntryPoint;
import ru.nehodov.products.R;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}