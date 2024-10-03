package com.example.statemanagementextended;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;


public class MainActivity extends AppCompatActivity
{
    private StateViewModel stateViewModel;

    private TextView numberDisplayTextView;
    private Button addButton;
    private EditText editText;
    private CheckBox checkBox;
    private TextView checkBoxMessage;
    private Switch switchTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);

        numberDisplayTextView = findViewById(R.id.numberDisplay);
        addButton = findViewById(R.id.addButton);
        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.textViewCheckbox);
        checkBoxMessage = findViewById(R.id.checkBoxMessageTextView);
        switchTheme = findViewById(R.id.themeSwitch);


        updateCountText();
        updateEditText();
        updateCheckbox();
        updateSwitchTheme();

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                stateViewModel.incrementCount();
                updateCountText();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                if(isChecked) stateViewModel.setChecked(true); else stateViewModel.setChecked(false);
                updateCheckbox();
            }
        });

        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isSwitched)
            {
                if(isSwitched) stateViewModel.setSwitchedTheme(true); else stateViewModel.setSwitchedTheme(false);;
                updateSwitchTheme();
            }
        });
    }

    private void updateCountText() { numberDisplayTextView.setText("Licznik:" + stateViewModel.getCount()); }
    private void updateEditText() { editText.setText(stateViewModel.getText()); }
    private void updateCheckbox() { if(stateViewModel.getChecked()) checkBoxMessage.setText("Opcja zaznaczona"); else checkBoxMessage.setText(""); }
    private void updateSwitchTheme() { if(stateViewModel.getSwitchedTheme()) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);  else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); }
}