package hyperquiz.dao.impl;


import hyperquiz.dao.UserRepository;
import hyperquiz.model.User;

import java.util.Optional;

public class UserRepositoryMemoryImpl extends RepositoryMemoryImpl<Long, User>
    implements UserRepository {
    @Override
    public Optional<User> findByUsername(String username) {
        return findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .peek(u -> System.out.println("Filtered value: " + u))
                .findFirst();
    }
}