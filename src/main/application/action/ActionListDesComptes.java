package application.action;

import application.ApplicationContexteAgenceBancaire;
import banque.AgenceBancaire;

public class ActionListDesComptes implements Action<ApplicationContexteAgenceBancaire> {

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
    public void execute(ApplicationContexteAgenceBancaire applicationAB) throws Exception {
        applicationAB.print(message);
        applicationAB.agenceBancaire.afficher();
        applicationAB.tempo();
    }
}
