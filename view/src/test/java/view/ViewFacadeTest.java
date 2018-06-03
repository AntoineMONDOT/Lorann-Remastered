package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;

import contract.controller.UserOrder;

public class ViewFacadeTest {

	@Test
	public void testkeyCodeToUserOrderRIGHT(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_RIGHT),UserOrder.RIGHT);
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_D),UserOrder.RIGHT);
	}

	@Test
	public void testkeyCodeToUserOrderLEFT(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_LEFT),UserOrder.LEFT);
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_Q),UserOrder.LEFT);
	}
	
	@Test
	public void testkeyCodeToUserOrderUP(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_UP),UserOrder.UP);
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_Z),UserOrder.UP);
	}

	@Test
	public void testkeyCodeToUserOrderDOWN(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_DOWN),UserOrder.DOWN);
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_S),UserOrder.DOWN);
	}
	
	@Test
	public void testkeyCodeToUserOrderUPRIGHT(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_E),UserOrder.UPRIGHT);
	}

	@Test
	public void testkeyCodeToUserOrderUPLEFT(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_A),UserOrder.UPLEFT);
	}
	
	
	@Test
	public void testkeyCodeToUserOrderDOWNRIGHT(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_X),UserOrder.DOWNRIGHT);
	}

	@Test
	public void testkeyCodeToUserOrderDOWNLEFT(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_W),UserOrder.DOWNLEFT);
	}
	
	@Test
	public void testkeyCodeToUserOrderSHOOT(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_SPACE),UserOrder.SHOOT);
	}
	
	@Test
	public void testkeyCodeToUserOrderNOP(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_F),UserOrder.NOP);
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_ALT),UserOrder.NOP);
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_KP_RIGHT),UserOrder.NOP);
	}
	
}
