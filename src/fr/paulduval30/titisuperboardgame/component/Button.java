package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;

import java.awt.*;

public class Button extends Component
{
    protected int posX;
    protected int posY;
    protected int width;
    protected int height;
    protected Color naturalColor;
    protected Color overColor;
    protected boolean isOver;
    protected String text;

    public Button(String text, int posX, int posY, int width, int height, Color naturalColor, Color overColor)
    {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.naturalColor = naturalColor;
        this.overColor = overColor;
        this.text = text;
    }

    public int getPosX()
    {
        return posX;
    }

    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    public int getPosY()
    {
        return posY;
    }

    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Color getNaturalColor()
    {
        return naturalColor;
    }

    public void setNaturalColor(Color naturalColor)
    {
        this.naturalColor = naturalColor;
    }

    public Color getOverColor()
    {
        return overColor;
    }

    public void setOverColor(Color overColor)
    {
        this.overColor = overColor;
    }

    public boolean isOver()
    {
        return this.isOver;
    }



    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        if(this.isOver)
            gg.setColor(naturalColor);
        else
            gg.setColor(overColor);
        gg.fillRect(this.posX, this.posY, this.width,this.getHeight());
        gg.setColor(Color.RED);
        gg.drawString(this.text, this.posX + 10, this.posY + this.height / 2 + 5);
    }

    @Override
    public void update(GameEngine engine)
    {
        if(engine.getInput().getMouseX() >= this.posX && engine.getInput().getMouseX() <= this.posX + this.width
                && engine.getInput().getMouseY() >= this.posY && engine.getInput().getMouseY() < this.posY + this.height)
        {
            isOver = true;
        }
        else
            isOver = false;

    }
}
