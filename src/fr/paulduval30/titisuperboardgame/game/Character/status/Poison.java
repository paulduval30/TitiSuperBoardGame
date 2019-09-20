package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

import java.awt.*;

public class Poison extends Status
{

    public Poison(int time)
    {
        this.nbTurn = time;
    }
    @Override
    public void act(Character target)
    {
        target.dammage(20);
    }
}
