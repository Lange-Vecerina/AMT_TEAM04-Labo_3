package ch.heig.quotes.api.endpoints;

import ch.heig.quotes.api.entities.LightsaberEntity;
import ch.heig.quotes.api.repositories.LightsaberRepository;
import org.openapitools.api.LightsabersApi;
import org.openapitools.model.Lightsaber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LightsabersEndPoint implements LightsabersApi {

    @Autowired
    private LightsaberRepository lightsaberRepository;

    @Override
    public ResponseEntity<List<Lightsaber>> getLightsabers() {
        List<LightsaberEntity> lightsaberEntities = lightsaberRepository.findAll();
        List<Lightsaber> lightsabers = new ArrayList<>();
        for (LightsaberEntity lightsaberEntity : lightsaberEntities) {

            Lightsaber lightsaber = new Lightsaber();
            lightsaber.setId(lightsaberEntity.getId());
            lightsaber.setColor(lightsaberEntity.getColor());
            lightsabers.add(lightsaber);

        }
        return new ResponseEntity<List<Lightsaber>>(lightsabers, HttpStatus.OK);
    }
}
