package com.github.jobjava00.locale.message;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @author jobjava00
 */
@RestController
@RequiredArgsConstructor
public class MessageController {
	private final MessageSource messageSource;

	@GetMapping("/welcome")
	public String msg(@RequestHeader(value = "Accept-Language", required = false) Locale locale) {  //locale 선택하지 ㅇ낳으면 기본 로케일 사용
		return messageSource.getMessage("welcome.message", null, locale);
	}
}
