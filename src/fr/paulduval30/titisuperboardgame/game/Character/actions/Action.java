package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public abstract class Action
{
    protected boolean ldv;
    protected boolean po;

    public abstract void act(Character target, Character origin);
}
