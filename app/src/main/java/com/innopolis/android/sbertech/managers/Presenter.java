package com.innopolis.android.sbertech.managers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _red_ on 21.07.17.
 */

public class Presenter {

    public static class PresenterHolder {
        public static final Presenter HOLDER_INSTANCE = new Presenter();
    }

    public static Presenter getInstance() {
        return PresenterHolder.HOLDER_INSTANCE;
    }

    private List<Character> mCharacters = new ArrayList<>(100);
}
