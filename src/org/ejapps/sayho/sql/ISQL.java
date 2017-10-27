package org.ejapps.sayho.sql;

import java.io.Serializable;

/**
 * Created by sayho on 2017-10-27.
 */
public interface ISQL extends Serializable{

    Object execute();

}
