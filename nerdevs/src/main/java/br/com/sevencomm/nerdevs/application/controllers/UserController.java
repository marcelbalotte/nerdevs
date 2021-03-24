package br.com.sevencomm.nerdevs.application.controllers;

import br.com.sevencomm.nerdevs.application.dto.SignUpDTO;
import br.com.sevencomm.nerdevs.application.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpDTO signUpDTO) {
        try{

            return ResponseEntity.ok().body(userService.signUp(signUpDTO));
        } catch(Exception ex) {

            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
