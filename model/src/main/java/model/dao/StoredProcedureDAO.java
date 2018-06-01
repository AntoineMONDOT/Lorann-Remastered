package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import contract.model.IElement;


/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class StoredProcedureDAO extends AbstractDAO {

    /** The sql example by id. */
    private static String sqlExampleById   = "{call getLevelCompById(?)}";

    /** The id column index. */
    private static int    ColumnX    = 1;

    /** The name column index. */
    private static int    ColumnY  = 2;
    
    /** The name column index. */
    private static int    ColumnSprite  = 3;
    
    private static ResultSet result;
    /**
     * Gets each sprite of the choosen level.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
   public static ResultSet getLevelCompById(final int idlevel) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleById);
        callStatement.setInt(1, idlevel); //define the first variable of the stored procedure to idlevel to choose the level to load
        
        if (callStatement.execute()) {
            result = callStatement.getResultSet();
        }
		return result;

    }

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
   /* public static Example getExampleByName(final String name) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleByName);
        Example example = null;

        callStatement.setString(1, name);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                example = new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return example;
    }*/

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    /*public static List<Example> getAllExamples() throws SQLException {
        final ArrayList<Example> examples = new ArrayList<Example>();
        final CallableStatement callStatement = prepareCall(sqlAllExamples);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                examples.add(new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex)));
            }
            result.close();
        }
        return examples;
    }*/
}
