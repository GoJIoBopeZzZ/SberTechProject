package com.innopolis.android.sbertech.managers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _red_ on 21.07.17.
 */

public class Presenter {
    private final static Presenter INSTANCE = new Presenter();
    public final static Presenter getInstance() {
        return INSTANCE;
    }

    private Presenter() {
    }

    private List<Character> mCharacters = new ArrayList<>(100);
}
