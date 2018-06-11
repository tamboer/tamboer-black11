package za.co.tamboer.tamboerblack11.player.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.tamboer.tamboerblack11.player.Player;

@RepositoryRestResource
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
