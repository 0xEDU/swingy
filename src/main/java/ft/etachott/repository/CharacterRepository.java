package ft.etachott.repository;

import org.springframework.data.repository.ListCrudRepository;
import ft.etachott.model.Character;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CharacterRepository extends Repository<Character, Long> {
    Character save(Character character);

    Optional<Character> findById(long id);
}
