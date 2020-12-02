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

    public boolean addAction(Action action){
        if (actionList.contains(action)) return false;
        actionList.add(action);
        return true;
    }

    public void remove(Action action){
        actionList.remove(action);
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
