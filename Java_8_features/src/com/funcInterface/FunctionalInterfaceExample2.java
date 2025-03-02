package com.funcInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceExample2 {

	public static void main(String[] args) {

		// Predicate Functional Interface
		Predicate<Integer> p = x -> x > 50;
		System.out.println(p.test(55));

		// BiPredicate Functional Interface
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		System.out.println(bi.test(100, 45));

		// Consumer Functional Interface
		Consumer<String> c = x -> System.out.println(x.length());
		c.accept("Hello");

		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Consumer<Integer> c1 = x -> System.out.println(x);
		lst.stream().forEach(c1);

		// BiConsumer Functional Interface
		BiConsumer<Integer, Integer> biCons = (x, y) -> System.out.println(x + " " + y);
		biCons.accept(10, 20);

		// Function Functional Interface
		Function<Integer, Boolean> f = x -> x > 50;
		System.out.println(f.apply(455));

		// BiFunction Functional Interface
		BiFunction<Integer, Integer, Boolean> biFunc = (x, y) -> x > y;
		System.out.println(biFunc.apply(45, 25));

		// Supplier Functional Interface
		Supplier<String> sup = () -> "Not Found!";
		System.out.println(sup.get());

		// UnaryOperator Functional Interface
		// UnaryOperator takes a single argument and returns a single value and both
		// should be of same datatype thats mentioned
		UnaryOperator<String> uni = (x) -> "Hello!" + x;
		System.out.println(uni.apply("Hello"));

		// BinaryOperator Functional Interface
		BinaryOperator<Integer> biOp = (x, y) -> x + y;
		System.out.println(biOp.apply(10, 20));

	}
}
