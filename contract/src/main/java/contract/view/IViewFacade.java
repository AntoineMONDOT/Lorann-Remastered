package contract.view;

import contract.controller.IOrderPerformer;
import contract.model.IMobile;

public interface IViewFacade {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);


	void setOrderPerformer(IOrderPerformer orderPeformer);


	void OpenGateUpdate();


	void PowerSpawn(IMobile power);





}
