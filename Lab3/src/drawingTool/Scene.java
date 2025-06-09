package drawingTool;

import rooster.Rooster;

import java.awt.*;
import java.util.ArrayList;

public class Scene {
    private ArrayList<Rooster> roosters;        // aggregate(s)
    private int width, height;

    public Scene(int width, int height, int attempts) {
        this.width = width;
        this.height = height;
        roosters = new ArrayList<>();
        generateRoosters(attempts);
    }

    public Scene(int width, int height) {
        this(width, height, 1000);
    }

    private void generateRoosters(int attempts) {
        for (int i = 0; i < attempts; ++i) {
            int x = RandomNumber.between(10, width);
            int y = RandomNumber.between(10, height);
            int size = RandomNumber.between(1, 2);

            Rooster newRooster = new Rooster(size, new Point(x, y), "R_" + i);
            Rooster  tempRoosterAtBottom = new Rooster(size, new Point(x, height), "Temp Rooster at Bottom");
            Rooster tempRoosterAtRight = new Rooster(size, new Point(width, y), "Temp Rooster at Right");

            boolean intersects = newRooster.intersects(tempRoosterAtBottom) || newRooster.intersects(tempRoosterAtRight);
            int j = 0;
            while (!intersects && j < roosters.size()) {
                if (newRooster.intersects(roosters.get(j)))
                    intersects = true;
                ++j;
            }

            if (!intersects) roosters.add(newRooster);
        }
    }

    public void drawRoosters() {
        for (Rooster rooster : roosters) {
            rooster.draw();
        }
    }

    public void updateRoosters(boolean openMouth, boolean rockets, boolean cowboyBoot) {
        ArrayList<Rooster> tempRoosters = new ArrayList<>();

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
