package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private  Integer roomNumber;
    private Date checkin;
    private Date checkout;

    // formatação da data - em static para não ser instanciado um novo SimpleDateFormat
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }


    public Date getCheckout() {
        return checkout;
    }


    public long duration() {
        // Pegando a diferença entre as duas datas em milissegundos
        long diff = checkout.getTime() - checkin.getTime();

        // Converter os milissegundo em dias
        TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        return diff;
    }

    public void updateDates(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    // toString é uma sobreposição
    public String toString(){
        return "Room "
                +roomNumber
                +", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                +sdf.format(checkout)
                +", "
                +duration()
                +" nights";


    }
}
