package com.trashdoodles.artportfolio.data;

import com.trashdoodles.artportfolio.models.Doodle;
import com.trashdoodles.artportfolio.models.Painting;
import com.trashdoodles.artportfolio.models.Image;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PaintingData {

    private static final Map<Integer, Painting> paintings = new HashMap<>();

    public static Collection<Painting> getAll() {
        return paintings.values();
    }
}
