package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.utils.ArrayUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CharacterMenu extends Component
{
    private int posX;
    private int posY;
    private int width;
    private int height;
    private ArrayList<Button> actions;
    private Game game;

    public CharacterMenu(Game game)
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
        gg.setColor(Color.black);
        gg.fillRect(this.posX,this.posY,this.width,this.height );
        for(int i = 0; i < actions.size(); i++)
        {
            actions.get(i).render(engine,gg);
        }
        gg.setColor(Color.white);
        gg.fillRoundRect(0,engine.getHeight() *0.8f,200,(int)(engine.getHeight()*0.8f),5,5);

        gg.setColor(Color.BLACK);
        gg.setFont(null);
        gg.drawString(this.game.getCurrentPlayer().getName(),this.posX + 20, this.posY +10);
        gg.drawString("PM : " +  this.game.getCurrentPlayer().getCurrentPM() + "",this.posX + 20, this.posY + 30);
        gg.drawString("Action : " + this.game.getCurrentPlayer().getNbAction() + "",this.posX + 20, this.posY + 50);
        gg.drawString("Life : " + this.game.getCurrentPlayer().getLife(),this.posX + 20, this.posY + 70);
    }

    @Override
    public void update(GameEngine engine)
    {
        this.posX = 0;
        this.posY = (int)(engine.getHeight() * 0.8f);
        this.height =(int)(engine.getHeight() * 0.2f);
        this.width = engine.getWidth();

        this.actions = new ArrayList<>();
        for(String key : game.getCurrentPlayer().getPowers().keySet())
        {
            this.actions.add(new ActionButton(key, 0,0,200,100,Color.WHITE, Color.DARK_GRAY, this.game, this.game.getCurrentPlayer()));
        }
        for(int i = 0; i < actions.size(); i++)
        {
            actions.get(i).setPosY(this.posY = (int)(engine.getHeight() * 0.8f) + 50);
            actions.get(i).setPosX(240 + i * 250);
            actions.get(i).update(engine);
        }

    }
}
