package pl.edu.pw.finalproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pw.finalproject.dto.UserRegistrationDto;
import pl.edu.pw.finalproject.entities.Role;
import pl.edu.pw.finalproject.entities.Role;
import pl.edu.pw.finalproject.entities.User;
import pl.edu.pw.finalproject.entities.UserDetailsImpl;
import pl.edu.pw.finalproject.repository.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {




    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new UserDetailsImpl(user) {
        };


        /*
         * org.springframework.security.core.userdetails.User(user.getEmail(),
         * user.getPassword(), mapRolesToAuthorities(user.getRoles()));
         */
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){

        return	roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
