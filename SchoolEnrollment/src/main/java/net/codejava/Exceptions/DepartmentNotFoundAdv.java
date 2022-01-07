package net.codejava.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class DepartmentNotFoundAdv {

    @ResponseBody
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String DepartmentNotFoundHand(DepartmentNotFoundExc ex){
        return ex.getMessage();
    }
}
