package ir.maktab.flightticket.repository;

import ir.maktab.flightticket.base.repository.BaseRepository;
import ir.maktab.flightticket.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {

    Boolean existByUsername(String username);

    User findUserByUsername(String username);

    Boolean existUserByUsernameAndPassword(String username, String password);
}
