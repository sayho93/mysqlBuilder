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
        project.add("userNo");
        project.add("userName");
        project.add("userID");
        project.add("userNick");

        SelectSQL selectSQL = SelectSQL.builder()
                .addPdojectSet(project)
                .setTable("tbluser")
                .addWhere("status", "=", "AAA")
                .addWhere("status", "<", "3")
                .addWhere("regDate", "<", "NOW()")
                .addOrderBy("regDate DESC")
                .build();

        Log.e(selectSQL.toString());
    }
}
