package com.example;

import akka.actor.UntypedActor;

import java.util.HashMap;
import java.util.Map;

public class BillingWorker extends UntypedActor {

	Map<String, Integer> cache = new HashMap<String, Integer>();

	@Override
	public void onReceive(Object message) {
		if (message instanceof MyMessage) {
			System.out.println("Order recieved by " + getSelf());

		} else {
			unhandled(message);
		}
	}

}