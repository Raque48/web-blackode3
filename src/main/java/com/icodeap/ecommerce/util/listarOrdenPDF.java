package com.icodeap.ecommerce.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.icodeap.ecommerce.domain.Order;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("user/shoppinglist")
public class listarOrdenPDF extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Order> newListOrder = (List<Order>) model.get("orders");
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20,-20,40,20);
		document.open();
		
		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		
		Font fuenteTitulo = FontFactory.getFont("Helvetica",16,Color.BLUE);
		
		celda = new PdfPCell(new Phrase("Listado General de Compras"));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(133,128,127));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablaOrders = new PdfPTable(3);
		
		newListOrder.forEach(order -> {
			
			tablaOrders.addCell(order.getId().toString());
			tablaOrders.addCell(order.getDateCreated().toString());
			tablaOrders.addCell(order.getTotalOrderPrice().toString());
			
		});
		
		document.add(tablaTitulo);
		document.add(tablaOrders);
	}

}
