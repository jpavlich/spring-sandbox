/**
 * 
 */
package com.example.demo.secTest1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author rohitghatol
 *
 */
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason = "Error Processing Edm")
public class EdmException extends RuntimeException {

}