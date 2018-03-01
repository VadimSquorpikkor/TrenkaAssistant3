package com.squorpikkor.android.app.trenkaassistant3;

/**
 *
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 * Класс для описания одного подхода упражнения
 *
 * !!!Класс Podhod нужно сделать абстрактным, а от него два потомка -- класс для бега, и класс для весовых упражнений
 * Пока сделал обычным классом, после проверки и отладки сделаю абстрактным
 */

////////////abstract class Podhod {
class Podhod {
    /**Вес**/
    private double weight;

    /**Кол-во повторов**/
    private int count;

    /**Коментарий -- не обязательный параметр**/
    private String comment;

    private double weightStep = 2.5;

    private int countStep = 1;

    Podhod(double weight, int count, String comment) {
        this.weight = weight;
        this.count = count;
        this.comment = comment;
    }

    double getWeight() {
        return weight;
    }

    int getCount() {
        return count;
    }

    String getComment() {
        return comment;
    }

    void addWeight() {

    }

    void subWeight() {

    }

    void addCount() {

    }

    void subCount() {

    }


}
