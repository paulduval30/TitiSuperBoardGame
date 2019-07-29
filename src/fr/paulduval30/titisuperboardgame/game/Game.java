package fr.paulduval30.titisuperboardgame.game;

import fr.paulduval30.titisuperboardgame.game.Character.Character;
import fr.paulduval30.titisuperboardgame.game.Character.actions.Action;
import fr.paulduval30.titisuperboardgame.game.board.Map;

import java.util.ArrayList;

public class Game
{
    private int nbPlayer;
    private ArrayList<Character> players;
    private ArrayList<Team> teams;
    private Map map;
    private int current;
    private boolean end;
    private Action action;

    public Game(int nbPlayer, Map map)
    {
        this.current = 0;
        this.nbPlayer = nbPlayer;
        this.players = new ArrayList<>();
        this.teams = new ArrayList<>();
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

    public Character getCharacter(int line, int col)
    {
        for(Character c : players)
        {
            if(c.getLine() == line && c.getCol() == col)
                return c;
        }
        return  null;
    }

    public Character getCurrentPlayer()
    {
        return this.players.get(this.current);
    }

    public int getCurrent()
    {
        return this.current;
    }

    public void addPlayer(Character p, Team team)
    {
        for(Team t : teams)
        {
            if(t.equals(team))
            {
                team.addCharacter(p);
                this.players.add(p);
                return;
            }
        }
        this.teams.add(team);
        team.addCharacter(p);
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

    public void setState(String state, Action action)
    {
        this.action = action;
    }

    public Action getAction()
    {
        return action;
    }
}
