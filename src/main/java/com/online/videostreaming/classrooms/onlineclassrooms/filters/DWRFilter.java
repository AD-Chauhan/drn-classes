package com.online.videostreaming.classrooms.onlineclassrooms.filters;

import java.lang.reflect.Method;

import org.directwebremoting.AjaxFilter;
import org.directwebremoting.AjaxFilterChain;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.online.videostreaming.classrooms.onlineclassrooms.utils.SessionAttributeUtils;

public class DWRFilter implements AjaxFilter {

	@Override
	public Object doFilter(Object paramObject, Method paramMethod,
			Object[] paramArrayOfObject, AjaxFilterChain paramAjaxFilterChain)
			throws Exception {
		WebContext context = WebContextFactory.get();
		context.getSession();
		SessionAttributeUtils.bindSession(context.getSession());
		return paramAjaxFilterChain.doFilter(paramObject, paramMethod, paramArrayOfObject);
	}

}
