package amazon.utils;

import java.util.function.Supplier;

import static java.lang.System.currentTimeMillis;

public class ElementUtils {

	public static boolean assertWaitEquals(Supplier<String> actual, String expected) {
		String result = "";
		long currentTime = currentTimeMillis();
		long delta;
		do {
			try { result = actual.get();
			} catch (Exception ignore) {}
			delta = currentTimeMillis() - currentTime;
		} while (!result.equals(expected) && delta < 5000);
		return result.equals(expected);
	}
}
