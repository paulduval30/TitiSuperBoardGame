package fr.paulduval30.titisuperboardgame.screens;

import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.engine.Screen;

import java.awt.*;

public class MainScreen extends Screen
{
    private static int SIZE = 50;
    private static int LINE = 20;
    private static int COL = 20;
    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        gg.setColor(Color.BLACK);
        gg.fillRect(0,0, engine.getWidth(), engine.getHeight() );
        gg.setColor(Color.white);

        for(int i = 0; i < COL; i++)
        {
            for(int j = 0; j < LINE; j ++)
            {
                gg.drawRect(i * SIZE, j * SIZE, SIZE,SIZE);
            }
        }
    }

    @Override
    public void update(GameEngine engine)
    {
        System.out.println(engine.getInput().getMouseX() / 50);
    }
}
