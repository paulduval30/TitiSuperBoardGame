package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GameGrid extends Component
{
    private static int SIZE = 0;
    private Game game;

    public GameGrid(Game game)
    {
        this.game = game;
    }
    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        SIZE = ((engine.getHeight() - (int)(engine.getHeight() * 0.2)) / game.getMap().getNbLine());
        gg.setColor(Color.GRAY);
        gg.fillRect(0,0, engine.getWidth(), engine.getHeight() );
        gg.setColor(Color.BLACK);

        for(int i = 0; i < this.game.getMap().getNbCol(); i++)
        {
            for(int j = 0; j < this.game.getMap().getNbLine(); j ++)
            {
                gg.drawRect(20 + i * SIZE, 20 + j * SIZE, SIZE,SIZE);
            }
        }

        gg.setColor(new Color(66, 244, 66,75));
        int[][] matricePoids = game.getCurrentPlayer().getMatricePoids();
        for(int i = 0; i < matricePoids.length; i++)
        {
            for(int j = 0; j < matricePoids.length; j++)
            {
                if(matricePoids[i][j] <= game.getCurrentPlayer().getCurrentPM())
                {
                    gg.fillRect(21 + j * SIZE, 21 + i * SIZE, SIZE - 1, SIZE - 1);
                }
            }
        }
        for(Character c : game.getPlayers())
        {
            if(c.isCurrent())
                gg.setColor(Color.GREEN);
            else
                gg.setColor(Color.BLUE);
            gg.fillOval(22.5f + c.getCol() * SIZE, 22.5f + c.getLine() * SIZE, SIZE - 5, SIZE - 5);
        }
    }

    @Override
    public void update(GameEngine engine)
    {
        int line = (engine.getInput().getMouseY() - 20) / SIZE;
        int col = (engine.getInput().getMouseX() - 20) / SIZE;
        if(line >= 0 && line < game.getMap().getNbLine() && col >= 0 && col < game.getMap().getNbCol())
        {
            System.out.println(game.getMap().getGrid()[line][col].isWalkable());
        }
        if(engine.getInput().isMousePressed(MouseEvent.BUTTON1))
        {


            System.out.println(line + " " + col + " " + (line >= 0 && line < game.getMap().getNbLine() && col <= 0 && col < game.getMap().getNbCol()));
            if(line >= 0 && line < game.getMap().getNbLine() && col >= 0 && col < game.getMap().getNbCol())
            {
                game.moove(game.getCurrentPlayer(),line, col);
            }
        }
    }
}
