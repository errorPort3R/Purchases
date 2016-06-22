package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by jeffryporter on 6/22/16.
 */

@Controller
public class PurchasesController
{
    @Autowired
    CustomersRepository customers;

    @Autowired
    PurchasesRepository purchases;

    public static final String CUSTOMER_FILE_LOCATION = "customers.txt";
    public static final String PURCHASE_FILE_LOCATION = "purchases.txt";

    @PostConstruct
    public void init() throws FileNotFoundException
    {
        if (customers.count() == 0)
        {
            loadCustomers(CUSTOMER_FILE_LOCATION);
        }
        if (purchases.count() == 0)
        {
            loadPurchases(PURCHASE_FILE_LOCATION);
        }
    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String sort_by)
    {
        ArrayList<Purchase> displayPurchases= new ArrayList<>();
        if (sort_by == null)
        {
            sort_by = "all";
        }
        If



        model.addAttribute("purchase_data", displayPurchases);
        return "home";
    }

    public void loadCustomers(String fileLoc) throws FileNotFoundException
    {
        File f = new File(fileLoc);
        Scanner fileScanner =  new Scanner(f);
        fileScanner.nextLine();
        while (fileScanner.hasNext())
        {
            String line = fileScanner.nextLine();
            String[] fields = line.split(",");
            Customer customer = new Customer(fields[0], fields[1]);
            customers.save(customer);
        }
    }

    public void loadPurchases(String fileLoc) throws FileNotFoundException
    {
        File f = new File(fileLoc);
        Scanner fileScanner =  new Scanner(f);
        while (fileScanner.hasNext())
        {
            String line = fileScanner.nextLine();
            String[] fields = line.split(",");

            int ccn = Integer.valueOf(fields[2]);
            int ccv = Integer.valueOf(fields[3]);
            Customer cust = new Customer();
            cust = customers.findById(Integer.valueOf(fields[0]));

            Purchase purchase = new Purchase(fields[1], ccn, ccv, fields[4], cust);
            purchases.save(purchase);
        }
    }

}
