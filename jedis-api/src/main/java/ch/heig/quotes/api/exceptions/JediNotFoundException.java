package ch.heig.quotes.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JediNotFoundException extends RuntimeException {
    public JediNotFoundException(Integer id) {
        super("Jedi " + id + " non trouvée");
    }
}
