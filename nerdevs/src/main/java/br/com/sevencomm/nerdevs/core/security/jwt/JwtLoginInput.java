package br.com.sevencomm.nerdevs.core.security.jwt;

import lombok.Data;

@Data
class JwtLoginInput {

    private String username;
    private String password;

}