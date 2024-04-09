package bkendw5.w5d2.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(int id){
        super("Elemento con id " + id + " non trovato!");
    }
}
