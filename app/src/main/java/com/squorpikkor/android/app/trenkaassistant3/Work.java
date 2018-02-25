package com.squorpikkor.android.app.trenkaassistant3;

import java.util.ArrayList;

/**
 * Created by VadimSquorpikkor on 02.09.2017.
 * <p>
 * Класс для хранения конкретного упражнения выполненного в конкретный день
 * Из таких классов будут состоять такие коллекции (классы), как Упражнение и Тренировка
 *
 * Возможно есть смысл сделать методы savePodhod и loadPodhod в классе Work, а не в SaveLoad
 */

public class Work {
    private SaveLoad saveLoad;
    private ArrayList<Podhod> podhodList;
    private String sharedPrefName;

    /**
     * Конструктор класса создает не новый объект класса с параметрами по умолчанию либо с параметрами в конструкторе,
     * а создает новый объект и загружает в него параметры из Shared Preferences. Таким образом происходит сохранение объекта
     * Загрузка происходит так -- создается новый объект (пустой), а уже в него будут загружаться данные от определенного SharedP
     * Для загрузки определенного объекта нужно загрузить данные по определенной ссылке (начальный объект по сути один и тот же
     * -- такой вот мультиплексор получается)
     */
    Work(String sharedPref) {
        saveLoad = new SaveLoad();
        podhodList = saveLoad.loadPodhodList(sharedPref);
        sharedPrefName = sharedPref;
    }

    /**Чтобы не заморачиваться с именем SharedPref, я при загрузке в конструкторе запоминаю ссылку,
     * по которой были загружены переменные в sharedPrefName, а при сохранении использую эту ссылку
     * Так метод savePodhodList() используется без параметров
     * **/
    void savePodhodList() {
        saveLoad.savePodhodList(podhodList, sharedPrefName);
    }
}
