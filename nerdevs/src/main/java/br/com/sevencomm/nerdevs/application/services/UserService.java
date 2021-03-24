package br.com.sevencomm.nerdevs.application.services;

import br.com.sevencomm.nerdevs.application.dto.SignUpDTO;
import br.com.sevencomm.nerdevs.domain.models.User;

public interface UserService { User signUp(SignUpDTO signUpDTO); }
