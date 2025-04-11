package com.example.project.shared.exception;

import java.util.List;

public class GeneralValidationException extends RuntimeException {
   private List<String> errors;
   private String type;

   public GeneralValidationException(String type, List<String> errors) {
      this.type = type;
      this.errors = errors;
   }

   public List<String> getErrors(){
      return errors;
   }

   public String getType() {
      return type;
   }
}
