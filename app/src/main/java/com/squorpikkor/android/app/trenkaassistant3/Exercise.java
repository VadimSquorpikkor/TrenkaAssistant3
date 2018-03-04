package com.squorpikkor.android.app.trenkaassistant3;

import java.util.ArrayList;

/**
 *
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 * Класс для хранения всех данных одного конкретного упражнения
 * Все подходы за день и все дни с этими подходами
 * Рекорды упражнения, установка веса и количества повторов и т. д.
 *
 * В WorkList'е находится Стринговый лист (Которы будет сейвиться/лоадиться) для
 * хранения SharePref ссылок, и Work'овый лист, в который будут загружаться объекты Work (точнее будут создаваться новые и в них будут
 * сеттиться загруженные по ссылкам из String листа данные)
 */

public class Exercise {

    //При создании класса Exercise можно выбрать, какой тип "Подхода" будет использоваться в классе --
    // силовой[type 0] или бег[type 1] (абстрактный класс Podhod и его потомки)
    int type;

    String exerciseName;
    ArrayList<String> shPrefList;
    ArrayList<Work> workList = new ArrayList<>();

    double weight;
    int count;


    Work currentWork;//Может быть и новым, и выбранным старым -- это тот Ворк, который отображается под листом
    Work bestWork;

    void addWeight() {

    }

    void subWeight() {

    }

    void createNewWork() {

    }


}