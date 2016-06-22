package com.theironyard;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by jeffryporter on 6/22/16.
 */
public class Purchase
{
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    int credit_card;

    @Column(nullable = false)
    int ccv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customer customer;

    public Purchase()
    {
    }

    public Purchase(String date, int credit_card, int ccv, String category, Customer customer)
    {

        this.date = date;
        this.credit_card = credit_card;
        this.ccv = ccv;
        this.category = category;
        this.customer = customer;

    }
}
