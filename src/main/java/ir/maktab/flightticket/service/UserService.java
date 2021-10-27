package ir.maktab.flightticket.service;

import ir.maktab.flightticket.base.service.BaseService;
import ir.maktab.flightticket.domain.User;

public interface UserService extends BaseService<User, Long> {

    Boolean existByUsername(String username);

    User findUserByUsername(String username);

    Boolean existUserByUsernameAndPassword(String username, String password);

}
