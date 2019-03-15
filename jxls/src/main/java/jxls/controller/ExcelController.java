package jxls.controller;

import jxls.util.ExcelUtil;
import org.jxls.common.Context;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jobjava00
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {
	@RequestMapping("/download")
	public void download(HttpServletResponse response) {

		Context context = new Context();
		context.putVar("list", get());
		context.putVar("dateFormat", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		ExcelUtil excelUtil = new ExcelUtil();
		excelUtil.download(response, context, "테스트", "/excel/test.xlsx");
	}

	private List<Book> get() {
		List<Book> books = new ArrayList<>();
		for (int i = 0; i < 500000; i++) {
			books.add(new Book(i, i + "_test"));
		}
		return books;
	}

	public class Book {
		private int id;
		private String name;
		private OffsetDateTime createDt = OffsetDateTime.now();

		public Book(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public OffsetDateTime getCreateDt() {
			return createDt;
		}
	}
}
