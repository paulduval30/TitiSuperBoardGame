package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;

import java.awt.*;

public class Poison extends Status
{

    public Poison(int nbTurn, Game game)
    {
        super(nbTurn, "onTurn", "Poison", game);
    }
    @Override
    public void act(Character target)
    {
        target.dammage(20);
    }
}
