package contract.model;

public enum Permeability {
    /** The blocking for walls. */
    BLOCKING,
    
    /** The killing for gate_close, monsters  */
    KILLING,
    
    /** The penetrable for blacktile(background). */
    PENETRABLE,
    
    /** The opening for crystall */
    OPENNING,
	
    /** The open gate */
	OPENGATE, 
	
    /** The Lorann Power */
	POWER;
}
