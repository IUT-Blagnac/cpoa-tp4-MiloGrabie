package application.actionList;

import application.ApplicationContexteAgenceBancaire;
import application.action.Action;
import application.action.ActionList;
import banque.AgenceBancaire;

import java.util.ArrayList;

public class ActionListAgenceBancaire implements ActionList<ApplicationContexteAgenceBancaire> {

    private String message;
    private String code;
    private ArrayList<Action> actionList = new ArrayList<>();
    private String title;

    public ActionListAgenceBancaire(String message, String code, String title) {
        this.message = message;
        this.code = code;
        this.title = title;
    }

    @Override
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return actionList.size();
    }

    @Override
    public boolean addAction(Action<ApplicationContexteAgenceBancaire> appContextAB, int index) {
        if ((index < 0) || (index > size())) return false;
        actionList.set(index, appContextAB);
        return true;
    }

    @Override
    public boolean removeAction(int index) {
        if ((index < 0) || (index > size())) return false;
        actionList.remove(index);
        return false;
    }

    @Override
    public boolean removeAction(Action<ApplicationContexteAgenceBancaire> appContextAB) {
        if (!actionList.contains(appContextAB)) return false;
        actionList.remove(appContextAB);
        return false;
    }

    @Override
    public String[] listOfActions() {
        String[] listMsgActions = new String[actionList.size()];
        for (int i = 0; i < actionList.size(); i++)
            listMsgActions[i] = actionList.get(i).actionMessage();
        return listMsgActions;
    }

    public boolean addAction(Action action){
        if (actionList.contains(action)) return false;
        actionList.add(action);
        return true;
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(ApplicationContexteAgenceBancaire appContextAB) throws Exception {
        while (true){

            appContextAB.print("\n" + title);
            appContextAB.print(message);

            for(Action action : actionList)
                appContextAB.print(action.actionCode() + " - " + action.actionMessage());
            appContextAB.print("\n0 - Quitter le menu");

            appContextAB.print("\nEntrez votre choix :");

            String choix = appContextAB.askUser();

            if (choix.equals("0")) return;
            boolean goodChoice = false;
            for(Action action : actionList)
                if (action.actionCode().equals(choix))
                {
                    action.execute(appContextAB);
                    goodChoice = true;
                }

            if (goodChoice == false)
                appContextAB.print("Aucun choix valable.\n");
        }


    }
}
