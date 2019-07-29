package fr.paulduval30.titisuperboardgame.component;

import fr.paulduval30.titisuperboardgame.engine.GameEngine;
import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ActionButton extends Button
{
    private final Character character;
    private final Game game;

    public ActionButton(String text, int posX, int posY, int width, int height, Color naturalColor, Color overColor, Game game, Character character)
    {
        super(text, posX, posY, width, height, naturalColor, overColor);
        this.game = game;
        this.character = character;
    }

    @Override
    public void update(GameEngine engine)
    {
        super.update(engine);
        if(this.isOver)
        {
            if(engine.getInput().isMousePressed(MouseEvent.BUTTON1) && this.isOver)
            {
                this.character.getActions().get(this.text).act(this.game.getPlayers().get(1), this.game.getCurrentPlayer());
            }
        }
    }
}
