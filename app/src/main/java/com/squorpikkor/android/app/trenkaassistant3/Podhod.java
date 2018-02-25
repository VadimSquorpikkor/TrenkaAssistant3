package com.squorpikkor.android.app.trenkaassistant3;

/**
 *
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 * Класс для описания одного подхода упражнения
 */

class Podhod {
    /**Вес**/
    private double weight;

    /**Кол-во повторов**/
    private int count;

    /**Коментарий -- не обязательный параметр**/
    private String comment;

    public Podhod(double weight, int count, String comment) {
        this.weight = weight;
        this.count = count;
        this.comment = comment;
    }

    public double getWeight() {
        return weight;
    }

    public int getCount() {
        return count;
    }

    public String getComment() {
        return comment;
    }
}
