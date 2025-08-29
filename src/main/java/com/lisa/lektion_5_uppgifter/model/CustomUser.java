package com.lisa.lektion_5_uppgifter.model;

public record CustomUser(
        int id,
        String username,
        String password,
        boolean isEnabled
) {
}
