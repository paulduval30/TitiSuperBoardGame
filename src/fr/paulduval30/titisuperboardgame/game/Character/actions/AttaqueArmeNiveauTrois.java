package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public class AttaqueArmeNiveauTrois extends Action
{
    public AttaqueArmeNiveauTrois(int po, boolean ldv)
    {
        super(po, ldv);
    }

    @Override
    public void act(Character target, Character origin)
    {
        origin.nextAction();
        target.dammage(20);
    }
}
