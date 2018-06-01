package model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import contract.model.IElement;
import contract.model.ILevel;
import contract.model.IMobile;
import model.dao.StoredProcedureDAO;
import model.element.mobile.Lorann;
import model.element.motionless.MotionlessElementFactory;

public class Level extends Observable implements ILevel {
    /** The width. */
    public int          width = 24;

    /** The height. */
    public int          height = 12;

    /** The on the level. */
    private IElement[][] onTheLevel;
    
    /** The lorann. */
    private IMobile lorann;
   

    /**
     * Instantiates a new level with the content of the db.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException 
     */
    Level(final int idlevel) throws IOException, SQLException {       
    	super();
        this.loadLevel(idlevel);
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
    private void loadLevel(final int idlevel) throws IOException, SQLException {

        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()]; //create a 24/12 board and set all compartement to null 
        
    	for (int n=0; n<height; n++) //now set all compartment to the default square 'blacktile' (background)
    	{

    		for (int i=0; i < width;i++)
    		{
    			this.setOnTheRoadXY(MotionlessElementFactory.getFromFileSymbol(' '), i, n);
    		}
    	}
    	
    	//this will stored the result return by the stored procedure
        ResultSet result = StoredProcedureDAO.getLevelCompById(idlevel); //
    	
        while(result.next()) { //while there is element for this level then we overwrite the default background
        	
        	switch (result.getString(StoredProcedureDAO.getColumnSprite()).charAt(0)) {
        	
        	case '@'://if character correspond to lorann (@) then we create lorann
        		setLorann(new Lorann(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            break;
        	/*case '1'://if character correspond to monster1 (1) then we create monster1
            	setLorann(new Lorann(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            break;
        	case '2'://if character correspond to monster2 (2) then we create monster2
            	setLorann(new Lorann(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            break;
        	case '3'://if character correspond to monster3 (3) then we create monster3
            	setLorann(new Lorann(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            break;
        	case '4'://if character correspond to monster4 (4) then we create monster4
            	setLorann(new Lorann(result.getInt(StoredProcedureDAO.getColumnX()), result.getInt(StoredProcedureDAO.getColumnY()), this));
            break;*/
            default:
        	this.setOnTheRoadXY(MotionlessElementFactory.getFromFileSymbol(
            		result.getString(StoredProcedureDAO.getColumnSprite()).charAt(0)),result.getInt(StoredProcedureDAO.getColumnX()),result.getInt(StoredProcedureDAO.getColumnY()));
            break;
            }
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
     * get the height
     */
    @Override
    public final int getHeight() {
        return this.height;
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

	public IMobile getLorann() {
		return lorann;
	}

	public void setLorann(IMobile lorann) {
		this.lorann = lorann;
	}
}
