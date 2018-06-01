package model;

import java.io.IOException;

import contract.model.ILevel;
import contract.model.IMobile;
import contract.model.IModelFacade;
import model.element.mobile.Lorann;

public class ModelFacade implements IModelFacade {

	   /** The road. */
    private ILevel  level;

    /** The my vehicle. */
    private IMobile lorann;
    
    /**
     * Instantiates a new model.
     *
     * @param fileName
     *            the file name
     *            
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public ModelFacade(final String fileName) throws IOException {
        this.setLevel(new Level(fileName));
        this.setLorann(new Lorann(21, 6, this.getLevel()));
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
    private void setLorann(final IMobile lorann) {
        this.lorann = lorann;
    }

}
