package main;

import java.io.IOException;
import java.sql.SQLException;

import contract.controller.IControllerFacade;
import contract.model.IModelFacade;
import contract.view.IViewFacade;
import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;



public class Main {
   
	/**
	 * The main function of Lorann Game
	 * It instantiate a model, view and controller
	 * It make the view updating in function of the controller
	 * It launch the heart of the game (play) which is a loop that run until player as 0 life
	 * 
	 * @param args
	 * 		the args
	 * @throws IOException
	 * 		the IO exception
	 * @throws InterruptedException
	 * 		the thread exception
	 * @throws SQLException
	 * 	the SQL exception
	 */
	
	public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
	
		final IModelFacade model = new ModelFacade(2); 									//change the number to the wanted level
        final IViewFacade view = new ViewFacade(model.getLevel()); 						//we gave to the view the level and all element that the level contain
        final IControllerFacade controller = new ControllerFacade(view, model); 		//the controller got the view and model to control them
        view.setOrderPerformer(controller.getOrderPeformer()); 							//this enable the view be update when there is a player movement from the controller

        controller.play(); 																//launch the 'infinite' loop of the game
    }
}