package main;

import java.io.IOException;

import contract.controller.IControllerFacade;
import contract.model.IModelFacade;
import contract.view.IViewFacade;
import controller.ControllerFacade;
import model.ModelFacade;
import view.ViewFacade;



public class Main {
   
	public static void main(final String[] args) throws IOException, InterruptedException {
        final IModelFacade model = new ModelFacade("level.txt");
        final IViewFacade view = new ViewFacade(model.getLevel(), model.getLorann());
        final IControllerFacade controller = new ControllerFacade(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}