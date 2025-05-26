package drawingTool;

import rooster.Rooster;

import java.awt.*;
import java.util.ArrayList;

public class Scene {
    private ArrayList<Rooster> roosters;        // aggregate(s)

    public Scene(int width, int height) {
        roosters = new ArrayList<>();

        System.out.printf("Width = %d and Height = %d \n\n", width, height);

        for (int i = 0; i < 100; ++i) {
            int x = RandomNumber.between(10, width - 380);
            int y = RandomNumber.between(10, height - 350);

            Rooster newRooster = new Rooster(new Point(x, y), "Rooster " + i, Color.YELLOW, Color.ORANGE, Color.YELLOW, Color.decode("#7a5230"), Color.RED);

            System.out.printf("Rooster %d with (%d, %d) \n", i, x, y);

            if (i == 0) {
                roosters.add(newRooster);
            }
            else {
                boolean intersects = false;
                int j = 0;

                while (!intersects && j < roosters.size()) {
                    if (newRooster.intersects(roosters.get(j))) intersects = true;
                    ++j;
                }

                if (!intersects) roosters.add(newRooster);
            }
        }
    }

    public void drawRoosters() {
        for (Rooster rooster: roosters) {
            rooster.draw();
        }
    }
}
