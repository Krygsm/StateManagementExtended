package com.example.statemanagementextended;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel
{
    private int count = 0;
    private String text = "";
    private Boolean checked = false;
    private Boolean switchedTheme = false;

    public int getCount() { return count; }
    public String getText() { return text; }
    public Boolean getChecked() { return checked; }
    public Boolean getSwitchedTheme() { return switchedTheme; }

    public void setChecked(Boolean checked) { this.checked = checked; }
    public void setSwitchedTheme(Boolean switchedTheme) { this.switchedTheme = switchedTheme; }

    public void incrementCount() { count++; }


}
