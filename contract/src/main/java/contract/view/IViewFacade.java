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



	void setOrderPerformer(IOrderPerformer orderPeformer);
}
