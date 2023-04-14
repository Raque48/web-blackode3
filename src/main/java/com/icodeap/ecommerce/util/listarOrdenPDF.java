package com.icodeap.ecommerce.util;

/*import java.awt.Color;
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
*/

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.icodeap.ecommerce.domain.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component("user/shoppinglist")
public class listarOrdenPDF extends AbstractPdfView{


	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Order> newListOrder = (List<Order>) model.get("orders");
		
		
		/*Fuentes, tamaños y colores para cada seccion*/
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20,Color.BLUE);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD ,12,Color.BLUE);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER ,10,Color.BLACK);
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 30, 20);
		document.open();
		PdfPCell celda = null;
		
		/*Tabla Para El Titulo del PDF*/
		PdfPTable tablaTitulo = new PdfPTable(1);
						
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE ORDENES DE MIS ORDENES", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setPadding(30);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		/*Tabla Para Mostrar Listado de Clientes*/
		PdfPTable tablaOrders = new PdfPTable(5);
		tablaOrders.setWidths(new float[] {1.5f, 2f, 1.5f, 3.5f,1.5f});		
		
		celda = new PdfPCell(new Phrase("No. DE ORDEN", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaOrders.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Nombre de Usuario", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaOrders.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Correo", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaOrders.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Fecha", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaOrders.addCell(celda);
		
		celda = new PdfPCell(new Phrase("Valor", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaOrders.addCell(celda);
		
		/*celda = new PdfPCell(new Phrase("CIUDAD", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);*/		
		
													
		/*Bucle For, mostrar todos los datos de los clientes*/		
		
		for (Order order : newListOrder) {
			celda = new PdfPCell(new Phrase(order.getId().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaOrders.addCell(celda);
			
			celda = new PdfPCell(new Phrase(order.getFirstName(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaOrders.addCell(celda);
			
			celda = new PdfPCell(new Phrase(order.getEmail(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaOrders.addCell(celda);
			
			LocalDateTime fechaCreada = order.getDateCreated(); // obtener fecha de creación
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // crear formateador
		    String fechaCreadaStr = fechaCreada.format(formatter); // convertir fecha a cadena formateada
		    celda = new PdfPCell(new Phrase(fechaCreadaStr, fuenteDataCeldas));
		    celda.setPadding(5);
		    tablaOrders.addCell(celda);

			
			String precioTotal = String.valueOf(order.getTotalOrderPrice());
			celda = new PdfPCell(new Phrase(precioTotal, fuenteDataCeldas));
			celda.setPadding(5);
			tablaOrders.addCell(celda);

			/*celda = new PdfPCell(new Phrase(order.getDateCreated(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaOrders.addCell(celda);
			
			celda = new PdfPCell(new Phrase(order.getTotalOrderPrice(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaOrders.addCell(celda);*/
			
		}
		
		/*
		listadoClientes.forEach(cliente -> {												
			tablaClientes.addCell(cliente.getId().toString());					
			tablaClientes.addCell(cliente.getNombres());
			tablaClientes.addCell(cliente.getApellidos());
			tablaClientes.addCell(cliente.getTelefono());
			tablaClientes.addCell(cliente.getEmail());
			tablaClientes.addCell(cliente.getCiudad().getCiudad());
		});
		*/
		
		/*Anexamos las Tablas al Documento*/
		document.add(tablaTitulo);
		document.add(tablaOrders);
	}

}
