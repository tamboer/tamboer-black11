package za.co.tamboer.tamboerblack11.player.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserEmailExistsException extends RuntimeException {

    public UserEmailExistsException(String exception) {
        super(exception);
    }

}