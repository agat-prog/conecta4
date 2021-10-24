package usantatecla.connect4.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Color {

    RED,
    YELLOW,
    NULL;

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public boolean isNull() {
        return this == Color.NULL;
    }

    public static List<Color> getAll() {
	       List<Color> colors = new ArrayList<>(Arrays.asList(Color.values()));
	        colors.remove(Color.NULL);
	        return colors;
	}
    
}
