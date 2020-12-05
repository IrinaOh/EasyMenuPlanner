package com.example.easymenuplanner.menu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MenuCalendar {
    private List<Menu> myMenus;

    public MenuCalendar() {
        myMenus = new ArrayList<>();

        Calendar today = Calendar.getInstance();
        myMenus.add(new Menu(today));

        Calendar nextDay = Calendar.getInstance();
        nextDay.add(Calendar.DATE, 1);
        myMenus.add(new Menu(nextDay));

        nextDay.add(Calendar.DATE, 1);
        myMenus.add(new Menu(nextDay));
    }

    public int getSize() {
        return myMenus.size();
    }

    public Menu getMenu(int position) {
        return myMenus.get(position);
    }
}
