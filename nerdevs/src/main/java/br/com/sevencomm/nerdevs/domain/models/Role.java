package br.com.sevencomm.nerdevs.domain.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements GrantedAuthority {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        public Role() {}

        public Role(Long id, String nome) {
                this.id = id;
                this.nome = nome;
        }

        public Long getId() { return id; }

        public void setId(Long id) { this.id = id; }

        public String getNome() { return nome; }

        public void setNome(String nome) { this.nome = nome; }

        @Override
        public String getAuthority() { return nome; }

}
