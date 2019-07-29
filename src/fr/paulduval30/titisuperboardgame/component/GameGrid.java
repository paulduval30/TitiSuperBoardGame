package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Character.actions.Action;
import fr.paulduval30.titisuperboardgame.game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameGrid extends Component
{
    private static int SIZE = 0;
    private Game game;
    private Image forest;
    private Image mountain;
    private Image water;

    public GameGrid(Game game)
    {
        this.game = game;
        try
        {
            this.forest = ImageIO.read(new File("res/forest.png"));
            this.water = ImageIO.read(new File("res/water.jpg"));
            this.mountain = ImageIO.read(new File("res/Mountain.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        int s1 = ((engine.getHeight() - (int)(engine.getHeight() * 0.2)) / game.getMap().getNbLine());
        int s2 = ((engine.getWidth() - (int)(engine.getWidth() * 0.4)) / game.getMap().getNbCol());
        SIZE = s1 < s2 ? s1 : s2;
        gg.setColor(Color.BLACK);
        gg.fillRect(0,0, engine.getWidth(), engine.getHeight() );
        gg.setColor(new Color(189, 137, 55));

        for(int i = 0; i < this.game.getMap().getNbCol(); i++)
        {
            for(int j = 0; j < this.game.getMap().getNbLine(); j ++)
            {
                gg.fillRect(20 + i * SIZE, 20 + j * SIZE, SIZE,SIZE);
                if(this.game.getMap().getGrid()[j][i].getType().equals("forest"))
                {
                    gg.drawImage(forest,20 + i * SIZE, 20 + j * SIZE, SIZE,SIZE);
                }
                if(this.game.getMap().getGrid()[j][i].getType().equals("water"))
                {
                    gg.drawImage(water,20 + i * SIZE, 20 + j * SIZE, SIZE,SIZE);
                }
                if(this.game.getMap().getGrid()[j][i].getType().equals("mountain"))
                {
                    gg.drawImage(mountain,20 + i * SIZE, 20 + j * SIZE, SIZE,SIZE);
                }

            }
        }

        if(this.game.getAction() == null)
        {
            gg.setColor(new Color(66, 244, 66,75));

            int[][] matricePoids = game.getCurrentPlayer().getMatricePoids();
            for (int i = 0; i < matricePoids.length; i++)
            {
                for (int j = 0; j < matricePoids[0].length; j++)
                {
                    if (matricePoids[i][j] <= game.getCurrentPlayer().getCurrentPM())
                    {
                        gg.fillRect(21 + j * SIZE, 21 + i * SIZE, SIZE - 1, SIZE - 1);
                        gg.drawString(matricePoids[i][j] + "", 21 + j * SIZE, 21 + i * SIZE);
                    }
                }
            }
        }
        else
        {
            gg.setColor(new Color(150, 194, 255, 75));
            Action action = this.game.getAction();
            for(int i = 0; i < this.game.getMap().getNbLine(); i++)
            {
                for(int j = 0; j < this.game.getMap().getNbCol(); j++)
                {
                    if(Math.abs(i - this.game.getCurrentPlayer().getLine()) + Math.abs(j - this.game.getCurrentPlayer().getCol()) < action.getPo())
                    {
                        gg.fillRect(21 + j * SIZE, 21 + i * SIZE, SIZE - 1, SIZE - 1);

                    }
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
        if(SIZE == 0)
            return;
        int line = (engine.getInput().getMouseY() - 20) / SIZE;
        int col = (engine.getInput().getMouseX() - 20) / SIZE;
        if(engine.getInput().isMousePressed(MouseEvent.BUTTON1))
        {

            System.out.println(line + " " + col + " " + (line >= 0 && line < game.getMap().getNbLine() && col <= 0 && col < game.getMap().getNbCol()));
            if(line >= 0 && line < game.getMap().getNbLine() && col >= 0 && col < game.getMap().getNbCol())
            {
                if(game.getAction() == null)
                    game.moove(game.getCurrentPlayer(),line, col);
                else
                {
                    Character target = game.getCharacter(line, col);
                    Character source = game.getCurrentPlayer();
                    game.getAction().act(target, source);
                    game.setState("Mooving", null);
                }
            }
        }
    }
}
