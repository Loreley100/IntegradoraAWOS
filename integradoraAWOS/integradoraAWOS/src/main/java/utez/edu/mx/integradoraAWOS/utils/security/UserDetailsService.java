package utez.edu.mx.integradoraAWOS.utils.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utez.edu.mx.integradoraAWOS.modules.user.User;
import utez.edu.mx.integradoraAWOS.modules.user.UserRepository;

import java.util.Collections;

// 5.- Crear UserDetailsService para el manejo de autorizaciones
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por nombre de usuario
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        //Convertir el rol a GrantedAuthority
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRol().getName());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(authority)
        );
    }
}