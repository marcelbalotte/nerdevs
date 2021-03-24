package br.com.sevencomm.nerdevs.domain.servicesImpl;

import br.com.sevencomm.nerdevs.application.dto.SignUpDTO;
import br.com.sevencomm.nerdevs.application.services.UserService;
import br.com.sevencomm.nerdevs.data.repositories.RoleRepository;
import br.com.sevencomm.nerdevs.data.repositories.UserRepository;
import br.com.sevencomm.nerdevs.domain.models.Role;
import br.com.sevencomm.nerdevs.domain.models.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User signUp(SignUpDTO signUpDTO) {
        User fndUser = userRepository.findByEmail(signUpDTO.getEmail());
        if (fndUser != null) throw new IllegalArgumentException("O e-mail já existe");
        fndUser = userRepository.findByLogin(signUpDTO.getLogin());
        if (fndUser != null) throw new IllegalArgumentException("O login já existe");

        User user = new User();
        user.setEmail(signUpDTO.getEmail());
        user.setLogin(signUpDTO.getLogin());
        user.setSenha(signUpDTO.getSenha());
        user.setNome(signUpDTO.getNome());
        List<Role> roles = Arrays.asList(roleRepository.findById(1L).get());
        user.setRoles(roles);

        return userRepository.save(user);
    }

}
