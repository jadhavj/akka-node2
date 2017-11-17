package com.example;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class BillingSupervisor extends UntypedActor {

	ActorRef billingWorker = getContext().actorOf(Props.create(BillingWorker.class));

	@Override
	public void onReceive(Object message) {
		if (message instanceof MyMessage) {
			billingWorker.tell(message, getSelf());
		} else {
			unhandled(message);
		}
	}

}