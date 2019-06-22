package com.example.demo.interfaces.venues;

import com.example.demo.domain.model.handling.ResourceNotFoundException;
import com.example.demo.domain.model.handling.ViolationResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ModelAndView handleEntityNotFound(ResourceNotFoundException ex) {
        ViolationResponse errorResponse = new ViolationResponse(HttpStatus.NOT_FOUND);
        ResponseEntity<Object> objectResponseEntity = this.buildResponseEntity(errorResponse);

        ModelAndView mav = this.buildMvcResponse(objectResponseEntity, ex);

        mav.setViewName("errors/400");

        return mav;
    }

    @ExceptionHandler(javax.persistence.EntityNotFoundException.class)
    public final ModelAndView handleEntityNotFound(javax.persistence.EntityNotFoundException ex) {
        ResponseEntity<Object> objectResponseEntity = this.buildResponseEntity(new ViolationResponse(HttpStatus.NOT_FOUND, ex));

        ModelAndView mav = this.buildMvcResponse(objectResponseEntity, ex);

        mav.setViewName("errors/400");

        return mav;
    }

    private ResponseEntity<Object> buildResponseEntity(ViolationResponse errorResponse) {
        logger.error(errorResponse);

        return ResponseEntity
                .status(errorResponse.getStatus())
                .body(errorResponse);
    }

    private ModelAndView buildMvcResponse(ResponseEntity<Object> objectResponseEntity, Exception ex) {
        logger.error(objectResponseEntity.getStatusCode());
        logger.error(ex.getMessage());
        logger.error(objectResponseEntity.getBody());

        ModelAndView mav = new ModelAndView();
        mav.addObject("code", objectResponseEntity.getStatusCode());
        mav.addObject("status", objectResponseEntity.getStatusCodeValue());
        mav.addObject("headers", objectResponseEntity.getHeaders());
        mav.addObject("body", objectResponseEntity.getBody());
        mav.addObject("message", ex.getMessage());

        return mav;
    }
}