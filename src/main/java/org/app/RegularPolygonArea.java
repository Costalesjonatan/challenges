package org.app;

import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor
public class RegularPolygonArea {
    public double calculate(int sideQuantity, double sideLength) {
        if(sideLength <= 0 || sideQuantity <= 0) {
            return 0;
        }
        double angle = 360d/(2*sideQuantity);
        double divider = 2*(Math.tan(Math.toRadians(angle)));
        double apothem = sideLength/divider;
        double perimeter = sideQuantity * sideLength;
        return (apothem * perimeter) / 2d;
    }
}
