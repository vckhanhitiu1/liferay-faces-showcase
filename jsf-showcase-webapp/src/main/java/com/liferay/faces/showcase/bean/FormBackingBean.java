/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.showcase.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 * @author  Neil Griffin
 */
@RequestScoped
@ManagedBean
public class FormBackingBean {

	public void submit() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = null;

		if (facesContext.getPartialViewContext().isAjaxRequest()) {
			facesMessage = new FacesMessage("The form was submitted via Ajax and re-rendered with updates to the DOM.");
		}
		else {
			facesMessage = new FacesMessage(
					"The form was submitted as a full page postback and the entire page was re-rendered.");
		}

		facesContext.addMessage(null, facesMessage);
	}
}
