package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl
    implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "Andres", "andres@gmail.com", "1234") );
        users.add( new User( "Carlos", "carlos@gmail.com", "1234") );
        users.add( new User( "Natalia", "natalia@gmail.com", "1234") );

    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( String email ) {
        for(User u: users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User createUser( User user )
    {
        return users.get( 0 );
    }

    @Override
    public User findUserByEmail( String email ) {
        for(User u: users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password ) {
        for(User u: users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

}
