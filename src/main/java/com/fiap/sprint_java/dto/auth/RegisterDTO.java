package com.fiap.sprint_java.dto.auth;

import com.fiap.sprint_java.domain.user.UserRole;

public record RegisterDTO(String login, String password, String email, UserRole role) {
}
