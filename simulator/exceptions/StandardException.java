package simulator.exceptions;

public class StandardException extends Exception {
	private static final long serialVersionUID = 1L; // this exists to make a ridiculous warning shut up

	public StandardException(final String err) {
		super(err);
	}
}