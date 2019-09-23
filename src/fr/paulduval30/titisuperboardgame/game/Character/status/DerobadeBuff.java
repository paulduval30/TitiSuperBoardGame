package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public class DerobadeBuff extends Status
{
    public DerobadeBuff(int nbTurn)
    {
        super(nbTurn, "onDefend", "Derobade");
    }

    public boolean addTurn()
    {
        if(this.nbTurn < 2)
        {
            this.nbTurn ++;
            return true;
        }
        return false;
    }

    @Override
    public void act(Character target)
    {

    }
}
