package com.banking.gestionDeCompte.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {


    public Utilities() {
        super();
    }

    /**
     * Pour avoir la date.
     * @return
     */
    public static Date getCurrentDate() {
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(time);
        return resultdate;
    }
}
