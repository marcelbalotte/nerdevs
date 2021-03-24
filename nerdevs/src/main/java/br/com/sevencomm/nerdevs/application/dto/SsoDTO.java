package br.com.sevencomm.nerdevs.application.dto;

import br.com.sevencomm.nerdevs.domain.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public class SsoDTO {

    private String access_token;
    private String token_type;
    private User me;

    public SsoDTO() {}

    public SsoDTO(String access_token, String token_type, User me) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.me = me;
    }

//    public static SsoDTO create(User user) {
//        ModelMapper modelMapper = new ModelMapper();
//        SsoDTO dto = modelMapper.map(user, SsoDTO.class);
//
//        return dto;
//    }
//
    public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();

        return m.writeValueAsString(this);
    }

//    public static SsoDTO toDTO (User u) {
//        ModelMapper modelMapper = new ModelMapper();
//
//        return modelMapper.map(u, SsoDTO.class);
//    }


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public User getMe() {
        return me;
    }

    public void setMe(User me) {
        this.me = me;
    }
}