package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public abstract class Status
{
    protected int nbTurn;

    public abstract void act(Character target);
}
