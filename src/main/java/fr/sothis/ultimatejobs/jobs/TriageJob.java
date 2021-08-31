package fr.sothis.ultimatejobs.jobs;

public class TriageJob {

    public static String triage(JobUnit jobUnit) {
        String alchimiste = "alchimiste";
        String constructeur = "constructeur";
        String crafteur = "crafteur";
        String digger = "digger";
        String enchanteur = "enchanteur";
        String explorateur = "explorateur";
        String fermier = "fermier";
        String pecheur = "pecheur";
        String chasseur = "chasseur";
        String mineur = "mineur";
        String forgeron = "forgeron";
        String bucheron = "bucheron";

        if(jobUnit == JobUnit.ALCHIMISTE) {
            return alchimiste;
        } else if(jobUnit == JobUnit.CONSTRUCTEUR) {
            return constructeur;
        } else if(jobUnit == JobUnit.CRAFTEUR) {
            return crafteur;
        } else if(jobUnit == JobUnit.DIGGER) {
            return digger;
        } else if(jobUnit == JobUnit.ENCHANTEUR) {
            return enchanteur;
        } else if(jobUnit == JobUnit.EXPLORATEUR) {
            return explorateur;
        } else if(jobUnit == JobUnit.FERMIER) {
            return fermier;
        } else if(jobUnit == JobUnit.PECHEUR) {
            return pecheur;
        } else if(jobUnit == JobUnit.CHASSEUR) {
            return chasseur;
        } else if(jobUnit == JobUnit.MINEUR) {
            return mineur;
        } else if(jobUnit == JobUnit.FORGERON) {
            return forgeron;
        } else if(jobUnit == JobUnit.BUCHERON) {
            return bucheron;
        }
        return null;
    }
}
