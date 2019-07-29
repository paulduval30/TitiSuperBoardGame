package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public class LameDuSacrifice extends Action
{
    public LameDuSacrifice(int po, boolean ldv, String name)
    {
        super(po, ldv, name);
    }

    @Override
    public void act(Character target, Character origin)
    {
        target.health((int)(Math.random() * 10) +2);
        origin.dammage((int)(Math.random() * 18)+2);
        origin.nextAction();
    }
}
