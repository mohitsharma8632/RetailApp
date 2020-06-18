package com.crude;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pojo.Account;
import com.pojo.Customer;
import com.pojo.Transaction;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class C {

	
	 public static ByteArrayInputStream Report(Account a) {

	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {
List<Transaction> tlist=TransactionDao.tlist(a.getAccountid());
a=AccountDao.getaccountbyid(a);
System.out.println(a.getAccountid());
System.out.println(a.getCustomerid());
Customer customer=new Customer();
customer.setCustomerid(a.getCustomerid());
 customer=CustomerDao.getcustomerbycustomerid(customer);
 System.out.println(customer.getCustomerid());
	            PdfPTable table = new PdfPTable(5);
	            table.setWidthPercentage(90);
	            table.setWidths(new int[]{3, 3, 3, 2, 2});

	            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

	            PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("Date", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("To Account Number", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("To Account Type", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Amount", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
	            
	            hcell = new PdfPCell(new Phrase("Credit or Debit", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);
int i=1;
	            for (Transaction t : tlist) {

	                PdfPCell cell;

	                cell = new PdfPCell(new Phrase(t.getDate()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                
	                if(t.getTargetaccounttype()!=null) {
	                cell = new PdfPCell(new Phrase(""+t.getTargetaccountid()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(t.getTargetaccounttype()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                }
	                else { 
	                cell = new PdfPCell(new Phrase("self"+t.getType()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase("N.A"));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                }         
	                
	                
	                cell = new PdfPCell(new Phrase(""+t.getAmount()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	                if(t.getType().equals("deposit")) {
	                cell = new PdfPCell(new Phrase("credit"));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);
	                }else {
	                	cell = new PdfPCell(new Phrase("debit"));
		                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table.addCell(cell);	
	                }
	                
	            }

	            PdfWriter.getInstance(document, out);
	            document.open();
	            Paragraph p =new Paragraph("Account no = "+a.getAccountid());
	            document.add(p);
	            p=new Paragraph("customer id = "+a.getCustomerid());
	            document.add(p);

	            p=new Paragraph("customer name = "+customer.getName());
	            document.add(p);
	            p=new Paragraph("current balance = "+a.getBalance());
	            document.add(p);
	            p=new Paragraph("Address ="+customer.getAddress());
	            document.add(p);
	            p=new Paragraph("                                   ");
	            document.add(p);
	            
	            document.add(table);

	            document.close();

	        } catch (DocumentException ex) {
System.out.println(ex);
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }
	}