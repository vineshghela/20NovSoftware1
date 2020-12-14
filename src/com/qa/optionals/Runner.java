package com.qa.optionals;

import java.util.Optional;

public class Runner {

	public static void main(String[] args) {

		Runner runner = new Runner();
		Integer val1 = null;
		Integer val2 = new Integer(10);

		Optional<Integer> a = Optional.ofNullable(val1);

		Optional<Integer> b = Optional.of(val2);

		System.out.println(runner.sum(a, b));

	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		System.out.println("parm 1 " + a.isPresent());
		System.out.println("parm 2 " + b.isPresent());

		Integer val1 = a.orElse(new Integer(0));

		Integer val2 = b.get();

		return val1 + val2;
	}

}
