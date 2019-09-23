package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

import java.awt.*;

public class Poison extends Status
{

    public Poison(int nbTurn)
    {
        super(nbTurn, "onTurn", "Poison");
    }
    @Override
    public void act(Character target)
    {
        target.dammage(20);
    }
}
