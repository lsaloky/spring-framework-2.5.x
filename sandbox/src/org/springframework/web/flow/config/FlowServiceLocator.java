/*
 * Copyright 2002-2004 the original author or authors.
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
package org.springframework.web.flow.config;

import org.springframework.web.flow.Action;
import org.springframework.web.flow.Flow;
import org.springframework.web.flow.FlowAttributesMapper;

/**
 * Service locator interface used by flows to retrieve needed artifacts.
 * 
 * @author Keith Donald
 * @author Colin Sampaleanu
 */
public interface FlowServiceLocator {

	/**
	 * @param actionId
	 * @return
	 * @throws NoSuchActionException
	 */
	public Action getAction(String actionId) throws FlowServiceLookupException;

	/**
	 * @param actionImplementationClass
	 * @return
	 * @throws FlowServiceLookupException
	 */
	public Action getAction(Class actionImplementationClass) throws FlowServiceLookupException;

	/**
	 * @param flowDefinitionId
	 * @return
	 * @throws FlowServiceLookupException
	 */
	public Flow getFlow(String flowDefinitionId) throws FlowServiceLookupException;

	/**
	 * @param flowDefinitionId
	 * @param requiredFlowBuilderImplementationClass
	 * @return
	 * @throws FlowServiceLookupException
	 */
	public Flow getFlow(String flowDefinitionId, Class requiredFlowBuilderImplementationClass)
			throws FlowServiceLookupException;

	/**
	 * @param flowDefinitionImplementationClass
	 * @return
	 * @throws FlowServiceLookupException
	 */
	public Flow getFlow(Class flowDefinitionImplementationClass) throws FlowServiceLookupException;

	/**
	 * @param flowAttributesMapperId
	 * @return
	 * @throws FlowServiceLookupException
	 */
	public FlowAttributesMapper getFlowAttributesMapper(String flowAttributesMapperId)
			throws FlowServiceLookupException;

	/**
	 * @param subFlowAttributesMapperId
	 * @return
	 * @throws FlowServiceLookupException
	 */
	public FlowAttributesMapper getFlowAttributesMapper(Class flowAttributesMapperImplementationClass)
			throws FlowServiceLookupException;

}