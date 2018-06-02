package controller;

import java.io.IOException;

import contract.controller.IControllerFacade;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.model.IModelFacade;
import contract.view.IViewFacade;
import contract.model.IMobile;



public class ControllerFacade implements IControllerFacade, IOrderPerformer {

    /** The game-thread refresh speed. */
    private static final int speed = 150;

    /** The view. */
    private IViewFacade view;

    /** The model. */
    private IModelFacade model;

    /** The stack order. */
    private UserOrder stackOrder;
    
    /** The monster of type 1. */
    private IMobile monster1;
    
    /** The monster of type 1. */
    private IMobile monster2;

	/** The monster of type 1. */
    private IMobile monster3;
    
    /** The monster of type 1. */
    private IMobile monster4;
    
    private boolean win;
    

	
    /**
     * Instantiates a new Lorann controller
     * It will be used to move the player, monsters, power and the level and also to check if there is collision, kill ...
     *
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
	public ControllerFacade(final IViewFacade view, final IModelFacade model) {
		this.setView(view);
	    this.setModel(model);
	    this.clearStackOrder(); //set the user order to NOP so we are sure that the player do not move on spawn
	}

	/**
	 * Drive the game element movement, behavior and threading
	 */
	@Override
	public void play() throws InterruptedException {
		
		getModel().getLevel().getLorann().alive(); // when the player lorann is load on the map is not alive so we set it alive after everything is load
		
		if(getModel().getLevel().getMonster1instance() != false) { //if a monster 1,2,3,4 from level exist then we stored it in monster 1,2,3,4
			monster1 = getModel().getLevel().getMonster1();
			monster1.doNothing();
			}
        if(getModel().getLevel().getMonster2instance() != false) {
        	monster2 = getModel().getLevel().getMonster2();
        	monster2.doNothing();
        	}
        if(getModel().getLevel().getMonster3instance() != false) {
        	monster3 = getModel().getLevel().getMonster3();
        	monster3.doNothing();
        	}
        if(getModel().getLevel().getMonster4instance() != false) {
        	monster4 = getModel().getLevel().getMonster4();
        	monster4.doNothing();
        	}
		
		while (this.getModel().getLevel().getLorann().isAlive() && win == false) { //here it's the heart a loop that will be repeated until the player isNotAlive
            
			Thread.sleep(speed); //make the thread sleep for a little time (in milliseconds)
			
			if(getModel().getLevel().getLorann().isOnCrystall()) {getModel().getLevel().changeGate();}
			if(getModel().getLevel().getLorann().isOnOpenGate()) {win = true;}
			
			switch (this.getStackOrder()) { //this case execute the method associated to the user order (move, shot, nothing)
                case RIGHT:
                    this.getModel().getLevel().getLorann().moveRight();
                    break;
                case LEFT:
                    this.getModel().getLevel().getLorann().moveLeft();
                    break;
                case UP:
                    this.getModel().getLevel().getLorann().moveUp();
                    break;
                case DOWN:
                    this.getModel().getLevel().getLorann().moveDown();
                    break;
                case DOWNRIGHT:
                    this.getModel().getLevel().getLorann().moveDownRight();
                    break;
                case UPRIGHT:
                    this.getModel().getLevel().getLorann().moveUpRight();
                    break;
                case DOWNLEFT:
                    this.getModel().getLevel().getLorann().moveDownLeft();
                    break;
                case UPLEFT:
                    this.getModel().getLevel().getLorann().moveUpLeft();
                    break;
                case SHOOT:
                case NOP:
                default:
                	this.getModel().getLevel().getLorann().doNothing();
                	break;
                	}
                	
                    
                    
            
            this.clearStackOrder(); // this reset the user order to NOP so it will not continue to move when you released the key

        }
		if (win =! true) {
		getModel().getLevel().getLorann().die();
		
        this.getView().displayMessage("You loose"); //when the main loop is break this display the message you loose on a popup 	
		}
		else {
		this.getView().displayMessage("You win");
		}
	}
	
    /**
     * Write the UserOrder in the stack of order (stackOrder)
     */
	@Override
	public void orderPerform(UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}
	
    /**
     * Gets the view.
     *
     * @return the view
     */
    private IViewFacade getView() {
        return this.view;
    }
    
    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IViewFacade view) {
        this.view = view;
    }
    
    /**
     * Gets the model.
     *
     * @return the model
     */
    private IModelFacade getModel() {
        return this.model;
    }
    
    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IModelFacade model) {
        this.model = model;
    }
    
    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

   /**
    * Get the order to perform
    */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}
