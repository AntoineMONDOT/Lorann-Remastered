package contract.view;

import contract.controller.IOrderPerformer;

public interface IViewFacade {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);


    /**
     * Set the order to execute
     *
     * @param orderPerfomer
     *            the order
     */
	void setOrderPerformer(IOrderPerformer orderPeformer);


	void OpenGateUpdate();





}
