package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Character.Character;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CharacterPickDescription extends Component
{
    private String[] data;
    private Character character;
    private Boolean state;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int size;

    public CharacterPickDescription(String[] data, Boolean state)
    {
        this.data = data;
        this.state = state;
    }
    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        if(state && data != null)
        {
            gg.setColor(Color.BLACK);
            gg.fillRoundRect(this.posX, this.posY, this.width, this.height,10,10);

            gg.setColor(Color.WHITE);
            String name = data[0];
            String life = data[1];
            String armure = data[2];
            String jsaispas = data[3];
            String coupsournois = data[4];
            String pm = data[5];
            String po = data[6];
            String att1 = data[7];
            String att2 = data[8];
            String att3 = data[9];

            Font font = new Font("arial",Font.BOLD, 20);
            gg.setFont(font);
            gg.drawString(name,this.posX, posY + 30);
            gg.drawString("life : " + life,this.posX + this.width / 5, posY + 30);
            gg.drawString("Niveau d'arme " + jsaispas,this.posX + this.width / 5 * 2, posY + 20);
            gg.drawString("Armure : " + armure,this.posX + this.width / 5 * 3, posY + 20);
            gg.drawString("Coup sournois : " + coupsournois,this.posX, posY + this.height / 20 * 2 + 20);
            gg.drawString("PM : " + pm,this.posX  + this.width / 5, posY + this.height / 20 * 2 + 20);
            gg.drawString("PO : " + po,this.posX + this.width / 5 * 2, posY + this.height / 20 * 2 + 20);
            gg.drawString("Attaque 1 : " + att1,this.posX, posY + (this.height / 20) * 3 + 20);
            gg.drawString("Attaque 2 " + att2,this.posX, posY + (this.height / 20) * 4 + 20);
            gg.drawString("Attaque 3 " + att3,this.posX, posY + (this.height / 20) * 5 + 20);
        }
    }

    @Override
    public void update(GameEngine engine)
    {
        this.posX = (int)(engine.getWidth() * 0.1f);
        this.posY = (int)(engine.getHeight() * 0.1f);
        this.width = (int)(engine.getWidth() * 0.8f);
        this.height = (int)(engine.getHeight() * 0.8f);

        int mouseX = engine.getInput().getMouseX();
        int mouseY = engine.getInput().getMouseY();

        if(mouseX < this.posX || mouseX > this.posX + width || mouseY < this.posY || mouseY > this.posY + this.height)
        {
            if(engine.getInput().isMousePressed(MouseEvent.BUTTON1))
            {
                this.state = false;
            }
        }
    }

    public String[] getData()
    {
        return data;
    }

    public void setData(String[] data)
    {
        this.data = data;
    }

    public Boolean getState()
    {
        return state;
    }

    public void setState(Boolean state)
    {
        this.state = state;
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

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
}
