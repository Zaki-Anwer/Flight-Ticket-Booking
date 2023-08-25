package com.flight.flight_ticket_booking.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class Pdf{

	private static final String QR_CODE_PLACEHOLDER_PATH = "https://appmiral.com/wp-content/uploads/2020/11/code39_0A0W2XFQ.jpg";
	public static void main(String[] args) throws MalformedURLException, IOException {
			        try {
			            Document document = new Document(PageSize.A4);
			            Long time = System.currentTimeMillis();
			            String uniquePdf = "Ticket" + time;
			            String path = "D:\\" + uniquePdf + ".pdf";

			            PdfWriter.getInstance(document, new FileOutputStream(path));
			            document.open();
	                            
	                            
			         // Add SpiceJet logo (Replace "path/to/spicejet_logo.png" with the actual logo path)
			            
			                Image spiceJetLogo = Image.getInstance("https://centraleducation.in/wp-content/uploads/2022/01/download-11.png");
			                spiceJetLogo.setAlignment(Element.ALIGN_CENTER);
			                spiceJetLogo.scaleToFit(100, 50);
			                document.add(spiceJetLogo);
			          
			            // Add a watermark image as the background (Optional)
	                        Image watermarkImage = Image.getInstance("https://cdn.vectorstock.com/i/preview-1x/83/78/symbol-flying-aircraft-vector-28708378.jpg");
			                watermarkImage.setAbsolutePosition(100, 200);
			                watermarkImage.scaleToFit(500, 500);
			                document.add(watermarkImage);

			            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
			            Paragraph title = new Paragraph("Flight E-Ticket", titleFont);
			            title.setAlignment(Element.ALIGN_CENTER);
			            title.setSpacingAfter(20);
			            document.add(title);

			            // Add passenger information section
			            PdfPTable passengerInfoTable = new PdfPTable(2);
			            passengerInfoTable.setWidthPercentage(80);
			            passengerInfoTable.setSpacingBefore(10);
			            passengerInfoTable.setSpacingAfter(10);

			            Font keyFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
			            Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

			            addPassengerInfo(passengerInfoTable, "Name:", "John Doe", keyFont, valueFont);
			            addPassengerInfo(passengerInfoTable, "Age:", "SG1234", keyFont, valueFont);
			            addPassengerInfo(passengerInfoTable, "Gender:", "New York", keyFont, valueFont);
			            addPassengerInfo(passengerInfoTable, "Price:", "London", keyFont, valueFont);
			            addPassengerInfo(passengerInfoTable, "From:", "2023-08-15", keyFont, valueFont);
			            addPassengerInfo(passengerInfoTable, "To:", "14:30", keyFont, valueFont);

			            document.add(passengerInfoTable);

			            // Add QR code image (Replace with actual QR code image)
		            Image qrCodeImage = Image.getInstance(QR_CODE_PLACEHOLDER_PATH);
		            qrCodeImage.setAlignment(Element.ALIGN_CENTER);
		            qrCodeImage.scaleToFit(150, 150);
		            document.add(qrCodeImage);

			            // ...

			            // Add flight details section
			            PdfPTable flightDetailsTable = new PdfPTable(2);
			            flightDetailsTable.setWidthPercentage(80);
			            flightDetailsTable.setSpacingBefore(10);
			            flightDetailsTable.setSpacingAfter(10);

			            addFlightDetails(flightDetailsTable, "Pnr:", "SG1234", keyFont, valueFont);
			            addFlightDetails(flightDetailsTable, "Flight Number:", "New York", keyFont, valueFont);
			            addFlightDetails(flightDetailsTable, "Departure Time:", "London", keyFont, valueFont);
			            addFlightDetails(flightDetailsTable, "Arrival Arrival:", " 12", keyFont, valueFont);
			            addFlightDetails(flightDetailsTable, "Date:", "2023-08-15", keyFont, valueFont);
			            addFlightDetails(flightDetailsTable, "Gate:", "A3", keyFont, valueFont);

			            document.add(flightDetailsTable);

			            // Add baggage information
			            // ...

			            // Add seat information
			            // ...

			            document.close();
			            System.out.println("Flight e-ticket PDF created successfully.");

			        } catch (DocumentException | FileNotFoundException e) {
			            e.printStackTrace();
			        }
			    }

			    private static void addPassengerInfo(PdfPTable table, String key, String value, Font keyFont, Font valueFont) {
			        PdfPCell keyCell = new PdfPCell(new Phrase(key, keyFont));
			        keyCell.setBorder(PdfPCell.NO_BORDER);

			        PdfPCell valueCell = new PdfPCell(new Phrase(value, valueFont));
			        valueCell.setBorder(PdfPCell.NO_BORDER);

			        table.addCell(keyCell);
			        table.addCell(valueCell);
			    }

			    private static void addFlightDetails(PdfPTable table, String key, String value, Font keyFont, Font valueFont) {
			        PdfPCell keyCell = new PdfPCell(new Phrase(key, keyFont));
			        keyCell.setBorder(PdfPCell.NO_BORDER);

			        PdfPCell valueCell = new PdfPCell(new Phrase(value, valueFont));
			        valueCell.setBorder(PdfPCell.NO_BORDER);

			        table.addCell(keyCell);
			        table.addCell(valueCell);
			    }
			}


//	@Bean("restTemplate")
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}