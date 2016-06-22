package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jeffryporter on 6/22/16.
 */
public interface CustomersRepository extends CrudRepository<Customer, Integer>
{
    public Customer findById(int id);
}
