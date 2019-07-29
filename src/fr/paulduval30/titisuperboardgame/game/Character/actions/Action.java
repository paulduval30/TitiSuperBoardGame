package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public abstract class Action
{
    protected boolean ldv;
    protected int po;

    public Action(int po, boolean ldv)
    {
        this.po = po;
        this.ldv = ldv;
    }

    public abstract void act(Character target, Character origin);
}
