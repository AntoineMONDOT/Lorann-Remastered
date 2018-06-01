package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import contract.model.IElement;
import contract.model.ILevel;
import model.dao.StoredProcedureDAO;
import model.element.motionless.MotionlessElementFactory;

public class Level extends Observable implements ILevel {
    /** The width. */
    private int          width = 24;

    /** The height. */
    private int          height = 12;

    /** The on the level. */
    private IElement[][] onTheLevel;

    /**
     * Instantiates a new level with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException 
     */
    Level(final int idlevel) throws IOException, SQLException {
        super();
        this.loadFile(idlevel);
    }

    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException 
     */
    private void loadFile(final int idlevel) throws IOException, SQLException {

        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()];
        
    	for (int n=0; n<height; n++)
    	{

    		for (int i=0; i < width;i++)
    		{
    			this.setOnTheRoadXY(MotionlessElementFactory.getFromFileSymbol(' '), i, n);
    		}
    	}
        ResultSet result;
    	
    	result = StoredProcedureDAO.getLevelCompById(idlevel);
    	
        while(result.next()) {
            this.setOnTheRoadXY(MotionlessElementFactory.getFromFileSymbol(result.getString(3).charAt(0)),result.getInt(1),result.getInt(2));
        }
        result.close();
    }
    /**
     * get the width
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /**
     * get the height
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /**
     * get element by XY
     */
    @Override
    public final IElement getOnTheLevelXY(final int x, final int y) {
        return this.onTheLevel[x][y];
    }

    /**
     * Sets the on the level XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private void setOnTheRoadXY(final IElement element, final int x, final int y) {
        this.onTheLevel[x][y] = element;
    }

    /**
     * Notify view of change
     */
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Get the observable
     */
    @Override
    public Observable getObservable() {
        return this;
    }
}
