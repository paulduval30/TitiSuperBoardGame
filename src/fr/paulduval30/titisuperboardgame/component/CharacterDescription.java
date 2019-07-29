package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.Component;
import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.engine.GameGraphics;
import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.awt.*;

public class CharacterDescription extends Component
{

    private Character character;
    private int posX;
    private  int posY;
    private int width;
    private int height;
    private Game game;

    public CharacterDescription(Character character, Game game)
    {
        this.game = game;
        this.character = character;
    }

    public void setCharacter()
    {

    }

    @Override
    public void init()
    {

    }

    @Override
    public void render(GameEngine engine, GameGraphics gg)
    {
        gg.setColor(Color.WHITE);
        Font font = new Font("arial",Font.BOLD, 24);
        gg.setFont(font);
        gg.fillRoundRect(posX, posY, width, height, 5, 5);
        gg.setColor(Color.BLACK);
        gg.drawString(this.character.getName(),this.posX + 20, this.posY + 20);
        gg.drawString("PM : " +  this.character.getCurrentPM() + "",this.posX + 20, this.posY + 50);
        gg.drawString("Action : " + this.character.getNbAction() + "",this.posX + 20, this.posY + 80);
        gg.drawString("Life : " + this.character.getLife(),this.posX + 20, this.posY + 110);

    }

    @Override
    public void update(GameEngine engine)
    {
        int s1 = ((engine.getHeight() - (int)(engine.getHeight() * 0.2)) / game.getMap().getNbLine());
        int s2 = ((engine.getWidth() - (int)(engine.getWidth() * 0.4)) / game.getMap().getNbCol());
        int size = s1 < s2 ? s1 : s2;
        this.posX = size * game.getMap().getNbCol() + 20;
        this.posY = 0;
        this.width = engine.getWidth() - this.posX;
        this.height = (int)(engine.getHeight() * 0.8);

        int line = (engine.getInput().getMouseY() - 20) / size;
        int col = (engine.getInput().getMouseX() - 20) / size;

        if(game.getCharacter(line, col) != null)
        {
            this.character = game.getCharacter(line, col);
        }
    }
}
