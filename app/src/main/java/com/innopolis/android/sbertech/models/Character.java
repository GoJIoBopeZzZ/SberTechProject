package com.innopolis.android.sbertech.models;

import com.innopolis.android.sbertech.models.impl.CharacterData;
import com.innopolis.android.sbertech.models.impl.StringBuilderFromList;

import java.util.List;

/**
 * Created by _red_ on 21.07.17.
 */

public class Character implements CharacterData {
    private String url;
    private String spouse;
    private String name;
    private String mother;
    private String father;
    private String gender;
    private String culture;
    private String birthday;
    private String died;
    private List<String> titles;
    private List<String> aliases;
    private List<String> allegiances;
    private List<String> books;
    private List<String> povBooks;
    private List<String> series;
    private List<String> playedBy;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    @Override
    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Override
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    @Override
    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    @Override
    public List<String> getAllegiances() {
        return allegiances;
    }

    public void setAllegiances(List<String> allegiances) {
        this.allegiances = allegiances;
    }

    @Override
    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Override
    public List<String> getPovBooks() {
        return povBooks;
    }

    public void setPovBooks(List<String> povBooks) {
        this.povBooks = povBooks;
    }

    @Override
    public List<String> getTvSeries() {
        return series;
    }

    public void setTvSeries(List<String> tvSeries) {
        this.series = tvSeries;
    }

    @Override
    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }
}


