package org.app;

import lombok.NoArgsConstructor;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@NoArgsConstructor
public class ImageAspectRatio {
    public String calculate(double width, double height){
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String result = decimalFormat.format(width/height) + ":1";
        result = result.replace(",", ".");
        return result;
    }
}
