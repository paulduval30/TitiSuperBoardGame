package fr.paulduval30.titisuperboardgame.game;

import fr.paulduval30.titisuperboardgame.game.board.Map;

public class Game
{
    private int nbPlayer;
    private Character[] players;
    private Map map;

    public Game(int nbPlayer, Character[] players, Map map)
    {
        this.nbPlayer = nbPlayer;
        this.players = players;
        this.map = map;
    }

    public int getNbPlayer()
    {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer)
    {
        this.nbPlayer = nbPlayer;
    }

    public Character[] getPlayers()
    {
        return players;
    }

    public void setPlayers(Character[] players)
    {
        this.players = players;
    }

    public Map getMap()
    {
        return map;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }
}
