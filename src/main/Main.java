import application.AccesAgenceBancaire;
import application.action.ActionListDesComptes;
import application.action.ActionVoirCompteNumero;
import application.actionList.ActionListAgenceBancaire;
import banque.AgenceBancaire;

public class Main {

    public static void main(String[] args) throws Exception {

        AgenceBancaire agenceBancaire = AccesAgenceBancaire.getAgenceBancaire();

        ActionListAgenceBancaire actionListAgence = new ActionListAgenceBancaire("Choisir", "-1", "Menu Agence Bancaire");
        actionListAgence.addAction(new ActionListDesComptes("Affichages de la liste des compte", "-1"));
        actionListAgence.addAction(new ActionVoirCompteNumero("Affichages du compte", "-1"));
        actionListAgence.execute(agenceBancaire);


    }

}
