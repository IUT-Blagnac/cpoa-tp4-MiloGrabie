package application.action;

import banque.AgenceBancaire;

public class ActionListDesComptes implements Action<AgenceBancaire> {

    private String message;
    private String code;

    public ActionListDesComptes(String message, String code) {
        this.message = message;
        this.code = code;
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
        System.out.println(message);
        ag.afficher();
    }
}
