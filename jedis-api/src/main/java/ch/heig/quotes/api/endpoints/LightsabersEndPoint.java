package ch.heig.quotes.api.endpoints;

import ch.heig.quotes.api.services.LightsabersService;
import org.openapitools.api.LightsabersApi;
import org.openapitools.model.Lightsaber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class LightsabersEndPoint implements LightsabersApi {

    @Autowired
    private LightsabersService lightsabersService;

    @Override
    public ResponseEntity<List<Lightsaber>> getLightsabers() {
        return new ResponseEntity<List<Lightsaber>>(lightsabersService.getLightsabers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> addLightsaber(@RequestBody Lightsaber lightsaber) {
        return ResponseEntity.created(lightsabersService.addLightsaber(lightsaber)).build();
    }
}
