package com.epam.panaskin.task8.users.impl;

import com.epam.panaskin.task8.users.IUser;

public class UserImpl
    implements IUser
{
    private String login;

    public UserImpl( String login )
    {
        this.login = login;
    }

    public String getLogin()
    {
        return login;
    }

    public String toString()
    {
        return this.getLogin();
    }

    @Override
    public boolean equals( Object user )
    {
        return this.hashCode() == ((IUser) user).hashCode();
    }
    
    @Override
    public int hashCode() {
        return this.getLogin().hashCode();
    }
}
