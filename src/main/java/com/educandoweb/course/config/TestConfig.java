package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

//Classe de configuracao que so ira rodar
//Quando voce estiver no perfil de test
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //Para o spring associar o UserRepository no TestConfig
    //Nos usamos o @Autowired
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1,u2));
        //saveAll() e um metodo que passa uma lista de objetos e entao
        //salva no banco de dados
    }
}


