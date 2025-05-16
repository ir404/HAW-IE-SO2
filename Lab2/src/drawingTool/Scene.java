package drawingTool;

import rooster.Rooster;

import java.awt.*;
import java.util.ArrayList;

public class Scene {
    private ArrayList<Rooster> roosters = new ArrayList<>();

    public void drawRoosters() {
        Rooster ricky = new Rooster(new Point(0, 0), "Ricky", Color.YELLOW, Color.ORANGE, Color.YELLOW, Color.decode("#7a5230"), Color.RED);
        Rooster ron = new Rooster(new Point(500, 10), "Ron", Color.YELLOW, Color.ORANGE, Color.YELLOW, Color.decode("#7a5230"), Color.RED);
        Rooster ross = new Rooster(new Point(1000, 200), "Ross", Color.YELLOW, Color.ORANGE, Color.YELLOW, Color.decode("#7a5230"), Color.RED);
        Rooster robert = new Rooster(new Point(300, 400), "Robert", Color.YELLOW, Color.ORANGE, Color.YELLOW, Color.decode("#7a5230"), Color.RED);

        ricky.draw();

        if (!ron.intersects(ricky)) ron.draw();

        if (!ross.intersects(ricky) && !ross.intersects(ron)) ross.draw();

        if (!robert.intersects(ricky) && !robert.intersects(ron) && !robert.intersects(ross)) robert.draw();
    }
}
