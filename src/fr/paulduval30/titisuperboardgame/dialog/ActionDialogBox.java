package fr.paulduval30.titisuperboardgame.dialog;

import fr.paulduval30.titisuperboardgame.game.Game;
import fr.paulduval30.titisuperboardgame.game.Team;

import javax.swing.*;
import java.util.ArrayList;

public class ActionDialogBox
{
    public static int displayGUI(Game game) {
        return JOptionPane.showOptionDialog(null,
                getPanel(),
                "Action picker : ",
                JOptionPane.CLOSED_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                getOptions(game),
                getOptions(game)[0]);

    }


    private static JPanel getPanel()
    {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Nombre d'action");
        panel.add(label);

        return panel;
    }

    private static Object[] getOptions(Game game)
    {
        Team team = game.getCurrentPlayer().getTeam();
        ArrayList<Integer> nbAction = team.getNbAction();

        Object[] options = new Object[nbAction.size()];

        for(int i = 0; i < nbAction.size(); i++)
        {
            options[i] = nbAction.get(i);
        }

        return options;
    }

}
