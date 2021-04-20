package com.innohackathon.happinessindex.controllers;

import com.innohackathon.happinessindex.models.DataPackage;
import com.innohackathon.happinessindex.models.IndexPackage;

import java.util.ArrayList;

public class Response_UserInfo {
    public final int[] indexes;
    public final String name;
    public final String surname;
    public final Long id;
    public final String[] data;

    public Response_UserInfo(IndexPackage ip, DataPackage dp) {
        int i =0;
        indexes = new int[6];
        indexes[i++] = ip.getMoney();
        indexes[i++] = ip.getHealth();
        indexes[i++] = ip.getLove();
        indexes[i++] = ip.getFriends();
        indexes[i++] = ip.getWork();
        indexes[i] = ip.getHobby();

        i =0;
        name = dp.getFirst_name();
        surname = dp.getLast_name();
        id = dp.getId();
        ArrayList<String> datum = new ArrayList<>(20);
        datum.add("Пол: " + dp.getGender());
        datum.add("Возраст: " + dp.getAge());
        datum.add("Адрес: " + dp.getAddress());
        datum.add("Место работы: " + dp.getWorkplace());
        datum.add("Должность: " + dp.getPosition());
        datum.add("BPM: " + dp.getBpm());
        datum.add("Зар. плата: " + dp.getSalary());
        datum.add("Успеваемость: " + dp.getPerformance());
        datum.add("Кровяное давление: " + dp.getBlood_pressure());
        datum.add("Шагов в день: " + dp.getSteps_per_day());
        datum.add("Art клубы: " + dp.getVisits_art_clubs());
        datum.add("Спортивные секции: " + dp.getVisits_sport_clubs());
        datum.add("Общение: " + dp.getInteraction_with_friends());
        datum.add("Семейное положение: " + dp.getRelationship());

        data = datum.toArray(new String[0]);
    }
}
