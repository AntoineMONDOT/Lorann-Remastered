package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

public class VerticalBone extends MotionlessElement {
	   /** The Constant SPRITE. */
 private static final ISprite SPRITE = new Sprite('|', "vertical_bone.png");

	 /**
	  * Instantiates a new crystal.
	  */
	 VerticalBone() {
	     super(SPRITE, Permeability.BLOCKING);
	 }
}
