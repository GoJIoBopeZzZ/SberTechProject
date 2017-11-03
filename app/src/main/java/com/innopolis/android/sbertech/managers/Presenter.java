package com.innopolis.android.sbertech.managers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _red_ on 21.07.17.
 */

public final class Presenter {
    private static class PresenterHolder {
        private static final Presenter HOLDER_INSTANCE = new Presenter();
    }

    public static Presenter getInstance() {
        return PresenterHolder.HOLDER_INSTANCE;
    }

}
