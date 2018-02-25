package com.squorpikkor.android.app.trenkaassistant3;

/**
 *
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 *
 */

public class TrenkaListItem {

    TrenkaListItem(String dateOfTrenka, String prefName, int dayBefore) {
        this.dateOfTrenka = dateOfTrenka;
        this.prefName = prefName;
        this.dayBefore = dayBefore;
    }

    private String dateOfTrenka;
    private String prefName;
    private int dayBefore;

    public int getDayBefore() {
        return dayBefore;
    }

    public void setDayBefore(int dayBefore) {
        this.dayBefore = dayBefore;
    }

    public String getDateOfTrenka() {
        return dateOfTrenka;
    }

    public void setDateOfTrenka(String dateOfTrenka) {
        this.dateOfTrenka = dateOfTrenka;
    }

    public String getPrefName() {
        return prefName;
    }

    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }
}
