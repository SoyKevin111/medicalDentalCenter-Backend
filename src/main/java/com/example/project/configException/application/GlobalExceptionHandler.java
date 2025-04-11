package com.example.project.configException.application;


import com.example.project.shared.exception.GeneralValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {


   @ExceptionHandler(GeneralValidationException.class) //Mensaje , Lista de errores de dominio
   public ResponseEntity<?> handlerGeneralException(GeneralValidationException ex){
      return ResponseEntity.badRequest().body(Collections.singletonMap(ex.getType(), ex.getErrors()));
   }

}
