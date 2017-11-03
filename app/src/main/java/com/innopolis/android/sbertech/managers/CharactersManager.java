package com.innopolis.android.sbertech.managers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _red_ on 23.07.17.
 */

public final class CharactersManager {
    public static class ManagerHolder {
        public static CharactersManager HOLDER_INSTANCE = new CharactersManager();
    }

    public static CharactersManager getInstance() { return ManagerHolder.HOLDER_INSTANCE; }
    
    private List<Character> mCharacters = new ArrayList<>();
}
