/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

/**
 * Just a reminder Because basically all the frames required in the
 * specification have something in common, then I decided to do this class to
 * enforce them.
 *
 * @author Archer
 */
public interface FundamentalFunctions {

    /**
     * This method is to view all the records if the
     */
    public void view();

    //TODO exception
    /**
     * This method is to insert a record
     *
     * @param values The values that to be inserted. Must match the indicated
     * {@code columns} or the columns in the table, if the {@code columns} is
     * null.
     */
    public void insert(String[] values);

    /**
     * This method is to update a record
     *
     */
    public void update(Object[][] updatedData);

    /**
     * This method is to delete the record(s) indicated by the @values
     *
     * @param condition The where clause that to specify the row(s) to be
     * indicated, excluded the word "where".
     * @return True if the insert operation successful
     */
    public boolean delete(String condition);

    /**
     * This method is to search record(s) by the {@code condition}, and
     *
     * @param condition The where clause, excluded the word "where".
     */
    public void searchBy(String condition);
}
