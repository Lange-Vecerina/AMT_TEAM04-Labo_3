package ch.heig.quotes.api.endpoints;

import ch.heig.quotes.api.services.JedisService;
import org.openapitools.model.Lightsaber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.openapitools.model.Jedi;
import org.openapitools.api.JedisApi;
import java.util.List;


@RestController
public class JediEndPoint implements JedisApi {

        @Autowired
        private JedisService jedisService;

        @Override
        public ResponseEntity<List<Jedi>> getJedis() {
            return new ResponseEntity<List<Jedi>>(jedisService.getJedis(),HttpStatus.OK);
        }

        @Override
        public ResponseEntity<Void> addJedi(@RequestBody Jedi jedi) {
            return ResponseEntity.created(jedisService.addJedi(jedi)).build();
        }

        @Override
        public ResponseEntity<Jedi> getJedi(Integer id) {
            return new ResponseEntity<Jedi>(jedisService.getJedi(id),HttpStatus.OK);
        }

        @Override
        public ResponseEntity<Void> updateJedi(Integer id, @RequestBody Jedi jedi) {
            return ResponseEntity.created(jedisService.updateJedi(id, jedi)).build();
        }

        @Override
        public ResponseEntity<List<Lightsaber>> getLightsabersOfJedi(Integer id) {
            return new ResponseEntity<List<Lightsaber>>(jedisService.getLightsabers(id),HttpStatus.OK);
        }

        @Override
        public ResponseEntity<Void> addLightsaberToJedi(Integer id, @RequestBody Lightsaber lightsaber) {
            return ResponseEntity.created(jedisService.addLightsaber(id, lightsaber)).build();
        }

}

