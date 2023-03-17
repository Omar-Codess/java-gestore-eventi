package org.lessons.java.gestore.eventi;
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
        LocalDate userData = LocalDate.parse(scan.nextLine());
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
                            evento.prenota();
                        }
                        System.out.println("Posti ancora disponibili: " + (userPostiTot - userPrenotazione));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Posti ancora disponibili: " + userPostiTot);
                    }
                    System.out.println(evento.toString());

                    System.out.println("Menu: 1-prenota, 2-disdici, 3-esci");
                    userChoice = Integer.parseInt(scan.nextLine());
                    break;

                case 2:
                    System.out.println("Quante prenotazioni vuoi disdire?");
                    int userCancellazioni = Integer.parseInt(scan.nextLine());
                    try {
                        for (int i = 0; i < userCancellazioni; i++) {
                            System.out.println("Posto cancellato numero: " + i);
                            evento.disdici();
                        }
                        System.out.println("Posti ancora disponibili: " + (userPostiTot - userCancellazioni));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Posti ancora disponibili: " + userPostiTot);
                    }
                    System.out.println(evento.toString());
                    System.out.println("Posti ancora disponibili: " + (evento.getPostiTotali() - userCancellazioni));
                    System.out.println("Menu: 1-prenota, 2-disdici, 3-esci");
                    userChoice = Integer.parseInt(scan.nextLine());
                    break;
            }
        } while (userChoice != 3);

        System.out.println("Arrivederci!");
    }

}
