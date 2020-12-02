package application.actionList;

import application.action.Action;
import application.action.ActionList;
import banque.AgenceBancaire;

import java.util.ArrayList;

public class ActionListAgenceBancaire implements ActionList<AgenceBancaire> {

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
    public boolean addAction(Action<AgenceBancaire> ac, int index) {
        if ((index < 0) || (index > size())) return false;
        actionList.set(index, ac);
        return true;
    }

    @Override
    public boolean removeAction(int index) {
        if ((index < 0) || (index > size())) return false;
        actionList.remove(index);
        return false;
    }

    @Override
    public boolean removeAction(Action<AgenceBancaire> ac) {
        if (!actionList.contains(ac)) return false;
        actionList.remove(ac);
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
    public void execute(AgenceBancaire ag) throws Exception {
        System.out.println(title);
        System.out.println(message);
        for (int i = 0; i < actionList.size(); i++)
            System.out.println((i+1) + " - " + actionList.get(i).actionMessage());

        System.out.println("0 - Quitter le menu");
    }
}
