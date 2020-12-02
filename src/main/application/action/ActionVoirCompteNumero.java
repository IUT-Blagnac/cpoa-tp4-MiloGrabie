package application.action;

import banque.AgenceBancaire;
import banque.Compte;

public class ActionVoirCompteNumero implements Action<AgenceBancaire> {
    private String message;
    private String code;

    public ActionVoirCompteNumero(String message, String code) {
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
        Compte compte = ag.getCompte(code);
        if (compte==null)
            System.out.println("Compte inexistant ...");
        else
            compte.afficher();
    }
}

