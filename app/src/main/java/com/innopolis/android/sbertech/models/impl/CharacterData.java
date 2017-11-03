package com.innopolis.android.sbertech.models.impl;

import java.util.List;

/**
 * Created by _red_ on 23.07.17.
 */

public interface CharacterData {
    public String getUrl();

    public String getSpouse();

    public String getName();

    public String getMother();

    public String getFather();

    public String getGender();

    public String getCulture();

    public String getBirthday();

    public String getDied();

    public List<String> getTitles();

    public List<String> getAliases();

    public List<String> getAllegiances();

    public List<String> getBooks();

    public List<String> getPovBooks();

    public List<String> getTvSeries();

    public List<String> getPlayedBy();
}
