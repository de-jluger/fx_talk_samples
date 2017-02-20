package de.jluger.jugn_vortrag.sample005;

import java.util.function.BiFunction;

public class Operation {
	private int id;
	private BiFunction<Double, Double, Double> calcFunction;

	public Operation(int id, BiFunction<Double, Double, Double> calcFunction) {
		super();
		this.id = id;
		this.calcFunction = calcFunction;
	}

	public int getId() {
		return id;
	}

	public BiFunction<Double, Double, Double> getCalcFunction() {
		return calcFunction;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", calcFunction=" + calcFunction + "]";
	}
}
