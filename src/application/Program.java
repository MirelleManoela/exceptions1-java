package application;

import model.entities.Reservation;
import model.exceptions.DomainExcepction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    // throws ParseException significa que o metodo main pode lançar uma exceção desse tipo e não precisa tratar as exceções
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // para trabalhar com datas
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

       try {
                System.out.println("Room number:");
                int number = sc.nextInt();
                System.out.println("Check-in date (dd/MM/yyyy):");
                Date checkin = sdf.parse(sc.next());
                System.out.println("Check-out date (dd/MM/yyyy):");
                Date checkout = sdf.parse(sc.next());

                Reservation reservation = new Reservation(number, checkin, checkout);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.println("Check-in date (dd/MM/yyyy):");
                 checkin = sdf.parse(sc.next());
                System.out.println("Check-out date (dd/MM/yyyy):");
                 checkout = sdf.parse(sc.next());

               reservation.updateDates(checkin,checkout);
                System.out.println("Reservation: "  +reservation);
       }
       catch (ParseException e){
           System.out.println("Invalid date format ");
       }
       catch (DomainExcepction e){
           System.out.println("Error in reservation: "+ e.getMessage());
       }

       // Captura qualquer outra exceção
       catch (RuntimeException e){
           System.out.println("Unexpected error");
       }
    }
    }

