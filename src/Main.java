import org.ejapps.sayho.sql.SelectSQL;
import utils.Log;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sayho on 2017-10-27.
 */
public class Main {

    public static void main(String ...args){
        Set<String> project = new HashSet<>();
        project.add("*");


        SelectSQL selectSQL = SelectSQL.builder().addPdojectSet(project).addTable("tbluser").addWhere("status=1").build();
        Log.e(selectSQL.toString());
    }
}
