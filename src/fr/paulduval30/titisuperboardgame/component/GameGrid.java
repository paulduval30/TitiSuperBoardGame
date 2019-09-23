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

public class GameGrid extends Component
{
    protected int size = 0;
    private Game game;
    private Image forest;
    private Image terre;
    private Image mountain;
    private Image water;
    private Image sable;
    protected int deltaX;
    protected int deltaY;

    public GameGrid(Game game)
    {
        this.game = game;
        try
        {
            this.forest = ImageIO.read(new File("res/forest.png"));
            this.water = ImageIO.read(new File("res/water.jpg"));
            this.mountain = ImageIO.read(new File("res/Mountain.png"));
            this.terre = ImageIO.read(new File("res/terre.jpg"));
            this.sable =  ImageIO.read(new File("res/sable.jpg"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        this.deltaX = 20;
        this.deltaY = 20;
    }
    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {

        gg.setColor(Color.BLACK);
//        gg.fillRect(0,0, engine.getWidth(), engine.getHeight() );
        gg.setColor(new Color(189, 137, 55));


        for(int i = 0; i < this.game.getMap().getNbCol(); i++)
        {

            for(int j = 0; j < this.game.getMap().getNbLine(); j ++)
            {

                if(this.game.getMap().getGrid()[j][i].getType().equals("forest"))
                {
                    gg.drawImage(forest,deltaX + i * this.size, deltaY + j * this.size, this.size,this.size);
                }if(this.game.getMap().getGrid()[j][i].getType().equals("sand"))
                {
                    gg.drawImage(sable,deltaX + i * this.size, deltaY + j * this.size, this.size,this.size);
                }
                if(this.game.getMap().getGrid()[j][i].getType().equals("empty"))
                {
                    gg.drawImage(terre,deltaX + i * this.size, deltaY + j * this.size, this.size,this.size);
                }
                if(this.game.getMap().getGrid()[j][i].getType().equals("water"))
                {
                    gg.drawImage(water,deltaX + i * this.size, deltaY + j * this.size, this.size,this.size);
                }
                if(this.game.getMap().getGrid()[j][i].getType().equals("mountain"))
                {
                    gg.drawImage(mountain,deltaX + i * this.size, deltaY + j * this.size, this.size,this.size);
                }
            }
        }

        if(this.game.getAction() == null && this.game.getPlayers().size() != 0)
        {
            gg.setColor(new Color(66, 244, 66,80));

            int[][] matricePoids = game.getCurrentPlayer().getMatricePoids();
            for (int i = 0; i < matricePoids.length; i++)
            {
                for (int j = 0; j < matricePoids[0].length; j++)
                {
                    if (matricePoids[i][j] <= game.getCurrentPlayer().getCurrentPM())
                    {
                        gg.fillRect(deltaX + 1 + j * this.size, deltaY + 1 + i * this.size, this.size - 1, this.size - 1);
                        gg.drawString(matricePoids[i][j] + "", deltaX + 1 + j * this.size, deltaY + 1 + i * this.size);
                    }
                }
            }
        }
        else if(this.game.getPlayers().size() != 0)
        {
            gg.setColor(new Color(150, 194, 255, 80));
            Action action = this.game.getAction();
            for(int i = 0; i < this.game.getMap().getNbLine(); i++)
            {
                for(int j = 0; j < this.game.getMap().getNbCol(); j++)
                {
                    if(Math.abs(i - this.game.getCurrentPlayer().getLine()) + Math.abs(j - this.game.getCurrentPlayer().getCol()) < action.getPo())
                    {
                            gg.fillRect(deltaX + 1 + j * this.size, deltaY + 1 + i * this.size, this.size - 1, this.size - 1);

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
            gg.fillOval(22.5f + c.getCol() * this.size, 22.5f + c.getLine() * this.size, this.size - 5, this.size - 5);
        }
    }

    @Override
    public void update(GameEngine engine)
    {
        int s1 = ((engine.getHeight() - (int)(engine.getHeight() * 0.2)) / game.getMap().getNbLine());
        int s2 = ((engine.getWidth() - (int)(engine.getWidth() * 0.4)) / game.getMap().getNbCol());
        this.size = s1 < s2 ? s1 : s2;
        if(this.size == 0)
            return;
        int line = (engine.getInput().getMouseY() - 20) / this.size;
        int col = (engine.getInput().getMouseX() - 20) / this.size;
        if(engine.getInput().isMousePressed(MouseEvent.BUTTON1))
        {

            if(line >= 0 && line < game.getMap().getNbLine() && col >= 0 && col < game.getMap().getNbCol() && this.game.getPlayers().size() != 0)
            {
                if(game.getAction() == null)
                    game.moove(game.getCurrentPlayer(),line, col);
                else if(this.game.getPlayers().size() != 0)
                {
                    Character target = game.getCharacter(line, col);
                    Character source = game.getCurrentPlayer();
                    game.getAction().act(target, source, line , col);
                    game.setState("Mooving", null);
                }
            }
        }
    }
}
