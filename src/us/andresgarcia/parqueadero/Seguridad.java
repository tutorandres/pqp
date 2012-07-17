/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
 */
package us.andresgarcia.parqueadero;

import java.util.HashMap;
import java.util.Map;

public class Seguridad {
    
   private static final Map<String, String> USERS = new HashMap<String, String>();
    
    //static {
        //USERS.put("demo", "demo");
    //}
    public static boolean validate(String user, String password){
        String validUserPassword = USERS.get(user);
        return validUserPassword != null && validUserPassword.equals(password);
    }
}
