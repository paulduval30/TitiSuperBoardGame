package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public class LameDuSacrifice extends Action
{
    public LameDuSacrifice(int po, boolean ldv,String name, boolean defendable)
    {
        super(po, ldv, name, defendable);
    }

    @Override
    public void act(Character target, Character origin)
    {
        target.health((int)(Math.random() * 10) +2);
        origin.dammage((int)(Math.random() * 19) + 1);
        origin.nextAction();
    }
}
