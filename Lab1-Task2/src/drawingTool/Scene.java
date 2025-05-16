package drawingTool;

import rooster.Rooster;

import java.awt.*;
import java.util.ArrayList;

public class Scene {
    private ArrayList<Rooster> roosters = new ArrayList<>();

    public void drawRoosters(int roosterCount) {
        for (int i = 0; i < roosterCount; ++i) {
            Point placeAt = new Point(250 * i, 150 * i);
            Rooster tempRooster = new Rooster(placeAt, "Rooster " + i, Color.YELLOW, Color.ORANGE, Color.YELLOW, Color.RED, Color.RED);

            if (i > 0) {
                if (!roosters.get(roosters.size() - 1).intersects(tempRooster)) {
                    tempRooster.draw();
                    roosters.add(tempRooster);
                }
            }
            else {
                tempRooster.draw();
                roosters.add(tempRooster);
            }
        }
    }
}
