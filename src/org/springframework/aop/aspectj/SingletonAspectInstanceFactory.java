/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.aspectj;

import org.springframework.core.Ordered;
import org.springframework.util.Assert;

/**
 * Simple implementation of AspectInstanceFactory backed by a singleton object.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 2.0
 */
public class SingletonAspectInstanceFactory implements AspectInstanceFactory {
	
	private final Object aspectInstance;


	/**
	 * Create a new SingletonAspectInstanceFactory for the given aspect instance.
	 * @param aspectInstance the singleton aspect instance
	 */
	public SingletonAspectInstanceFactory(Object aspectInstance) {
		Assert.notNull(aspectInstance, "Aspect instance must not be null");
		this.aspectInstance = aspectInstance;
	}


	public final Object getAspectInstance() {
		return this.aspectInstance;
	}

	public int getOrder() {
		if (this.aspectInstance instanceof Ordered) {
			return ((Ordered) this.aspectInstance).getOrder();
		}
		return Ordered.LOWEST_PRECEDENCE;
	}

}
