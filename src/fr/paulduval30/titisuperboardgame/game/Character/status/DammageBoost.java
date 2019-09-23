package fr.paulduval30.titisuperboardgame.game.Character.status;

import fr.paulduval30.titisuperboardgame.game.Character.Character;

public class DammageBoost extends Status
{
    private int dommageMin;
    private int dommageMax;
    public DammageBoost(int nbTurn, int dommageMin, int dommageMax)
    {
        super(nbTurn, "onHit", "DommageBoost");
        this.nbTurn = 1;
        this.dommageMin = dommageMin;
        this.dommageMax = dommageMax;
    }
    @Override
    public void act(Character target)
    {
        if(this.nbTurn != 0)
        {
            int dammage = (int) (Math.random() * (dommageMax - dommageMin)) + dommageMin;
            System.out.println("Dammage Boost dealt "  + dammage);
            target.dammage(dammage);
            this.nbTurn --;
        }
    }
}
