package com.innopolis.android.sbertech.managers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _red_ on 21.07.17.
 */

public class CharacterManager {
    private final static CharacterManager INSTANCE = new CharacterManager();
    public final static CharacterManager getInstance() {
        return INSTANCE;
    }

    private CharacterManager() {
    }

    private List<Character> mCharacters = new ArrayList<>(100);
}
