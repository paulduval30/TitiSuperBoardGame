package fr.paulduval30.titisuperboardgame.game.Character;

import fr.paulduval30.titisuperboardgame.dialog.ActionDialogBox;
import fr.paulduval30.titisuperboardgame.game.Character.actions.Action;
import fr.paulduval30.titisuperboardgame.game.Character.status.Status;
import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.Team;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Character
{
    private String name;

    private int line;
    private int col;
    private int pm;
    private int currentPM;
    private int nbAction;
    private HashMap<String, Action> powers;
    private boolean isCurrent;
    private int[][] matricePoids;
    private Game game;
    private int life;
    private Team team;
    private int armorLvl;
    private int mainPowerLvl;

    private ArrayList<Status> status;

    public Character(String name, int line, int col, int pm, int nbAction, int life, Game game, Team team)
    {
        this.status = new ArrayList<>();
        this.team = team;
        this.name = name;
        this.line = line;
        this.col = col;
        this.pm = pm;
        this.currentPM = pm;
        this.life = life;
        this.nbAction = nbAction;
        this.powers = new HashMap<>();
        this.isCurrent = false;
        this.game = game;
        this.game.getMap().getGrid()[line][col].setWalkable(false);
        this.matricePoids = new int[game.getMap().getNbLine()][game.getMap().getNbCol()];

        this.calculerMatricePoids(0, this.line, this.col);
    }

    public void addStatus(Status s)
    {
        this.status.add(s);
    }

    public void resetMatricePoids()
    {

        for(int i = 0; i < matricePoids.length; i++)
        {
            for(int j = 0; j < matricePoids[i].length; j++)
            {
                this.matricePoids[i][j] = 10000;
            }
        }

    }

    /**
     * Fonction qui gère les deplacement des personnages
     * @param line la ligne ou l'on veut se deplacer
     * @param col la colonne ou l'on veut se deplacer
     * @return boolean deplacement effecttué
     */
    public boolean deplacer(int line, int col)
    {
        if(matricePoids[line][col] <= currentPM)
        {
            this.line = line;
            this.col = col;
            currentPM -= matricePoids[line][col];
            this.resetMatricePoids();
            this.calculerMatricePoids(0, this.line, this.col);
            this.nextAction();
            return  true;

        }
        this.resetMatricePoids();
        this.calculerMatricePoids(0, this.line, this.col);

        return false;
    }

    /**
     * Fonction qui renvoie le nombre de PM restant
     * @return currentPM les pm restant
     */
    public int getCurrentPM()
    {
        return this.currentPM;
    }

    /**
     * Fonction qui initie le début de tour en remettant a jours la matrice de coup, les PM et les statuts;
     */
    public void startTurn()
    {
        System.out.println(this.name);
        this.resetMatricePoids();
        this.calculerMatricePoids(0, this.line, this.col);
        this.currentPM = this.pm;
        this.isCurrent = true;
        int choice = ActionDialogBox.displayGUI(game);
        while (choice == JOptionPane.CLOSED_OPTION)
            choice = ActionDialogBox.displayGUI(game);
        Character current = game.getCurrentPlayer();
        Team t = current.getTeam();
        current.setNbAction(t.getNbAction().get(choice));
        t.takeAction(current.getNbAction());
        for(Status s : status)
        {
            s.act(this);
        }
    }

    /**
     * Fonction qui termine le tour en remettant a jours les statuts
     */
    public void endTurn()
    {
        this.isCurrent = false;

    }

    public HashMap<String, Action> getActions()
    {
        return this.powers;
    }

    public void addAction(String name, Action a)
    {
        this.powers.put(name, a);
    }

    public HashMap<String, Action> getPowers()
    {
        return powers;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLine()
    {
        return line;
    }

    public void setLine(int line)
    {
        this.line = line;
    }

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public int getPm()
    {
        return pm;
    }

    public void setPm(int pm)
    {
        this.pm = pm;
    }

    public int getNbAction()
    {
        return nbAction;
    }

    public void setNbAction(int nbAction)
    {
        this.nbAction = nbAction;
    }

    public Team getTeam()
    {
        return this.team;
    }

    public boolean isCurrent()
    {
        return this.isCurrent;
    }

    /**
     * Fonction récursive qui calcul la matrice de poids (PathFinding
     * @param id le poids actuel
     * @param ligneSource  la ligne de l'entité dont l'on calcul le poids
     * @param colSource la colonne de l'entite dont l'on calcul le poids
     */
    private void calculerMatricePoids(int id, int ligneSource, int colSource)
    {
        this.matricePoids[ligneSource][colSource] = id;
        //id += this.game.getMap().getCost(ligneSource, colSource);
        if(id <= this.pm)
        {
            if(ligneSource - 1 >= 0 && this.game.getMap().getGrid()[ligneSource - 1][colSource].isWalkable()
                    && matricePoids[ligneSource - 1][colSource] > id)
            {
                this.calculerMatricePoids(id + this.game.getMap().getCost(ligneSource - 1, colSource), ligneSource - 1, colSource);
            }
            if(ligneSource + 1 < this.game.getMap().getNbLine() && this.game.getMap().getGrid()[ligneSource + 1][colSource].isWalkable()
                    && matricePoids[ligneSource + 1][colSource] > id)
                this.calculerMatricePoids(id  + this.game.getMap().getCost(ligneSource + 1, colSource), ligneSource + 1, colSource);
            if(colSource - 1 >= 0 && this.game.getMap().getGrid()[ligneSource][colSource - 1].isWalkable()
                    && matricePoids[ligneSource][colSource - 1] > id)
                this.calculerMatricePoids(id + this.game.getMap().getCost(ligneSource, colSource - 1), ligneSource, colSource - 1);
            if(colSource + 1 < this.game.getMap().getNbCol() && this.game.getMap().getGrid()[ligneSource][colSource + 1].isWalkable()
                    && matricePoids[ligneSource][colSource + 1] > id)
                this.calculerMatricePoids(id + this.game.getMap().getCost(ligneSource, colSource + 1), ligneSource, colSource + 1);
        }
    }

    public int[][] getMatricePoids()
    {
        return this.matricePoids;
    }

    public void act(String action)
    {
        //Dammage:source,target,value:Soin:source,target,value:position:source,target
    }

    public void take(String action)
    {

    }

    public int getLife()
    {
        return life;
    }

    public void dammage(int dammage)
    {
        this.life -= dammage;
    }

    public int defend()
    {
        if(this.armorLvl == 1)
        {
            return (int)(Math.random() * 10) + 2;
        }
        if(this.armorLvl == 2)
        {
            return (int)(Math.random() * 12) + 2;
        }
        if(this.armorLvl == 3)
        {
            return (int)(Math.random() * 19) + 1;
        }

        return 0;
    }

    public void health(int health)
    {
        this.life += health;
    }

    public void nextAction()
    {
        this.nbAction --;
        this.resetMatricePoids();
        this.calculerMatricePoids(0, this.line, this.col);
        this.currentPM = this.pm;
        this.isCurrent = true;
        if(this.nbAction <= 0)
        {
            this.game.nextPlayer();
        }


    }
}
