package contract.model;

import java.util.Observable;

import showboard.IPawn;

public interface ILevel {

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    IElement getOnTheLevelXY(int x, int y);

    /**
     * Sets the mobile has changed.
     */
    void setMobileHasChanged();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();

	IMobile getLorann();

	IMobile getMonster1();

	IMobile getMonster2();

	IMobile getMonster3();

	IMobile getMonster4();

	boolean getMonster4instance();

	boolean getMonster1instance();

	boolean getMonster2instance();

	boolean getMonster3instance();
}
