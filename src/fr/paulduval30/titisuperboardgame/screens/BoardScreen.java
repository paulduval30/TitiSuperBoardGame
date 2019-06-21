package fr.paulduval30.titisuperboardgame.screens;

import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.engine.Screen;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class BoardScreen extends Screen
{
    private static int SIZE = 50;
    private final Game game;

    public BoardScreen(Game g)
    {
        super();
        this.game = g;
    }
    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        SIZE = (engine.getHeight() - 50) / game.getMap().getNbLine();
        gg.setColor(Color.BLACK);
        gg.fillRect(0,0, engine.getWidth(), engine.getHeight() );
        gg.setColor(Color.white);

        for(int i = 0; i < this.game.getMap().getNbCol(); i++)
        {
            for(int j = 0; j < this.game.getMap().getNbLine(); j ++)
            {
                gg.drawRect(20 + i * SIZE, 20 + j * SIZE, SIZE,SIZE);
            }
        }
    }

    @Override
    public void update(GameEngine engine)
    {

    }
}
