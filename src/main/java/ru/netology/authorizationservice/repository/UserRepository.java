package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, List<Authorities>> users = new HashMap<>();

    public UserRepository() {
        List<Authorities> user1 = new ArrayList<>();
        user1.add(Authorities.READ);
        user1.add(Authorities.WRITE);
        users.put("admin", user1);

        List<Authorities> user2 = new ArrayList<>();
        user2.add(Authorities.READ);
        users.put("user", user2);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        // Для упрощения считаем, что пароль = имя пользователя
        // В реальном проекте здесь была бы проверка хеша пароля
        if (user.equals(password)) {
            return users.get(user);
        }
        return new ArrayList<>();
    }
}