package drawingTool;

import rooster.Rooster;

import java.awt.*;
import java.util.ArrayList;

public class Scene {
    private ArrayList<Rooster> roosters;        // aggregate(s)

    public Scene(int width, int height) {
        roosters = new ArrayList<>();

        // System.out.printf("Width = %d and Height = %d \n\n", width, height);

        for (int i = 0; i < 1000; ++i) {
            int x = RandomNumber.between(10, width - 380);
            int y = RandomNumber.between(10, height - 350);
            int size = RandomNumber.between(1, 2);

            Rooster newRooster = new Rooster(size, new Point(x, y), "R_" + i);

            // System.out.printf("Rooster %d with (%d, %d) and size %d \n", i, x, y, size);

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
        for (Rooster rooster : roosters) {
            rooster.draw();
        }
    }

    public void updateRoosters(boolean openMouth, boolean rockets, boolean cowboyBoot) {
        ArrayList<Rooster> tempRoosters = new ArrayList<>();

        System.out.println("Updating  roosters");

        for (Rooster rooster : roosters) {
            Point coordinate = rooster.address();
            int size = rooster.getSize();
            String name = rooster.getName();

            rooster = new Rooster(size, coordinate, name, openMouth, rockets, cowboyBoot);
            tempRoosters.add(rooster);
        }

        roosters = tempRoosters;
    }
}
