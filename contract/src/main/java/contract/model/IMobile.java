package contract.model;

import java.awt.Point;

import showboard.IPawn;




public interface IMobile extends IPawn, IElement {


	/**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Move up left.
     */
	void moveUpLeft();
	
	 /**
     * Move down left.
     */
	void moveDownLeft();
	
	 /**
     * Move up right.
     */
	void moveUpRight();
	
	 /**
     * Move down right.
     */
	void moveDownRight();
	
	 /**
     * No move.
     */
	void doNothing();
	
    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();
    
    /**
     * Kill the player
     */
	void die();
    
    /**
     * Set player alive
     */
	void alive();
    /**
     * Checks if somthing happened.
     *
     * @return the boolean
     */
    Boolean isCrashed();
	Boolean isKilled();
	Boolean isOnCrystall();
	Boolean isOnOpenGate();

	/**
	 * GetPosition
	 */
    @Override
    Point getPosition();


}
