package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;

import java.awt.*;
import java.util.HashMap;

public class CharacterPicker extends Component
{
    HashMap<String, String[]> characters;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private int size;
    private String choice;

    public CharacterPicker(HashMap<String, String[]> characters)
    {
        this.characters = characters;
        this.choice = "";
    }

    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        gg.setColor(Color.BLACK);
        gg.fillRect(0,0, engine.getWidth(), engine.getHeight());
        gg.setColor(Color.WHITE);
        gg.fillRoundRect(this.posX, this.posY,this.width, this.height,10,10);
        gg.setColor(Color.DARK_GRAY);
        int line = 0;
        int col = 0;

        for(int i = 1; i <= characters.keySet().toArray().length; i++)
        {
            gg.fillRoundRect(this.posX + (col )* size,this.posY + line * size, size,size,10,10);

            if(i%10 == 0)
            {
                line ++;
                col = 0;
            }
            else
                col ++;
        }

        gg.setColor(Color.lightGray);
        gg.fillRoundRect(this.posX, this.posY + this.height, this.width, this.height / 2, 10,10);
        if(!this.choice.equals(""))
        {
            int posY2 = this.posY + this.height;
            String[] data = characters.get(choice);
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

            gg.setColor(Color.BLACK);
            Font font = new Font("arial",Font.BOLD, 20);
            gg.setFont(font);
            gg.drawString(name,this.posX, posY2 + 30);
            gg.drawString("life : " + life,this.posX + this.width / 5, posY2 + 30);
            gg.drawString("??? : " + jsaispas,this.posX + this.width / 5 * 2, posY2 + 20);
            gg.drawString("Armure : " + armure,this.posX + this.width / 5 * 3, posY2 + 20);
            gg.drawString("Coup sournois : " + coupsournois,this.posX, posY2 + this.height / 20 * 2 + 20);
            gg.drawString("PM : " + pm,this.posX  + this.width / 5, posY2 + this.height / 20 * 2 + 20);
            gg.drawString("PO : " + po,this.posX + this.width / 5 * 2, posY2 + this.height / 20 * 2 + 20);
            gg.drawString("Attaque 1 : " + att1,this.posX, posY2 + (this.height / 20) * 3 + 20);
            gg.drawString("Attaque 2 " + att2,this.posX, posY2 + (this.height / 20) * 4 + 20);
            gg.drawString("Attaque 3 " + att3,this.posX, posY2 + (this.height / 20) * 5 + 20);
        }
    }

    @Override
    public void update(GameEngine engine)
    {
        this.posX = (int)(engine.getWidth() * 0.1f);
        this.posY = (int)(engine.getHeight() * 0.1f);
        this.width = (int)(engine.getWidth() * 0.8f);
        this.size = this.width/10;
        this.height = (int)(size * (characters.keySet().toArray().length / 10));

        int mouseX = engine.getInput().getMouseX();
        int mouseY = engine.getInput().getMouseY();

        if(mouseX > this.posX && mouseX < this.posX + this.width && mouseY > this.posY && mouseY < this.posY + this.height)
        {
            mouseX -= this.posX;
            mouseY -= this.posY;

            int ligne = mouseY / size;
            int col = mouseX / size;

            this.choice = (String)characters.keySet().toArray()[ligne * 9 + col];
        }
    }
}
