package ft.etachott.repository;

import org.springframework.data.repository.ListCrudRepository;
import ft.etachott.model.Character;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CharacterRepository extends ListCrudRepository<Character, Long> {}
