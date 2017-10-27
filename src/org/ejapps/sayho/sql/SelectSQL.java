package org.ejapps.sayho.sql;

import com.sun.deploy.util.StringUtils;

import java.util.Set;

/**
 * Created by sayho on 2017-10-27.
 */
public class SelectSQL extends SQL {
    private final SQLConfig sqlConfig;

    private Set<String> projectSet;
    private String table;
    private String where;
    private String orderBy;
    private String limit;

    private SelectSQL(SQLConfig sqlConfig){
        this.sqlConfig = sqlConfig;
    }

    private SelectSQL(Set<String> projectSet, String table, String where, String orderBy, String limit){
        this.projectSet = projectSet;
        this.table = table;
        this.where = where;
        this.orderBy = orderBy;
        this.limit = limit;

        this.sqlConfig = new SQLConfig(projectSet, table, where, orderBy, limit);
    }

    public SQLConfig config() {
        return sqlConfig;
    }

    @Override
    public String toString() {
//        return "SelectSql{" +
//                "SQLConfig=" + sqlConfig +
//                '}';
        String query = "SELECT ";
        query += "`" + StringUtils.join(sqlConfig.getProjectSet(), "`,`") + "`";
        query += " FROM " + sqlConfig.getTable();
        query += " WHERE " + sqlConfig.getWhere();

        if(orderBy != null)
            query += " ORDER BY " + sqlConfig.getOrderBy();
        if(limit != null)
            query += " LIMIT " + sqlConfig.getLimit();

        return query;
    }

    public static SQLBuilder builder(){
        return new SelectSQL.SQLBuilder();
    }

    public static class SQLBuilder extends Builder{

        private SQLBuilder(){
            super();
        }

        public SQLBuilder addPdojectSet(Set<String> projectSet){
            for(String project : projectSet)
                this.sqlConfig.getProjectSet().add(project);
            return this;
        }

        public SQLBuilder addTable(String table){
            this.sqlConfig.setTable(table);
            return this;
        }

        public SQLBuilder addWhere(String where){
            this.sqlConfig.setWhere(where);
            return this;
        }

        public SQLBuilder addOrderBy(String orderBy){
            this.sqlConfig.setOrderBy(orderBy);
            return this;
        }

        public SQLBuilder addLimit(String limit){
            this.sqlConfig.setLimit(limit);
            return this;
        }

        public SelectSQL build(){
            SelectSQL selectSQL = new SelectSQL(this.sqlConfig);
            return selectSQL;
        }

    }

    @Override
    public Object execute() {
        return null;
    }

    @Override
    public String toExecutable() {
        return null;
    }

    @Override
    public String clear() {
        return null;
    }
}
