package com.squorpikkor.android.app.trenkaassistant3;

/**
 *
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 * В коллекции WorkList будут храниться не сами объекты Work (как можно подумать), а, как бы, псевдо Work, в котором будет храниться
 * ссылка типа SharedPreferences, по которой можно будет загрузить собственно объект типа Work.
 * WorkListItem и является, собственно, этим псевдо классом.
 * Кроме ссылки будут храниться парочка переменных для отображения основных данных класса. Такая канитель нужна для того, чтобы
 * при загрузке объекта класса Exercise и входящего в него листа WorkList не загружать все объекты класса Work (и все входящие в них
 * коллекции -- та ещё рекурсия), а просто загрузить один String'овый лист.
 *
 * Точно!!!! НИКАКОГО ПСЕВДО КЛАССА НЕ НУЖНО!!! В WorkList'е нужно просто сделать Стринговый лист (Которы будет сейвиться/лоадиться) для
 * хранения SharePref ссылок, и Work'овый лист, в который будут загружаться объекты Work (точнее будут создаваться новые и в них будут
 * сеттиться загруженные по ссылкам из String листа данные)
 */

class WorkListItem {

}
