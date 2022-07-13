package org.acme2;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class Validator {


    public static boolean is_valid(String message_value, String scheme_regex){
        if(!is_a_regular_expression(scheme_regex)){
            return false;
        }
        boolean is_valid = message_value.matches(scheme_regex);
        return is_valid;
    }

    private static boolean is_a_regular_expression(String scheme_regex) {
        char[] char_array = scheme_regex.toCharArray();
        boolean b;
        b = char_array[0] == '^' && char_array[char_array.length - 1] == '$';
        return b;
    }

    public static boolean is_valid(JSONObject message, JSONObject scheme){

        Iterator<String> keys = message.keys();
        boolean is_valid = keys.hasNext();

        while(is_valid && keys.hasNext()){

            String current_key = keys.next();

            try{
                is_valid = is_valid(message.getJSONObject(current_key), scheme.getJSONObject(current_key));

            }catch (JSONException json_exc){
                is_valid = is_valid(message.get(current_key).toString(), scheme.getString(current_key));
            }
        }

        return is_valid;

    }
}
