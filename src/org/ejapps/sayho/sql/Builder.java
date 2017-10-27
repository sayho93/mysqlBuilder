package org.ejapps.sayho.sql;

import java.util.HashSet;

/**
 * Created by p on 2017-10-27.
 */
public class Builder {
    protected SQLConfig sqlConfig;

    protected Builder(){
        sqlConfig = new SQLConfig();
        sqlConfig.setProjectSet(new HashSet<>());
        sqlConfig.setTable("");
        sqlConfig.setWhere("");
        sqlConfig.setOrderBy("");
        sqlConfig.setLimit("");
    }

}
