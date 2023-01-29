package ch.heig.quotes.api.services;

import ch.heig.quotes.api.entities.LightsaberEntity;
import ch.heig.quotes.api.repositories.LightsaberRepository;
import org.openapitools.model.Lightsaber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class LightsabersService {

    @Autowired
    private LightsaberRepository lightsaberRepository;

    public List<Lightsaber> getLightsabers() {
        List<LightsaberEntity> lightsaberEntities = lightsaberRepository.findAll();
        List<Lightsaber> lightsabers = new ArrayList<>();
        for (LightsaberEntity lightsaberEntity : lightsaberEntities) {

            Lightsaber lightsaber = new Lightsaber();
            lightsaber.setId(lightsaberEntity.getId());
            lightsaber.setColor(lightsaberEntity.getColor());
            lightsabers.add(lightsaber);

        }
        return lightsabers;
    }

    public URI addLightsaber(Lightsaber lightsaber) {
        LightsaberEntity lightsaberEntity = new LightsaberEntity();
        lightsaberEntity.setColor(lightsaber.getColor());
        LightsaberEntity lightsaberAdded = lightsaberRepository.save(lightsaberEntity);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(lightsaberAdded.getId())
                .toUri();
        return uri;
    }

}
