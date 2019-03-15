package jxls.util;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author jobjava00
 */
public class ExcelUtil {
	private static int ROW_ACCESS_WINDOW_SIZE = 100;    //flush 단위

	public static void download(HttpServletResponse response, Context context, String fileName, String templateFile)  {
		try (InputStream is = new BufferedInputStream(new ClassPathResource(templateFile).getInputStream())) {
			try (OutputStream os = response.getOutputStream()) {
				String dateTime = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
				fileName = fileName + "_" + dateTime + ".xlsx";

				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));  //한글 제목 encode 필요

				Workbook template = WorkbookFactory.create(is);
				PoiTransformer transformer = PoiTransformer.createSxssfTransformer(template, ROW_ACCESS_WINDOW_SIZE, false);

				AreaBuilder areaBuilder = new XlsCommentAreaBuilder(transformer);
				List<Area> xlsAreaList = areaBuilder.build();

				Area xlsArea = xlsAreaList.get(0);
				xlsArea.applyAt(new CellRef("Result!A1"), context); //Sheet 생성

				SXSSFWorkbook workbook = (SXSSFWorkbook) transformer.getWorkbook();
				workbook.removeSheetAt(0);  //처음 jxls 템플릿 Sheet 삭제
				workbook.write(os);
			}
		} catch (IOException e) {
			throw new RuntimeException("excel download fail :" + e.getMessage());
		}
	}
}
