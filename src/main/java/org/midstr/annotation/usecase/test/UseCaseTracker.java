package org.midstr.annotation.usecase.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.midstr.annotation.usecase.UseCase;

public class UseCaseTracker {

	public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
		for (Method m : cl.getMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if (uc != null) {
				System.out.println("Found Use Case:" + uc.id() + " "
						+ uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (int i : useCases) {
			System.out.println("Warning: Missing use case-" + i);
		}
		// @Deprecated
		// @Override
		// @SuppressWarnings

		// @Documented
		// @Inherited
		// @Retention
		// @Target
	}

	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 10, 11, 12, 13);
		trackUseCases(useCases, PasswordUtils.class);
	}

}
