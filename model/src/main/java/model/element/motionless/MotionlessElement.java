package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Element;

public abstract class MotionlessElement extends Element {

	   /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    MotionlessElement(final ISprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
}
