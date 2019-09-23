package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public abstract class Status
{
    protected int nbTurn;
    protected String trigger;
    protected String name;

    public Status(int nbTurn, String trigger, String name)
    {
        this.name = name;
        this.nbTurn = nbTurn;
        this.trigger = trigger;
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
