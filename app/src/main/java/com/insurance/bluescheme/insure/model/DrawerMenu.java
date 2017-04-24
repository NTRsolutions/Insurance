package com.insurance.bluescheme.insure.model;

/**
 * Created by tonmoybarua on 11-Apr-17.
 */

public class DrawerMenu {
    String menu_title;
    int menu_imageid;

    public DrawerMenu(String menu_title, int menu_imageid) {
        this.menu_title = menu_title;
        this.menu_imageid = menu_imageid;
    }

    public String getMenu_title() {
        return menu_title;
    }

    public void setMenu_title(String menu_title) {
        this.menu_title = menu_title;
    }

    public int getMenu_imageid() {
        return menu_imageid;
    }

    public void setMenu_imageid(int menu_imageid) {
        this.menu_imageid = menu_imageid;
    }
}
