package controller;

import java.io.IOException;
import java.util.ArrayList;

import contract.controller.IControllerFacade;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.model.IModelFacade;
import contract.model.Permeability;
import contract.view.IViewFacade;
import contract.model.IElement;
import contract.model.IMobile;



public class ControllerFacade implements IControllerFacade, IOrderPerformer {

    /** The game-thread refresh speed. */
    private static final int speed = 35;

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
    
    /** Monsters Array */
    @SuppressWarnings("rawtypes")
	private ArrayList monsters = new ArrayList();
    
    /** The Lorann. */
    private IMobile lorann;
    
    /** The Gate. */
    private IElement gate;
    
    /** The Crystal. */
    private IElement crystal;
    
    /** The boolean to stop game if player finish the level */
    private boolean win;

    /** The Monsters counter speed */
	private int delay;
	
	/** The Monster speed */
	private int mobSpeed = 15;

	
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
	@SuppressWarnings("unchecked")
	@Override
	public void play() throws InterruptedException {
		
		//---------------------------------------------------------------------------------------------------
		//		This part prepare the variable and element of the level depending on each level
		//---------------------------------------------------------------------------------------------------
		// when the player lorann is load on the map is not alive so we set it alive after everything is load
		lorann = getModel().getLevel().getLorann();
		lorann.alive();
		
		//Store the gate and crystal in the controller
		gate = getModel().getLevel().getGate();
		crystal = getModel().getLevel().getCrystal();
		
		//if a monster 1,2,3,4 from level exist then we stored it in monster 1,2,3,4
		if(getModel().getLevel().getMonster1instance() != false) { 
			monster1 = getModel().getLevel().getMonster1();
			monster1.doNothing();
			monsters.add(monster1);
			}
        if(getModel().getLevel().getMonster2instance() != false) {
        	monster2 = getModel().getLevel().getMonster2();
        	monster2.doNothing();
        	monsters.add(monster2);
        	}
        if(getModel().getLevel().getMonster3instance() != false) {
        	monster3 = getModel().getLevel().getMonster3();
        	monster3.doNothing();
        	monsters.add(monster3);
        	}
        if(getModel().getLevel().getMonster4instance() != false) {
        	monster4 = getModel().getLevel().getMonster4();
        	monster4.doNothing();
        	monsters.add(monster4);
        	}
        
      //if the level didn't get a crystal then we open the gate on level start
        if(getModel().getLevel().getCrystal() == null) {
        	getModel().getLevel().getGate().setPermeability(Permeability.OPENGATE);
        	getView().OpenGateUpdate();
        	}
		
      //----------------------------------------------------------------------------
      //								GAME LOOP
      //----------------------------------------------------------------------------
      //here it's the heart a loop that will be repeated until the player isNotAlive
		while (lorann.isAlive() && win == false) { 
            
			Thread.sleep(speed); //make the thread sleep for a little time (in milliseconds)
			
			//if player is on the crystall the we open the gate
			if(lorann.isOnCrystall()) {
				gate.setPermeability(Permeability.OPENGATE);//update the gate permeability from KILLING to OPENGATE
	        	crystal.setPermeability(Permeability.PENETRABLE);
				getView().OpenGateUpdate();
			}
			
			//if the lorann is on the gate when it's open then we stop the game and say you win
			if(lorann.isOnOpenGate()) {win = true;}
			
			//if the lorann is on something that kill him then we stop the game and say you loose
			if(lorann.isKilled()) {lorann.die();}
			
			
			switch (this.getStackOrder()) { //this case execute the method associated to the user order (move, shot, nothing)
                case RIGHT:
                    this.lorann.moveRight();
                    break;
                case LEFT:
                    this.lorann.moveLeft();
                    break;
                case UP:
                    this.lorann.moveUp();
                    break;
                case DOWN:
                    this.lorann.moveDown();
                    break;
                case DOWNRIGHT:
                    this.lorann.moveDownRight();
                    break;
                case UPRIGHT:
                    this.lorann.moveUpRight();
                    break;
                case DOWNLEFT:
                    this.lorann.moveDownLeft();
                    break;
                case UPLEFT:
                    this.lorann.moveUpLeft();
                    break;
                case SHOOT:
                case NOP:
                default:
                	this.lorann.doNothing();
                	break;
			}
			
			
			/*for (int i=0; i<monsters.size(); i++) {
				MonsterIA((IMobile)monsters.get(i));
			}*/
			
            
            this.clearStackOrder(); // this reset the user order to NOP so it will not continue to move when you released the key

        }
		if (win != true) {
		lorann.die();
		
        this.getView().displayMessage("You loose"); //when the main loop is break this display the message you loose on a popup 	
		}
		else {
		this.getView().displayMessage("You win");
		}
	}
	
	/**
	 * This function is a kind of IA for monster to go on Lorann
	 */
	private void MonsterIA(IMobile monster) {
	   	if(delay == mobSpeed) {
    		delay=0;
		if(lorann.getX() > monster.getX()) {
            monster.moveRight();

		}
		if(lorann.getX() < monster.getX()) {
            monster.moveLeft();

		}
		if(lorann.getY() < monster.getY()) {
            monster.moveUp();

		}
		if(lorann.getY() > monster.getY()) {
            monster.moveDown();

		}
	   	}
	   	else delay++;
		MobOnMobChecker(monster);
	}
	
	public void MobOnMobChecker(IMobile monster) {
		/*if(monster.getX() > monsters.getX()) {
            monster.moveRight();

		}
		if(monster.getX() < monsters.getX()) {
            monster.moveLeft();

		}
		if(monster.getY() < monsters.getY()) {
            monster.moveUp();

		}
		if(monster.getY() > monsters.getY()) {
            monster.moveDown();

		}*/
		MobKillChecker(monster);
	}

	public void MobKillChecker(IMobile monster) {
		if(lorann.getX()==monster.getX() && lorann.getY()==monster.getY() ) {lorann.die();}
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
