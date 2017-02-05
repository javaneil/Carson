package edu.matc.entity;

import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * A class to represent a user.
 *
 * @author Neil Fortney
 */

@Entity
@Table( name = "users" )
public class User {
    // Note: a LocalDate converter has been provided in the util package you will need it
    @Id
    @GeneratedValue( generator = "increment" )
    @GenericGenerator( name = "increment", strategy = "increment" )
    @Column( name = "id" )
    private int userid;

    @Column( name = "first_name" )
    private String firstName ;

    @Column( name = "last_name" )
    private String lastName ;

    @Column( name = "date_of_birth" )
    @Convert( converter = LocalDateAttributeConverter.class )
    private LocalDate dateOfBirth ;

    /**
     * empty Constructor
     */
    public User() {
    }

    /**
     * Constructor with arguments
     * @param id    unique identifier integer
     * @param first first name string
     * @param last  last name string
     * @param birthdate birthdate LocalDate
     */
    public User( int id, String first, String last, LocalDate birthdate ) {
        this.userid = id;
        this.firstName = first ;
        this.lastName = last ;
        this.dateOfBirth = birthdate ;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
