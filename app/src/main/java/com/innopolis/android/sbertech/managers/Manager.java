package com.innopolis.android.sbertech.managers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _red_ on 21.07.17.
 */

public class Manager {
    private final static Manager INSTANCE = new Manager();
    public final static Manager getInstance() {
        return INSTANCE;
    }

    private Manager() {
    }

    private List<Character> mCharacters = new ArrayList<>(100);
}
