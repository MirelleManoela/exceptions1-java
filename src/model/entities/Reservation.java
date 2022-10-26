package model.entities;

import model.exceptions.DomainExcepction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private  Integer roomNumber;
    private Date checkin;
    private Date checkout;

    // formatação da data - em static para não ser instanciado um novo SimpleDateFormat
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkin, Date checkout)  {
        if (!checkout.after(checkin)){
            throw new DomainExcepction ( " Check-out date must be after check-in date");
        }
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

    public void  updateDates(Date checkin, Date checkout) {
        //Cria uma data com o horario de agora
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)){

            // IllegalArgumentException usamos quando os argumentos que passamos no metodo são invalidos
            throw new DomainExcepction( " Reservation dates for update must be future dates");
        }
         if (!checkout.after(checkin)){
            throw new DomainExcepction ( " Check-out date must be after check-in date");

        }
             // Se retornar nulo, significa que não aconteceu nenhum erro
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
