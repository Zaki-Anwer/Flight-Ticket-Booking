package com.flight.flight_ticket_booking.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight.flight_ticket_booking.dto.FlightBookingDetails;
import com.flight.flight_ticket_booking.service.FlightBookingService;
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
@WebServlet(value ="/getTicket")
public class TicketController extends HttpServlet {
	
	private static final String QR_CODE_PLACEHOLDER_PATH = "https://appmiral.com/wp-content/uploads/2020/11/code39_0A0W2XFQ.jpg";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FlightBookingService bookingService = new FlightBookingService();
		
        FlightBookingDetails details=bookingService.getTicket(Long.parseLong(req.getParameter("Prn")));
		PrintWriter printWriter=resp.getWriter();
		printWriter.write("<html><boby>");
			     
		 try {
	            Document document = new Document(PageSize.A4);
	            Long time = System.currentTimeMillis();
	            String uniquePdf = "Ticket" + time;
	            String path = "D:\\flight-ticket\\" + uniquePdf + ".pdf";

	            PdfWriter.getInstance(document, new FileOutputStream(path));
	            document.open();
                     
                     
	              // Add Vistra logo (Replace "path/to/spicejet_logo.png" with the actual logo path)
	            if(details.getFlightName().equalsIgnoreCase("vistra")) {
	                Image vistra = Image.getInstance("https://nebula.wsimg.com/2342f18e5520d57f00c5b5e7b2207836?AccessKeyId=62CEBCE7CAF980C350D9&disposition=0&alloworigin=1");
	                vistra.setAlignment(Element.ALIGN_JUSTIFIED);
	                vistra.scaleToFit(100, 50);
	                document.add(vistra);
	          
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

	            addPassengerInfo(passengerInfoTable, "Name:",details.getName(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Age:", details.getAge(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Gender:", details.getGender(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Price:", details.getPrice(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "From:", details.getFlightSource(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "To:", details.getFlightDestination(), keyFont, valueFont);

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

	            addFlightDetails(flightDetailsTable, "Pnr:", details.getPnr(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Flight Number:",details.getFlightNumber(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Departure Time:", details.getDepartureTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Arrival Arrival:", details.getArrivalTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Date:",  LocalDate.now().plusDays(2), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Gate:","A3", keyFont, valueFont);

	            document.add(flightDetailsTable);

	            // Add baggage information
	            // ...

	            // Add seat information
	            // ...

	            document.close();
	            System.out.println("Flight e-ticket PDF created successfully.");

	        }
	            
	            // Add Indigo logo (Replace "path/to/spicejet_logo.png" with the actual logo path)
	            if(details.getFlightName().equalsIgnoreCase("Indigo")) {
	                Image spiceJetLogo = Image.getInstance("https://travelbizmonitor.com/wp-content/uploads/2022/02/download.png");
	                spiceJetLogo.setAlignment(Element.ALIGN_JUSTIFIED);
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

	            addPassengerInfo(passengerInfoTable, "Name:",details.getName(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Age:", details.getAge(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Gender:", details.getGender(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Price:", details.getPrice(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "From:", details.getFlightSource(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "To:", details.getFlightDestination(), keyFont, valueFont);

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

	            addFlightDetails(flightDetailsTable, "Pnr:", details.getPnr(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Flight Number:",details.getFlightNumber(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Departure Time:", details.getDepartureTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Arrival Arrival:", details.getArrivalTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Date:", LocalDate.now().plusDays(1), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Gate:", "A3", keyFont, valueFont);

	            document.add(flightDetailsTable);

	            // Add baggage information
	            // ...

	            // Add seat information
	            // ...

	            document.close();
	            System.out.println("Flight e-ticket PDF created successfully.");

	        }
	            
	            // Add Air Aysha logo (Replace "path/to/spicejet_logo.png" with the actual logo path)
	            if(details.getFlightName().equalsIgnoreCase("Air Aysha")) {
	                Image spiceJetLogo = Image.getInstance("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/AirAsia_New_Logo.svg/2048px-AirAsia_New_Logo.svg.png");
	                spiceJetLogo.setAlignment(Element.ALIGN_JUSTIFIED);
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

	            addPassengerInfo(passengerInfoTable, "Name:",details.getName(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Age:", details.getAge(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Gender:", details.getGender(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Price:", details.getPrice(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "From:", details.getFlightSource(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "To:", details.getFlightDestination(), keyFont, valueFont);

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

	            addFlightDetails(flightDetailsTable, "Pnr:", details.getPnr(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Flight Number:",details.getFlightNumber(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Departure Time:", details.getDepartureTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Arrival Arrival:", details.getArrivalTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Date:", LocalDate.now().plusDays(1), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Gate:", "A3", keyFont, valueFont);

	            document.add(flightDetailsTable);

	            // Add baggage information
	            // ...

	            // Add seat information
	            // ...

	            document.close();
	            System.out.println("Flight e-ticket PDF created successfully.");

	        }
	            
	            // Add Akasha Air logo (Replace "path/to/spicejet_logo.png" with the actual logo path)
	            if(details.getFlightName().equalsIgnoreCase("Akasha Air")) {
	                Image spiceJetLogo = Image.getInstance("https://www.india.com/wp-content/uploads/2022/07/akasa-air.png");
	                spiceJetLogo.setAlignment(Element.ALIGN_JUSTIFIED);
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

	            addPassengerInfo(passengerInfoTable, "Name:",details.getName(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Age:", details.getAge(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Gender:", details.getGender(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Price:", details.getPrice(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "From:", details.getFlightSource(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "To:", details.getFlightDestination(), keyFont, valueFont);

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

	            addFlightDetails(flightDetailsTable, "Pnr:", details.getPnr(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Flight Number:",details.getFlightNumber(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Departure Time:", details.getDepartureTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Arrival Arrival:", details.getArrivalTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Date:",LocalDate.now().plusDays(1), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Gate:", "A3", keyFont, valueFont);

	            document.add(flightDetailsTable);

	            // Add baggage information
	            // ...

	            // Add seat information
	            // ...

	            document.close();
	            System.out.println("Flight e-ticket PDF created successfully.");

	        }
	            
	            // Add 'SpaceJet' logo (Replace "path/to/spicejet_logo.png" with the actual logo path)
	            if(details.getFlightName().equalsIgnoreCase("SpaceJet")) {
	                Image spiceJetLogo = Image.getInstance("https://logos-world.net/wp-content/uploads/2023/01/SpiceJet-Logo.png");
	                spiceJetLogo.setAlignment(Element.ALIGN_JUSTIFIED);
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

	            addPassengerInfo(passengerInfoTable, "Name:",details.getName(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Age:", details.getAge(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Gender:", details.getGender(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Price:", details.getPrice(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "From:", details.getFlightSource(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "To:", details.getFlightDestination(), keyFont, valueFont);

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

	            addFlightDetails(flightDetailsTable, "Pnr:", details.getPnr(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Flight Number:",details.getFlightNumber(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Departure Time:", details.getDepartureTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Arrival Arrival:", details.getArrivalTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Date:", LocalDate.now().plusDays(1), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Gate:", "A3", keyFont, valueFont);

	            document.add(flightDetailsTable);

	            // Add baggage information
	            // ...

	            // Add seat information
	            // ...

	            document.close();
	            System.out.println("Flight e-ticket PDF created successfully.");

	        }
	            
	            // Add Air India logo (Replace "path/to/spicejet_logo.png" with the actual logo path)
	            if(details.getFlightName().equalsIgnoreCase("Air India")) {
	                Image spiceJetLogo = Image.getInstance("https://assets.stickpng.com/images/587b511a44060909aa603a81.png");
	                spiceJetLogo.setAlignment(Element.ALIGN_JUSTIFIED);
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

	            addPassengerInfo(passengerInfoTable, "Name:",details.getName(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Age:", details.getAge(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Gender:", details.getGender(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "Price:", details.getPrice(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "From:", details.getFlightSource(), keyFont, valueFont);
	            addPassengerInfo(passengerInfoTable, "To:", details.getFlightDestination(), keyFont, valueFont);

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

	            addFlightDetails(flightDetailsTable, "Pnr:", details.getPnr(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Flight Number:",details.getFlightNumber(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Departure Time:", details.getDepartureTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Arrival Arrival:", details.getArrivalTime(), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Date:", LocalDate.now().plusDays(1), keyFont, valueFont);
	            addFlightDetails(flightDetailsTable, "Gate:", "A3", keyFont, valueFont);

	            document.add(flightDetailsTable);

	            // Add baggage information
	            // ...

	            // Add seat information
	            // ...

	            document.close();
	            System.out.println("Flight e-ticket PDF created successfully.");

	        }

		 }catch (DocumentException | FileNotFoundException e) {
	            e.printStackTrace();
	        }
		
		    printWriter.write("<h style='color:green'><h1>Your ticket successfully downloaded</h1></h>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("thank-you-page.jsp");
			dispatcher.include(req, resp);
			printWriter.write("</html></boby>");
	    }

	

	private void addFlightDetails(PdfPTable flightDetailsTable, String key, LocalDate plusDays, Font keyFont,
            Font valueFont) {

        PdfPCell keyCell = new PdfPCell(new Phrase(key, keyFont));
        keyCell.setBorder(PdfPCell.NO_BORDER);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = plusDays.format(dateFormatter);
        PdfPCell valueCell = new PdfPCell(new Phrase(formattedDate, valueFont));
        valueCell.setBorder(PdfPCell.NO_BORDER);
;
        flightDetailsTable.addCell(keyCell);
        flightDetailsTable.addCell(valueCell);
    }




	private void addFlightDetails(PdfPTable flightDetailsTable, String key, Time departureTime, Font keyFont, Font valueFont) {
	    PdfPCell keyCell = new PdfPCell(new Phrase(key, keyFont));
	    keyCell.setBorder(PdfPCell.NO_BORDER);

	    SimpleDateFormat timeFormat = new SimpleDateFormat("dd:mm");
	    String formattedTime = timeFormat.format(departureTime);

	    PdfPCell valueCell = new PdfPCell(new Phrase(formattedTime, valueFont));
	    valueCell.setBorder(PdfPCell.NO_BORDER);

	    flightDetailsTable.addCell(keyCell);
	    flightDetailsTable.addCell(valueCell);
	}


	private void addFlightDetails(PdfPTable flightDetailsTable, String key, long pnr, Font keyFont, Font valueFont) {
	    PdfPCell keyCell = new PdfPCell(new Phrase(key, keyFont));
	    keyCell.setBorder(PdfPCell.NO_BORDER);

	    PdfPCell valueCell = new PdfPCell(new Phrase(String.valueOf(pnr), valueFont));
	    valueCell.setBorder(PdfPCell.NO_BORDER);

	    flightDetailsTable.addCell(keyCell);
	    flightDetailsTable.addCell(valueCell);
	}

		
	

	private void addPassengerInfo(PdfPTable passengerInfoTable, String key, double price, Font keyFont, Font valueFont) {
	    PdfPCell keyCell = new PdfPCell(new Phrase(key, keyFont));
	    keyCell.setBorder(PdfPCell.NO_BORDER);

	    PdfPCell valueCell = new PdfPCell(new Phrase(String.valueOf(price), valueFont));
	    valueCell.setBorder(PdfPCell.NO_BORDER);

	    passengerInfoTable.addCell(keyCell);
	    passengerInfoTable.addCell(valueCell);
	}

	private static void addPassengerInfo(PdfPTable table, String key, String string, Font keyFont, Font valueFont) {
	        PdfPCell keyCell = new PdfPCell(new Phrase(key, keyFont));
	        keyCell.setBorder(PdfPCell.NO_BORDER);

	        PdfPCell valueCell = new PdfPCell(new Phrase(string, valueFont));
	        valueCell.setBorder(PdfPCell.NO_BORDER);

	        table.addCell(keyCell);
	        table.addCell(valueCell);
	    }
	private void addPassengerInfo(PdfPTable passengerInfoTable, String key, int age, Font keyFont, Font valueFont) {
	    PdfPCell keyCell = new PdfPCell(new Phrase(key, keyFont));
	    keyCell.setBorder(PdfPCell.NO_BORDER);

	    PdfPCell valueCell = new PdfPCell(new Phrase(Integer.toString(age), valueFont));
	    valueCell.setBorder(PdfPCell.NO_BORDER);

	    passengerInfoTable.addCell(keyCell);
	    passengerInfoTable.addCell(valueCell);
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
