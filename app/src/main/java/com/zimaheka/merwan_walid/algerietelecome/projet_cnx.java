package com.zimaheka.merwan_walid.algerietelecome;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Walid Djebbouri on 22/05/2018.
 */


public class projet_cnx  extends StringRequest {
        private  static final String url = "http://djebbouuri-walid.000webhostapp.com/cnx.php" ;
        private HashMap<String , String > parmas  ;

        public   projet_cnx (String id_demande , String idprojet , Response.Listener<String> lisner){

            super(Method.POST, url , lisner , null);
            parmas = new HashMap<>();
            parmas.put("nom" , idprojet) ;
            parmas.put("iddemande" , id_demande) ;

        }

        @Override
        protected HashMap<String , String> getParams() throws AuthFailureError {
            return parmas;
        }




}
