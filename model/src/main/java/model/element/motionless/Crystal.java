package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

public class Crystal extends MotionlessElement {
	   /** The Constant SPRITE. */
 private static final ISprite SPRITE = new Sprite('X', "crystal_ball.png");

 /**
  * Instantiates a new crystal.
  */
 Crystal() {
     super(SPRITE, Permeability.OPENNING);
 }
}
