package application.action;

import application.ApplicationContexteAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;

public class ActionVoirCompteNumero implements Action<ApplicationContexteAgenceBancaire> {
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
    public void execute(ApplicationContexteAgenceBancaire applicationAB) throws Exception {
        applicationAB.print(message);
        applicationAB.print("Entrez le numéro de compte :");
        String compteNumeber = applicationAB.askUser();
        Compte compte = applicationAB.agenceBancaire.getCompte(compteNumeber);
        if (compte==null)
            applicationAB.print("Compte inexistant ...");
        else
            compte.afficher();
        applicationAB.tempo();
    }
}

