package br.com.opah.broker.exceptions;

public class TravelException extends RuntimeException {

    public TravelException(String message) {
        super(message);
	}

	public static final String NULL_HOTELS_LIST = "Null hotels list.";
}
