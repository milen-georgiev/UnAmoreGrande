package com.example.unamoregrande.web;

import com.example.unamoregrande.model.validation.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> onValidationFailure(MethodArgumentNotValidException exc) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        exc.getFieldErrors().forEach(fe ->
                apiError.addFieldWithError(fe.getField()));

        return ResponseEntity.badRequest().body(apiError);
    }


//    @ExceptionHandler({ObjectNotFoundException.class})
//    public ModelAndView ObjectNotFoundException(ObjectNotFoundException exception) {
//        ModelAndView modelAndView = new ModelAndView("object-not-found");
//        modelAndView.addObject("objectId", exception.getMessage());
//        return modelAndView;
//    }
//
//    @ExceptionHandler({NumberFormatException.class})
//    public ModelAndView handlerObjExceptions(NumberFormatException exception) {
//        ModelAndView modelAndView = new ModelAndView("object-not-found");
//        modelAndView.addObject("objectId", exception.getMessage());
//        return modelAndView;
//    }


}
