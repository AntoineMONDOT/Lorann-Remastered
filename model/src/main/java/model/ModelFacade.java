package model;

import java.io.IOException;
import java.sql.SQLException;

import contract.model.ILevel;
import contract.model.IMobile;
import contract.model.IModelFacade;

public class ModelFacade implements IModelFacade {

	   /** The level. */
    private ILevel  level;

    /** The lorann. */
    private IMobile lorann;
    
    /**
     * Instantiates a new model.
     * this load and stored the level from the DB
     * this load the player & monsters
     *
     * @param idlevel
     *            the idlevel to know the level to load
     *            
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException 
     */
    public ModelFacade(final int idlevel) throws IOException, SQLException {
        this.setLevel(new Level(idlevel));
        //this.setLorann(new Lorann(, , this.getLevel()));
    }
    
    /**
     * get level
     * @return level
     */
    @Override
    public final ILevel getLevel() {
        return this.level;
    }

    /**
     * Sets the level.
     *
     * @param level
     * 
     */
    private void setLevel(final ILevel level) {
        this.level = level;
    }

    /**
     * get lorann
     * 
     *@return lorann
     */
    @Override
    public final IMobile getLorann() {
        return this.lorann;
    }

    /**
     * Sets lorann.
     *
     * @param lorann
     *
     */
    void setLorann(final IMobile lorann) {
        this.lorann = lorann;
    }

}
