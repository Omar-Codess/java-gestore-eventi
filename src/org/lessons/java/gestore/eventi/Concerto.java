package org.lessons.java.gestore.eventi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento{
    private LocalTime ora;
    private BigDecimal prezzo;


    public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public BigDecimal formatPrezzo(){
        prezzo = getPrezzo().setScale(2, RoundingMode.HALF_EVEN);
        return prezzo;

    }

    public String formatData(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public String formatOra(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return getOra().format(formatter);
    }


    @Override
    public String toString() {
        return "Concerto{" +
                " " + formatData() +
                " " + formatOra() + " - " +
                titolo +
                " - " + formatPrezzo() + "€" +
                '}';
    }
}

