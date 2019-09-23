package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;

public abstract class Status
{
    protected int nbTurn;
    protected String trigger;
    protected String name;
    protected Game game;

    public Status(int nbTurn, String trigger, String name, Game game)
    {
        this.name = name;
        this.nbTurn = nbTurn;
        this.trigger = trigger;
        this.game = game;
    }
    public abstract void act(Character target);

    public String getTrigger()
    {
        return trigger;
    }

    public int getNbTurn()
    {
        return nbTurn;
    }

    public String getName()
    {
        return name;
    }
}
