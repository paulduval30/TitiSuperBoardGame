package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public abstract class Action
{
    protected final String name;
    protected boolean ldv;
    protected int po;

    public Action(int po, boolean ldv,String name)
    {
        this.po = po;
        this.ldv = ldv;
        this.name = name;
    }

    public abstract void act(Character target, Character origin);

    public int getPo()
    {
        return po;
    }
}
