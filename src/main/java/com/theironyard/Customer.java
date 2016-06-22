package com.theironyard;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jeffryporter on 6/22/16.
 */
public class Customer
{

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    public Customer()
    {
    }

    public Customer( String name, String email)
    {
        this.name = name;
        this.email = email;
    }
}
