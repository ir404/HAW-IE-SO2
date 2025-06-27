package drawingTool;

import rooster.Rooster;
import rooster.decorators.BowTieDecorator;
import rooster.decorators.HatDecorator;

import java.awt.*;
import java.util.ArrayList;

public class Scene {
    private ArrayList<LocatedRectangle> roosters;        // aggregate(s)
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
            int x = RandomNumber.between(0, width);
            int y = RandomNumber.between(0, height);
            int size = RandomNumber.between(1, 2);

            LocatedRectangle newRooster = new Rooster(size, new Point(x, y), Color.YELLOW, Color.DARK_GRAY);
            LocatedRectangle  tempRoosterAtBottom = new Rooster(size, new Point(x, height), Color.YELLOW, Color.DARK_GRAY);
            LocatedRectangle tempRoosterAtRight = new Rooster(size, new Point(width, y), Color.YELLOW, Color.DARK_GRAY);

            boolean intersects = newRooster.intersects(tempRoosterAtBottom) || newRooster.intersects(tempRoosterAtRight);
            int j = 0;
            while (!intersects && j < roosters.size()) {
                if (newRooster.intersects(roosters.get(j))) intersects = true;
                ++j;
            }

            if (!intersects) {
                int number = RandomNumber.between(1, 100);

                if (number % 3 == 0 && number % 5 == 0)
                    newRooster = new BowTieDecorator(new HatDecorator(newRooster));
                else if (number % 3 == 0)
                    newRooster = new BowTieDecorator(newRooster);
                else
                    newRooster = new HatDecorator(newRooster);

                roosters.add(newRooster);
            }
        }
    }

    public void drawRoosters() {
        for (LocatedRectangle rooster: roosters) {
            rooster.draw();
        }
    }

    public void updateRoosters(boolean openMouth, boolean rockets, boolean cowboyBoot, boolean hat, boolean bowTie, Color headColour, Color eyeColour) {
        ArrayList<LocatedRectangle> tempRoosters = new ArrayList<>();

        for (LocatedRectangle rooster: roosters) {
            int size = rooster.getSize();
            Point coordinate = rooster.address();

            rooster = new Rooster(size, coordinate, headColour, eyeColour, openMouth, rockets, cowboyBoot);

            if (hat) rooster = new HatDecorator(rooster);

            if (bowTie) rooster = new BowTieDecorator(rooster);

            tempRoosters.add(rooster);
        }

        roosters = tempRoosters;
    }
}
