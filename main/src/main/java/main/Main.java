package main;

import java.io.IOException;
import java.sql.SQLException;

import contract.controller.IControllerFacade;
import contract.model.IModelFacade;
import contract.view.IViewFacade;
import controller.ControllerFacade;
import model.ModelFacade;
import model.dao.StoredProcedureDAO;
import view.ViewFacade;



public class Main {
   
	public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
		//StoredProcedureDAO.getLevelCompById(1);
		
		final IModelFacade model = new ModelFacade(2);
        final IViewFacade view = new ViewFacade(model.getLevel(), model.getLorann());
        final IControllerFacade controller = new ControllerFacade(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}