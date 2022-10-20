package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    // throws ParseException significa que o metodo main pode lançar uma exceção desse tipo e não precisa tratar as exceções
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        // para trabalhar com datas
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number:");
        int number = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyyy):");
        Date checkin = sdf.parse(sc.next());
        System.out.println("Check-out date (dd/MM/yyyy):");
        Date checkout = sdf.parse(sc.next());

        //after testa se uma data é depois da outra
        if (!checkout.after(checkin)){
            System.out.println("Error in reservation: Reservation dates for update must be future dates");
        }
        else {
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.println("Check-in date (dd/MM/yyyy):");
             checkin = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy):");
             checkout = sdf.parse(sc.next());


             //Cria uma data com o horario de agora
             Date now = new Date();
             if (checkin.before(now) || checkout.before(now)){
                 System.out.println("Error in reservation: Reservation dates for update must be future dates");
             }
             else if (!checkout.after(checkin)){
                 System.out.println("Error in reservation:  Check-out date must be after check-in date");

             }
             else {
            System.out.println();
             reservation.updateDates(checkin,checkout);
            System.out.println("Reservation: "  +reservation);
        }
    }

    }
}
