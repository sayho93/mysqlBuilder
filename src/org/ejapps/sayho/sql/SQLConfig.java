package org.ejapps.sayho.sql;

import java.util.Set;

/**
 * Created by sayho on 2017-10-27.
 */
public class SQLConfig {

    public static final String WHOLE_PROJECTION = "*";

    private Set<String> projectSet;
    private String table;
    private String where;
    private String orderBy;
    private String limit;

    public SQLConfig() {
    }

    public SQLConfig(Set<String> projectSet, String table, String where, String orderBy, String limit){
        this.projectSet = projectSet;
        this.table = table;
        this.where = where;
        this.orderBy = orderBy;
        this.limit = limit;
    }

    public static String getWholeProjection() {
        return WHOLE_PROJECTION;
    }

    public Set<String> getProjectSet() {
        return projectSet;
    }

    public String getTable() {
        return table;
    }

    public String getWhere() {
        return where;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getLimit() {
        return limit;
    }
    public void setProjectSet(Set<String> projectSet) {
        this.projectSet = projectSet;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "SQLConfig{" +
                "projectSet=" + projectSet.toString() +
                ", table=" + table+
                ", where=" + where +
                ", orderBy=" + orderBy +
                ", limit=" + limit +
                '}';
    }
}
