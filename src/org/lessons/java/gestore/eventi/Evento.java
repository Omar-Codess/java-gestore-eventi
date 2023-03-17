package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {


    //CAMPI
    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    //COSTRUTTORE
    public Evento(String titolo, LocalDate data, int postiTotali) {
        this.titolo = titolo;

        //controllo sulla data e formattazione
        data.format(formatter);
        if (data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Data non valida.");
        } else {
            this.data = data;
        }

        //controllo sui posti totali
        if (postiTotali < 0){
            throw new IllegalArgumentException("Il numero di posti totali non può essere negativo");
        } else {
            this.postiTotali = postiTotali;
        }

        this.postiPrenotati = 0;
    }

    //GETTER E SETTER
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    //METODI
    //prenota
    public void prenota(){
        int userInput = 1;
        int postiDisponibili = postiTotali - postiPrenotati;
        if (postiPrenotati > postiDisponibili || data.isAfter(getData())){
            throw new IllegalArgumentException("Evento già passato o numero posti prenotati non disponibile");
        } else {
            postiPrenotati += userInput;
        }
    }

    //disdici
    public void disdici(){
        int userInput = 1;
        int postiDisponibili = postiTotali - postiPrenotati;
        if (data.isAfter(getData()) || postiPrenotati == 0){
            throw new RuntimeException("Evento già passato o prenotazioni non presenti");
        } else {
            postiPrenotati -= userInput;
        }
    }

    //override toString()
    @Override
    public String toString() {
        return "Evento{" +
                "data='" + data + '\'' +
                ", titolo=" + titolo +
                '}';
    }
}
