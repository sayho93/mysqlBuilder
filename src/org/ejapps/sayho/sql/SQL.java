package org.ejapps.sayho.sql;

/**
 * Created by sayho on 2017-10-27.
 */
public abstract class SQL implements ISQL{

    public abstract String toExecutable();

    public abstract String clear();

}
