package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.board.Map;

public abstract class Action
{
    protected final String name;
    protected boolean ldv;
    protected int po;
    protected boolean defendable;
    protected Game game;

    public Action(int po, boolean ldv,String name, boolean defendable, Game game)
    {
        this.defendable = defendable;
        this.po = po;
        this.ldv = ldv;
        this.name = name;
        this.game = game;
    }

    public abstract void act(Character target, Character origin, int line, int col);

    public boolean isDefendable()
    {
        return defendable;
    }
    public int getPo()
    {
        return po;
    }
}
