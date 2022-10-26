package model.exceptions;

public class DomainExcepction  extends RuntimeException {

    // Declarando a versão de uma classe ...
    private static final long serialVersionUID = 1L;


    // Permite instanciar a exceção personalizada passando uma mensagem
    public DomainExcepction(String msg){
        super(msg);
    }


}
