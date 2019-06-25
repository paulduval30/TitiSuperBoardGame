package fr.paulduval30.titisuperboardgame.game;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.board.Map;

import java.util.ArrayList;

public class Game
{
    private int nbPlayer;
    private ArrayList<Character> players;
    private Map map;
    private int current;
    private boolean end;

    public Game(int nbPlayer, Map map)
    {
        this.current = 0;
        this.nbPlayer = nbPlayer;
        this.players = new ArrayList<>();
        this.map = map;
        this.end = false;
    }

    public void initGame()
    {
        this.players.get(0).startTurn();
    }

    public void nextPlayer()
    {
        this.getCurrentPlayer().endTurn();
        this.current ++;
        if(this.current > this.players.size() - 1)
            this.current = 0;
        this.getCurrentPlayer().startTurn();
    }

    public Character getCurrentPlayer()
    {
        return this.players.get(this.current);
    }

    public int getCurrent()
    {
        return this.current;
    }

    public void addPlayer(Character p)
    {
        this.players.add(p);
    }

    public int getNbPlayer()
    {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer)
    {
        this.nbPlayer = nbPlayer;
    }

    public ArrayList<Character> getPlayers()
    {
        return players;
    }

    public void setPlayers(ArrayList<Character> players)
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

    public boolean moove(Character c, int line, int col)
    {
        this.getMap().getGrid()[c.getLine()][c.getCol()].setWalkable(true);
        boolean moove = c.deplacer(line, col);
        this.getMap().getGrid()[c.getLine()][c.getCol()].setWalkable(false);
        return moove;
    }
}
