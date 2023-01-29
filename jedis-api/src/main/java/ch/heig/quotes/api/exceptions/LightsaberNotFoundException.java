package ch.heig.quotes.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LightsaberNotFoundException extends RuntimeException {
    public LightsaberNotFoundException(Integer id) {
        super("Sabre laser " + id + " non trouvée");
    }
}
