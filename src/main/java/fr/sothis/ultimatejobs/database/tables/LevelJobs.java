package fr.sothis.ultimatejobs.database.tables;

import java.util.UUID;

public class LevelJobs {

    private int id;
    private UUID uuid;
    private String playerName;
    private int exp_alchimiste;
    private int exp_constructeur;
    private int exp_crafteur;
    private int exp_digger;
    private int exp_enchanteur;
    private int exp_explorateur;
    private int exp_fermier;
    private int exp_pecheur;
    private int exp_chasseur;
    private int exp_mineur;
    private int exp_forgeron;
    private int exp_bucheron;

    public LevelJobs(int id, UUID uuid, String playerName, int exp_alchimiste, int exp_constructeur, int exp_crafteur, int exp_digger, int exp_enchanteur, int exp_explorateur, int exp_fermier, int exp_pecheur, int exp_chasseur, int exp_mineur, int exp_forgeron, int exp_bucheron) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getExp_alchimiste() {
        return exp_alchimiste;
    }

    public void setExp_alchimiste(int exp_alchimiste) {
        this.exp_alchimiste = exp_alchimiste;
    }

    public int getExp_constructeur() {
        return exp_constructeur;
    }

    public void setExp_constructeur(int exp_constructeur) {
        this.exp_constructeur = exp_constructeur;
    }

    public int getExp_crafteur() {
        return exp_crafteur;
    }

    public void setExp_crafteur(int exp_crafteur) {
        this.exp_crafteur = exp_crafteur;
    }

    public int getExp_digger() {
        return exp_digger;
    }

    public void setExp_digger(int exp_digger) {
        this.exp_digger = exp_digger;
    }

    public int getExp_enchanteur() {
        return exp_enchanteur;
    }

    public void setExp_enchanteur(int exp_enchanteur) {
        this.exp_enchanteur = exp_enchanteur;
    }

    public int getExp_explorateur() {
        return exp_explorateur;
    }

    public void setExp_explorateur(int exp_explorateur) {
        this.exp_explorateur = exp_explorateur;
    }

    public int getExp_fermier() {
        return exp_fermier;
    }

    public void setExp_fermier(int exp_fermier) {
        this.exp_fermier = exp_fermier;
    }

    public int getExp_pecheur() {
        return exp_pecheur;
    }

    public void setExp_pecheur(int exp_pecheur) {
        this.exp_pecheur = exp_pecheur;
    }

    public int getExp_chasseur() {
        return exp_chasseur;
    }

    public void setExp_chasseur(int exp_chasseur) {
        this.exp_chasseur = exp_chasseur;
    }

    public int getExp_mineur() {
        return exp_mineur;
    }

    public void setExp_mineur(int exp_mineur) {
        this.exp_mineur = exp_mineur;
    }

    public int getExp_forgeron() {
        return exp_forgeron;
    }

    public void setExp_forgeron(int exp_forgeron) {
        this.exp_forgeron = exp_forgeron;
    }

    public int getExp_bucheron() {
        return exp_bucheron;
    }

    public void setExp_bucheron(int exp_bucheron) {
        this.exp_bucheron = exp_bucheron;
    }

    public static ExpJobs createDefaultLevel(){
        return new ExpJobs(1, UUID.randomUUID(), "Default", 0,0,0,0,0,0,0,0,0,0,0,0);
    }
}

