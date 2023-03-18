package org.lessons.java.gestore.eventi;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci un nuovo evento!");
        System.out.println("titolo: ");
        String userTitolo = scan.nextLine();
        System.out.println("data: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate userData = LocalDate.parse(scan.nextLine(), formatter);
        System.out.println("posti totali: ");
        int userPostiTot = Integer.parseInt(scan.nextLine());

        Evento evento = new Evento(userTitolo, userData, userPostiTot);

        System.out.println("Menu: 1-prenota, 2-disdici, 3-esci");
        int userChoice = Integer.parseInt(scan.nextLine());


        do {

            switch (userChoice) {
                case 1:
                    System.out.println("Quanti posti vuoi prenotare?");
                    int userPrenotazione = Integer.parseInt(scan.nextLine());

                    try {
                        for (int i = 0; i < userPrenotazione; i++) {
                            System.out.println("Posto prenotato numero: " + i);
                        }
                        evento.prenota();
                        System.out.println("Posti ancora disponibili: " + (evento.getPostiTotali() - userPrenotazione));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(evento.toString());
                    System.out.println("Menu: 2-disdici, 3-esci");
                    userChoice = Integer.parseInt(scan.nextLine());
                    break;

                case 2:
                    System.out.println("Quante prenotazioni vuoi disdire?");
                    int userCancellazioni = Integer.parseInt(scan.nextLine());
                    try {
                        for (int i = 0; i < userCancellazioni; i++) {
                            System.out.println("Posto cancellato numero: " + i);
                        }
                        evento.disdici();
                        System.out.println("Posti ancora disponibili: " + (evento.getPostiTotali() - userCancellazioni));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(evento.toString());
                    System.out.println("Menu: 3-esci");
                    userChoice = Integer.parseInt(scan.nextLine());
                    break;
            }
        } while (userChoice != 3);

        System.out.println(evento.toString());
        System.out.println("Arrivederci!");

        //TEST
        Evento concerto = new Concerto(userTitolo, userData, userPostiTot, LocalTime.of(17, 35), new BigDecimal(155));
        System.out.println(concerto.toString());
    }

}
