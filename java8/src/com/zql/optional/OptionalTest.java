package com.zql.optional;

import java.util.Optional;

/**
 * @author lawliet.L
 */
public class OptionalTest {

    public static void main(String[] args) {
        User user = null;
        Optional<User> userOptional = Optional.ofNullable(user);
        // null会被替换为Optional.empty
        System.out.println(userOptional);
        userOptional.ifPresent(u -> System.out.println(u.getUsername()));
    }
}
