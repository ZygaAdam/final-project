package pl.edu.pw.finalproject.entities;


import javax.persistence.*;


/**
 * The type Role.
 * @author Matylda Wawrzak-Rajtar
 * @version 1.5 z dnia 8.06
 */
@Entity
@Table(name = "ROLE")
public class Role {
    /**
     * Id - role number in the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * the name of a new Role.
     */
    private String name;


    /**
     * Instantiates a new Role.
     */
    public Role() {

    }

    /**
     * Instantiates a new Role.
     *
     * @param name the name of a new Role
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Gets id of a Role
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id of the Role.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name of the Role.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the Role.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


}
