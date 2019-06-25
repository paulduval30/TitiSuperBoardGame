package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.utils.ArrayUtils;

import java.awt.*;

public class CharacterMenu extends Component
{
    private int posX;
    private int posY;
    private int width;
    private int height;
    private Button nextTurn;

    public CharacterMenu(Game game)
    {
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

    }

    @Override
    public void update(GameEngine engine)
    {
        nextTurn.update(engine);
        this.posX = 0;
        this.posY = (int)(engine.getHeight() * 0.8f) + 20;
        this.height =(int)(engine.getHeight() * 0.2f);
        this.width = engine.getWidth();
    }
}
