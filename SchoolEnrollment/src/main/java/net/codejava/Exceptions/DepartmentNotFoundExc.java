package net.codejava.Exceptions;

public class DepartmentNotFoundExc extends RuntimeException{
    public DepartmentNotFoundExc(int id){
        super("Not find department " + id);
    }
}
