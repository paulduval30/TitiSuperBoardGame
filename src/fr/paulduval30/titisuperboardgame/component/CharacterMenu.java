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
    private Button nextTurn;
    private ArrayList<Button> actions;
    private Game game;

    public CharacterMenu(Game game)
    {
        this.game = game;
        this.nextTurn = new NextTurnButton("Next Turn",0,0,0,0,Color.WHITE, Color.BLUE, game);

    }


    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        gg.setColor(Color.BLACK);
        gg.fillRect(this.posX,this.posY,this.width,this.height );
        nextTurn.render(engine,gg);
        for(int i = 0; i < actions.size(); i++)
        {
            actions.get(i).render(engine,gg);
        }

    }

    @Override
    public void update(GameEngine engine)
    {
        nextTurn.update(engine);
        this.posX = 0;
        this.posY = (int)(engine.getHeight() * 0.8f) + 20;
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
            actions.get(i).setPosX(170 + i * 250);
            actions.get(i).update(engine);
        }
    }
}
