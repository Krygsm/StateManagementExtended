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


public class MainActivity extends AppCompatActivity
{
    private static final String KEY_COUNT = "count";
    private static final String KEY_TEXT = "text";
    private static final String KEY_CHECKBOX = "checkbox";
    private static final String KEY_SWITCH = "switch";

    private TextView numberDisplayTextView;
    private Button addButton;
    private EditText editText;
    private CheckBox checkBox;
    private TextView checkBoxMessage;
    private Switch switchTheme;

    private int count = 0;
    private String text;
    private Boolean checked = false;
    private Boolean switched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberDisplayTextView = findViewById(R.id.numberDisplay);
        addButton = findViewById(R.id.addButton);
        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.textViewCheckbox);
        checkBoxMessage = findViewById(R.id.checkBoxMessageTextView);
        switchTheme = findViewById(R.id.themeSwitch);

        if(savedInstanceState != null)
        {
            count = savedInstanceState.getInt(KEY_COUNT);
            text = savedInstanceState.getString(KEY_TEXT);
            checked = savedInstanceState.getBoolean(KEY_CHECKBOX);
            switched = savedInstanceState.getBoolean(KEY_SWITCH);

            updateCountText();
            updateEditText();
            updateCheckbox();
            updateSwitchTheme();
        }

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                count++;
                updateCountText();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) 
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) 
            {

            }

            @Override
            public void afterTextChanged(Editable editable) 
            {
                text = editText.getText().toString();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                if(isChecked) checked = true; else checked = false;
                updateCheckbox();
            }
        });

        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isSwitched)
            {
                if(isSwitched) switched = true; else switched = false;
                updateSwitchTheme();
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
        outState.putString(KEY_TEXT, text);
        outState.putBoolean(KEY_CHECKBOX, checked);
        outState.putBoolean(KEY_SWITCH, switched);
    }

    private void updateCountText() { numberDisplayTextView.setText("Licznik:" + count); }
    private void updateEditText() { editText.setText(text); }
    private void updateCheckbox() { if(checked) checkBoxMessage.setText("Opcja zaznaczona"); else checkBoxMessage.setText(""); }
    private void updateSwitchTheme() { if(switched) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);  else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); }
}
