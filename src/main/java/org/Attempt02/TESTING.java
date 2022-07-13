package org.acme2;

import org.json.JSONObject;

public class TESTING {

    public static void main(String[] args){

        JSONObject message = new JSONObject();
        JSONObject scheme = new JSONObject();

        JSONObject subdata_message = new JSONObject();
        JSONObject subdata_scheme = new JSONObject();

        subdata_message.put("v1",1);
        subdata_message.put("v2",2);
        subdata_message.put("v3","3");

        subdata_scheme.put("v1","^[0-9]$");
        subdata_scheme.put("v2","^[0-9]$");
        subdata_scheme.put("v3","^[0-9]$");

        message.put("name", "Eduardo");
        message.put("email", "eduardo@mail.com");
        message.put("id", 12345);
        message.put("subdata", subdata_message);

        scheme.put("name", "^{1}[A-Z][a-z]+$");
        //Los emails no son case-sensitive. Tener en cuenta en toma de datos.
        scheme.put("email", "^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$");
        scheme.put("id", "^[0-9]+$");
        scheme.put("subdata", subdata_scheme);

        System.out.print(
                Validator.is_valid(message,scheme)
        );

    }
}
