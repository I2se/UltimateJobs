package fr.sothis.ultimatejobs.database.tables;

import java.util.UUID;

public class ExpJobs {

    private int id;
    private UUID uuid;
    private String playerName;
    private double exp_alchimiste;
    private double exp_constructeur;
    private double exp_crafteur;
    private double exp_digger;
    private double exp_enchanteur;
    private double exp_explorateur;
    private double exp_fermier;
    private double exp_pecheur;
    private double exp_chasseur;
    private double exp_mineur;
    private double exp_forgeron;
    private double exp_bucheron;

    public ExpJobs(int id, UUID uuid, String playerName, double exp_alchimiste, double exp_constructeur, double exp_crafteur, double exp_digger, double exp_enchanteur, double exp_explorateur, double exp_fermier, double exp_pecheur, double exp_chasseur, double exp_mineur, double exp_forgeron, double exp_bucheron) {
        this.id = id;
        this.uuid = uuid;
        this.playerName = playerName;
        this.exp_alchimiste = exp_alchimiste;
        this.exp_constructeur = exp_constructeur;
        this.exp_crafteur = exp_crafteur;
        this.exp_digger = exp_digger;
        this.exp_enchanteur = exp_enchanteur;
        this.exp_explorateur = exp_explorateur;
        this.exp_fermier = exp_fermier;
        this.exp_pecheur = exp_pecheur;
        this.exp_chasseur = exp_chasseur;
        this.exp_mineur = exp_mineur;
        this.exp_forgeron = exp_forgeron;
        this.exp_bucheron = exp_bucheron;
    }

    public double getExp_alchimiste() {
        return exp_alchimiste;
    }

    public double getExp_constructeur() {
        return exp_constructeur;
    }

    public double getExp_crafteur() {
        return exp_crafteur;
    }

    public double getExp_digger() {
        return exp_digger;
    }

    public double getExp_enchanteur() {
        return exp_enchanteur;
    }

    public double getExp_explorateur() {
        return exp_explorateur;
    }

    public double getExp_fermier() {
        return exp_fermier;
    }

    public double getExp_pecheur() {
        return exp_pecheur;
    }

    public double getExp_chasseur() {
        return exp_chasseur;
    }

    public double getExp_mineur() {
        return exp_mineur;
    }

    public double getExp_forgeron() {
        return exp_forgeron;
    }

    public double getExp_bucheron() {
        return exp_bucheron;
    }

    public void setExp_alchimiste(double exp_alchimiste) {
        this.exp_alchimiste = exp_alchimiste;
    }

    public void setExp_constructeur(double exp_constructeur) {
        this.exp_constructeur = exp_constructeur;
    }

    public void setExp_crafteur(double exp_crafteur) {
        this.exp_crafteur = exp_crafteur;
    }

    public void setExp_digger(double exp_digger) {
        this.exp_digger = exp_digger;
    }

    public void setExp_enchanteur(double exp_enchanteur) {
        this.exp_enchanteur = exp_enchanteur;
    }

    public void setExp_explorateur(double exp_explorateur) {
        this.exp_explorateur = exp_explorateur;
    }

    public void setExp_fermier(double exp_fermier) {
        this.exp_fermier = exp_fermier;
    }

    public void setExp_pecheur(double exp_pecheur) {
        this.exp_pecheur = exp_pecheur;
    }

    public void setExp_chasseur(double exp_chasseur) {
        this.exp_chasseur = exp_chasseur;
    }

    public void setExp_mineur(double exp_mineur) {
        this.exp_mineur = exp_mineur;
    }

    public void setExp_forgeron(double exp_forgeron) {
        this.exp_forgeron = exp_forgeron;
    }

    public void setExp_bucheron(double exp_bucheron) {
        this.exp_bucheron = exp_bucheron;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ExpJobs createDefaultExp(){
        return new ExpJobs(1, UUID.randomUUID(), "Default", 0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
    }
}
