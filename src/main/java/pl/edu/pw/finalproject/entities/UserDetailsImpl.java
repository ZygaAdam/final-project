package pl.edu.pw.finalproject.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type User details.
 *
 * @author Adam Zyga
 */
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    /**
     * User - a new user.
     * @see User
     */
    private User user;

    /**
     * Instantiates a new User details.
     *
     * @param user the user
     */
    public UserDetailsImpl(User user) {
        this.user = user;
    }

    /**
     * Gets authorities.
     *
     * @return the authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    @Override
    public String getPassword() {

        return this.user.getPassword();
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.user.getEmail();
    }

    /**
     * Is account non expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * Is account non locked boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    /**
     * Is credentials non expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    /**
     * Is enabled boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isEnabled() {

        return true;
    }

    /**
     * Gets first name.
     *
     * @return the String representing first name
     */
    public String getFirstName()
    { return this.user.getFirstName(); }

    /**
     * Gets last name.
     *
     * @return the String representing  last name
     */
    public String getLastName()
    { return this.user.getLastName(); }

}
