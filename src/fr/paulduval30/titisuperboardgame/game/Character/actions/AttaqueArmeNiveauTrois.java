package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public class AttaqueArmeNiveauTrois extends Action
{
    public AttaqueArmeNiveauTrois(int po, boolean ldv,String name, boolean defendable)
    {
        super(po, ldv, name, defendable);
    }

    @Override
    public void act(Character target, Character origin)
    {
        target.dammage((int)(Math.random() * 14) +2);
        origin.nextAction();


    }
}
