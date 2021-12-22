package com.ddd.utils;

public class Preconditions {

	private Preconditions() {
	}

	public static <T> T requireNonNull(T object) {
		if (object == null) {
			throw new NullPointerException();
		}
		return object;
	}

	public static String requireNonEmpty(String nullableParam) {
		final var param = requireNonNull(nullableParam);
		final var isNotEmpty = !param.trim().isEmpty();
		return checkArgument(param, isNotEmpty, "Argument is empty");
	}

	private static <T> T checkArgument(T argument, boolean condition, String message) {
		if (!condition) {
			throw new IllegalArgumentException(message);
		}
		return argument;
	}

}
