package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public class AttaqueArmeNiveauDeux extends Action
{
    public AttaqueArmeNiveauDeux(int po, boolean ldv, String name)
    {
        super(po, ldv, name);
    }

    @Override
    public void act(Character target, Character origin)
    {
        target.dammage((int)(Math.random() * 10) +2);
        origin.nextAction();


    }
}
