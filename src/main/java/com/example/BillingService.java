package com.example;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.FromConfig;

public class BillingService extends UntypedActor {

	// This router is used both with lookup and deploy of routees. If you
	// have a router with only lookup of routees you can use Props.empty()
	// instead of Props.create(StatsWorker.class).
	ActorRef workerRouter = getContext().actorOf(Props.create(com.example.BillingSupervisor.class),
			"workerRouter");

	@Override
	public void onReceive(Object message) {
		if (message instanceof MyMessage) {
			workerRouter.tell(message, getSelf());
		} else {
			unhandled(message);
		}
	}
}
