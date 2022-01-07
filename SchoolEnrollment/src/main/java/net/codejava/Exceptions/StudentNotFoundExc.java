package net.codejava.Exceptions;

public class StudentNotFoundExc extends RuntimeException{

    public StudentNotFoundExc(int id){
        super("Not find student " + id);
    }
}
