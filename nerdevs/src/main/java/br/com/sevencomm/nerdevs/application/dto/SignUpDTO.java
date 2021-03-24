package br.com.sevencomm.nerdevs.application.dto;

import br.com.sevencomm.nerdevs.domain.models.Role;
import br.com.sevencomm.nerdevs.domain.models.User;
import org.modelmapper.ModelMapper;

import java.util.List;

public class SignUpDTO {

    private String nome;
    private String login;
    private String senha;
    private String email;
    private List<Role> roles;

    public SignUpDTO() {}

    public SignUpDTO(String nome, String login, String senha, String email, List<Role> roles) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.roles = roles;
    }

    public static SignUpDTO toDTO (User user) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(user, SignUpDTO.class);
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public List<Role> getRoles() { return roles; }

    public void setRoles(List<Role> roles) { this.roles = roles; }

}
