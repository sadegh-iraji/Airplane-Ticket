package ir.maktab.flightticket.service.impl;

import ir.maktab.flightticket.base.service.impl.BaseServiceImpl;
import ir.maktab.flightticket.domain.User;
import ir.maktab.flightticket.repository.UserRepository;
import ir.maktab.flightticket.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository>
        implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public Boolean existByUsername(String username) {
        return repository.existByUsername(username);
    }

    @Override
    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    public Boolean existUserByUsernameAndPassword(String username, String password) {
        return repository.existUserByUsernameAndPassword(username, password);
    }
}
