package jogayjoga.account;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountModel, String>{
    Optional<AccountModel> findByEmailAndHash(String email, String hash);
}
