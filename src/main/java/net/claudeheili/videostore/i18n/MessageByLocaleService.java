package net.claudeheili.videostore.i18n;

import javax.servlet.http.HttpServletRequest;

public interface MessageByLocaleService {

	String getMessage(String id);

	String getMessage(String string, HttpServletRequest request);

}
