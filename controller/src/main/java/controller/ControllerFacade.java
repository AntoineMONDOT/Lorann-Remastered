package controller;

import java.io.IOException;

import contract.controller.IControllerFacade;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.model.IModelFacade;
import contract.view.IViewFacade;



public class ControllerFacade implements IControllerFacade, IOrderPerformer {

    /** The Constant speed of the thread. */
    private static final int speed = 150;

    /** The view. */
    private IViewFacade view;

    /** The model. */
    private IModelFacade model;

    /** The stack order. */
    private UserOrder stackOrder;
    

	
    /**
     * Instantiates a new Lorann controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
	public ControllerFacade(final IViewFacade view, final IModelFacade model) {
		this.setView(view);
	    this.setModel(model);
	    this.clearStackOrder();
	}

	/**
	 * Drive the game, player movement and threading
	 */
	@Override
	public void play() throws InterruptedException {
		getModel().getLorann().alive();
		int i = 1;
		while (this.getModel().getLorann().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getLorann().moveRight();
                    break;
                case LEFT:
                    this.getModel().getLorann().moveLeft();
                    break;
                case UP:
                    this.getModel().getLorann().moveUp();
                    break;
                case DOWN:
                    this.getModel().getLorann().moveDown();
                    break;
                case DOWNRIGHT:
                    this.getModel().getLorann().moveDownRight();
                    break;
                case UPRIGHT:
                    this.getModel().getLorann().moveUpRight();
                    break;
                case DOWNLEFT:
                    this.getModel().getLorann().moveDownLeft();
                    break;
                case UPLEFT:
                    this.getModel().getLorann().moveUpLeft();
                    break;
                case SHOOT:
                    this.getModel().getLorann().doNothing();
                    break;
                case NOP:
                default:
                		switch ( i ) {
                		case 1:
                			this.getModel().getLorann().doNothing1();
                			i=2;
                			break;
                		case 2:
                    		this.getModel().getLorann().doNothing2();
                    		i=3;
                    		break;
                		case 3:
                    		this.getModel().getLorann().doNothing3();
                    		i=4;
                    		break;
                		case 4:
                    		this.getModel().getLorann().doNothing4();
                    		i=1;
                    		break;
                	}
                	
                    
                    
            }
            this.clearStackOrder();

            //this.getView().followMyVehicle();
        }
        this.getView().displayMessage("You died");
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
