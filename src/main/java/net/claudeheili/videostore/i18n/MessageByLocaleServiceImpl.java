package net.claudeheili.videostore.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageByLocaleServiceImpl implements MessageByLocaleService {

	@Autowired
	MessageSource messageSource;

	@Override
	public String getMessage(String id) {

		Locale locale = LocaleContextHolder.getLocale();

		return messageSource.getMessage(id, null, locale);
	}

	@Override
	public String getMessage(String id, HttpServletRequest request) {

		String locales = request.getHeader("Accept-Language");
		String[] strings = locales.split(",");
		String locale = strings[0];
		locale = locale.replaceAll("-", "_");

		Locale preferedLocale;

		switch (locale) {
		case "en":
		case "en_US":
			preferedLocale = Locale.US;
			break;
		case "fr":	
		case "fr_FR":
			preferedLocale = Locale.FRENCH;
			break;
		default:
			preferedLocale = Locale.ENGLISH;
			break;

		}

		return messageSource.getMessage(id, null, preferedLocale);
	}
}
