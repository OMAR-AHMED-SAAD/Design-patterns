package strategy;

//MAIN DUCK CLASS
public abstract class Duck {
	flyBehavior fB;

	public void swim() {
		System.out.println(this.getClass().getSimpleName() + " is Swimming");
	}

	public void performfly() {
		fB.fly(this.getClass().getSimpleName());
	}

	public void setFlyBehavior(flyBehavior fb2) {
		this.fB = fb2;
	}

}

//REDDUCK CLASS
class RedDuck extends Duck {
	public RedDuck() {
		fB = new flywithwings();
	}

}

//RUBBERDUCK CLASS
class RubberDuck extends Duck {
	public RubberDuck() {
		fB = new cannotfly();
	}

}

interface flyBehavior {
	void fly(String name);
}

class flywithwings implements flyBehavior {
	public void fly(String name) {
		System.out.println(name + " flying with wings");
	}
}

class cannotfly implements flyBehavior {
	public void fly(String name) {
		System.out.println(name + " can not fly");
	}
}

//SIMULATOR CLASS
class simulator {
	public static void main(String[] args) {
		new RubberDuck().performfly();
		RedDuck dodo = new RedDuck();
		dodo.performfly();
		dodo.setFlyBehavior(new cannotfly());
		dodo.performfly();

	}
}
