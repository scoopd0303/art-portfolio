package com.trashdoodles.artportfolio.data;

import com.trashdoodles.artportfolio.models.Doodle;
import com.trashdoodles.artportfolio.models.Image;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DoodleData {

    private static final Map<Integer, Image> doodles = new HashMap<>();

    public static Collection<Image> getAll() {
        return doodles.values();
    }

}
