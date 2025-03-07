package practice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class pdf_extract {

	public static void main(String[] args) throws Throwable {

		
		File file =new File("./src/test/resources/atsRESUME.pdf");
		PDDocument doc = PDDocument.load(file);

		int pages =doc.getNumberOfPages();

		System.out.println(pages);

		PDFTextStripper pdfData = new PDFTextStripper();

		String readData = pdfData.getText(doc);

		System.out.println(readData);

		pdfData.setStartPage(1);

		String readData1 = pdfData.getText(doc);

		System.out.println(readData1);
	}

}
