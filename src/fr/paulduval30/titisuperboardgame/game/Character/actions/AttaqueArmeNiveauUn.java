package fr.paulduval30.titisuperboardgame.game.Character.actions;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public class AttaqueArmeNiveauUn extends Action
{

    public AttaqueArmeNiveauUn(int po, boolean ldv, String name)
    {
        super(po,ldv, name);
    }
    @Override
    public void act(Character target, Character origin)
    {
        origin.nextAction();
        target.dammage((int)(Math.random() * 10) +1);
        System.out.println(this.name + " "+((int)(Math.random() * 10) +1));

    }
}
