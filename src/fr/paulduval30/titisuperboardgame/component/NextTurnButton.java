package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.awt.*;
import java.awt.event.MouseEvent;

public class NextTurnButton extends Button
{
    private Game game;
    public NextTurnButton(String text, int posX, int posY, int width, int height, Color naturalColor, Color overColor, Game game)
    {
        super(text,posX, posY, width, height, naturalColor, overColor);
        this.game = game;
    }

    @Override
    public void update(GameEngine engine)
    {
        super.update(engine);
        this.posY = (int)(engine.getHeight() * 0.8f) + 50;
        this.posX = 20;
        this.width = 100;
        this.height = 50;
        if(this.isOver)
        {
            if(engine.getInput().isMousePressed(MouseEvent.BUTTON1) && this.isOver)
            {
                game.nextPlayer();
            }
        }
    }
}
