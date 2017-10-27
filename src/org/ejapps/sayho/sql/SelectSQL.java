package org.ejapps.sayho.sql;

import com.sun.deploy.util.StringUtils;
import org.ejapps.sayho.sql.model.OperatorPair;
import org.ejapps.sayho.sql.model.PairMap;

import java.util.*;

/**
 * Created by sayho on 2017-10-27.
 */
public class SelectSQL extends SQL {
    private SQLConfig sqlConfig;

    private String whereClause;
    private String orderBy;
    private String limit;

    private SelectSQL(SQLConfig sqlConfig){
        this.sqlConfig = sqlConfig;

        Iterator<String> iter = sqlConfig.getWhere().keySet().iterator();

        List<String> tempList = new Vector<>();

        while(iter.hasNext()){
            final String column = iter.next();
            for(OperatorPair pair : sqlConfig.getWhere().get(column)){
                String last = pair.getRight();
                // TODO 효율적으로 처리하도록 수정
                try{
                    Double.parseDouble(last);
                }catch (NumberFormatException e){
                    last = "'" + last + "'";
                }
                tempList.add("`" + column + "` " + pair.getLeft() + " " + last);
            }
        }

        this.whereClause = StringUtils.join(tempList, " AND ");

    }

    public SQLConfig config() {
        return sqlConfig;
    }

    @Override
    public String toString() {
        String query = "\n\nSELECT ";
        query += "`" + StringUtils.join(sqlConfig.getProjectSet(), "`,`") + "`\n";
        query += "FROM " + sqlConfig.getTable() + "\n";
        query += "WHERE " + this.whereClause + "\n";

        if(orderBy != null)
            query += "ORDER BY " + sqlConfig.getOrderBy() + "\n";
        if(limit != null)
            query += "LIMIT " + sqlConfig.getLimit() + "\n";

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

        public SQLBuilder setTable(String table){
            this.sqlConfig.setTable(table);
            return this;
        }

        public SQLBuilder addWhere(String column, String operator, String option2){
            PairMap where = sqlConfig.getWhere();
            OperatorPair tmp = new OperatorPair(operator, option2);
            where.addCondition(column, tmp);
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
