/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generators;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author Jamie
 */
public class InvoiceEventListener extends PdfPageEventHelper {

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        
        Font defaultFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);


        try {
            PdfPTable footerTable = new PdfPTable(3);
            footerTable.setTotalWidth(document.right(document.leftMargin()));

            footerTable.getDefaultCell().setBorder(Rectangle.TOP);
            footerTable.addCell(new Paragraph("Lionsclub Oegstgeest/Warmond", defaultFont));
            footerTable.completeRow();

            footerTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            footerTable.addCell(new Paragraph("Betaalrekening", defaultFont));
            footerTable.addCell(new Paragraph(": ************", defaultFont));
            footerTable.completeRow();
            footerTable.addCell(new Paragraph("Inschrijvnummer KvK Rijnland", defaultFont));
            footerTable.addCell(new Paragraph(": ************ ", defaultFont));
            footerTable.completeRow();
            footerTable.writeSelectedRows(0, -1, document.leftMargin(), document.bottom(footerTable.getTotalHeight()) - document.bottomMargin() + 15, writer.getDirectContent());

            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_RIGHT, new Phrase(String.format("%d", writer.getPageNumber()), defaultFont),
                    document.right(), document.bottom()-document.bottomMargin()+18, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }    
}
