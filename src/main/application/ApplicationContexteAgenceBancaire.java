package application;

import banque.AgenceBancaire;

import java.io.PrintStream;
import java.util.Scanner;

public class ApplicationContexteAgenceBancaire {

    private static ApplicationContexteAgenceBancaire instance = new ApplicationContexteAgenceBancaire();

    public static ApplicationContexteAgenceBancaire getInstance() {
        return instance;
    }

    private Scanner input;
    private PrintStream printStream;
    public AgenceBancaire agenceBancaire;

    private ApplicationContexteAgenceBancaire(){
        input = new Scanner(System.in);
        printStream = new PrintStream(System.out);
        agenceBancaire = AccesAgenceBancaire.getAgenceBancaire();
    }

    public void print(String input){
        printStream.println(input);
    }

    public String askUser(){
        return input.next();
    }

    public void tempo() {
        print("Tapper un car + return pour continuer ... ");
        askUser();
    }
}
