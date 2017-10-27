package org.ejapps.sayho.sql.model;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class PairMap extends HashMap<String, List<OperatorPair>> {

    public void addCondition(String key, OperatorPair pair){
        if(this.containsKey(key)){
            this.get(key).add(pair);
        }else{
            List<OperatorPair> list = new Vector<>();
            list.add(pair);
            this.put(key, list);
        }
    }

}
