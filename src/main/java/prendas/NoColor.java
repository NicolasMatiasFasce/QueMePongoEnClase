package prendas;

import java.awt.*;

class NoColor extends Color {

    public static final NoColor NO_COLOR = new NoColor();

    // super(0,0,0) porque solo admiten int entre 0 y 255
    private NoColor() {
        super(0, 0, 0);
    }

    // Para el equals, siempre debe dar false
    @Override
    public int getRGB() {
        return -1;
    }

}
