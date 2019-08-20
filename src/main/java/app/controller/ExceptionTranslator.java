package app.controller;

import app.model.Move;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        Class<?> type = e.getRequiredType();
        String message;
        if (type == null) {
            message = "Something wrong with the parameter " + e.getName();
        } else if (type.isEnum()) {
            List<String> enumNames = Stream.of(Move.values()).map(Enum::name).collect(toList());
            message = "The parameter " + e.getName() + " must have a value among : " + StringUtils.join(enumNames);
        } else {
            message = "The parameter " + e.getName() + " must be of type " + type.getTypeName();
        }
        return ResponseEntity.unprocessableEntity().body(message);
    }
}