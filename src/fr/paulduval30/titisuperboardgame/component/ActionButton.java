package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.GameEngine;

import java.awt.*;

public class ActionButton extends Button
{
    public ActionButton(String text, int posX, int posY, int width, int height, Color naturalColor, Color overColor)
    {
        super(text, posX, posY, width, height, naturalColor, overColor);
    }

    @Override
    public void update(GameEngine engine)
    {
        super.update(engine);
        this.posY = (int)(engine.getHeight() * 0.8f) + 50;
        this.posX = 170;
        this.width = 100;
        this.height = 50;
    }
}
