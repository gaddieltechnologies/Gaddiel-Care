package org.gaddiel.controller;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.gaddiel.form.CustomLookupsForm;
import org.gaddiel.form.Lookups;
import org.gaddiel.form.MainForm;
import org.gaddiel.form.SystemLookupsForm;
import org.gaddiel.report.Exporter;
import org.gaddiel.report.ReportLayout;
import org.gaddiel.report.Writer;
import org.gaddiel.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.ImageBanner;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Page;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;

@Controller
public class ReportController {
	
	private static final Logger logger = Logger.getLogger(ReportController.class);
	
	@Autowired
	private MemberService memberservice;

	@RequestMapping(value="/customLookups/downloadxls/{categoryval}" , method=RequestMethod.GET)
	  public void customdownloadXLS(HttpServletResponse response,  @ModelAttribute(value = "mainForm1")CustomLookupsForm  mainForm1
	    		,	@PathVariable("categoryval") String  CategoryType)
		        throws ColumnBuilderException, ClassNotFoundException, JRException, Exception
		    {
		        logger.debug("Downloading Excel report");
		        System.out.println((new StringBuilder()).append(" mainForm1--------->").append(CategoryType).toString());
		        List lookups = new ArrayList();
		        mainForm1.setCustomcategoryType(CategoryType);
		        mainForm1.setDispatch("report");
		        System.out.println((new StringBuilder()).append(" <------------before fetching value---->").append(mainForm1.getCustomcategoryType()).toString());
		        mainForm1.setCustomcategoryType(CategoryType);
		        System.out.println((new StringBuilder()).append(" <------------before fetching value---->").append(mainForm1.getCustomcategoryType()).toString());
		        Lookups LookupValues = memberservice.getviewList(mainForm1);
		        System.out.println(" <------------after fetching value---->");
		        lookups = LookupValues.getMemberList();
		        System.out.println(" <------------before pass value---->");
		        net.sf.jasperreports.engine.JRDataSource ds = new JRBeanCollectionDataSource(lookups);
		        System.out.println((new StringBuilder()).append(" <------------after list value---->").append(lookups.size()).toString());
		        System.out.println(" <------------after pass value---->");
		        ReportLayout layout = new ReportLayout();
		        String header[] = {
		            "SNO,sNo", "Code,categoryCode", "Value,categoryName", "Description,description"
		        };
		        FastReportBuilder drb = new FastReportBuilder();
		        for(int i = 0; i < header.length; i++)
		        {
		            String val[] = header[i].split(",");
		            drb.addColumn(val[0], val[1], String.class.getName(), 50);
		        }

		        drb.setPrintColumnNames(true).setIgnorePagination(true).setMargins(0, 0, 0, 0).setTitle("CustomLookups").addImageBanner("C:\\searchbutton3.png", Integer.valueOf(600), Integer.valueOf(100), (byte)2).setSubtitle((new StringBuilder()).append("This report was generated at ").append(new Date()).toString()).setUseFullPageWidth(true);
		        drb.setReportName("lookups");
		        ar.com.fdvs.dj.domain.DynamicReport dr = drb.build();
		        System.out.println(" <------------after report layout---->");
		        HashMap params = new HashMap();
		        net.sf.jasperreports.engine.JasperReport jr = DynamicJasperHelper.generateJasperReport(dr, new ClassicLayoutManager(), params);
		        net.sf.jasperreports.engine.JasperPrint jp = JasperFillManager.fillReport(jr, params, ds);
		        System.out.println(" <------------after filllayout layout---->");
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        Exporter exporter = new Exporter();
		        exporter.exportxls(jp, baos);
		        System.out.println(" <------------after export layout---->");
		        String fileName = "LookupsReport.xls";
		        response.setHeader("Content-Disposition", (new StringBuilder()).append("attachment; filename=\"").append(fileName).toString());
		        response.setContentType("application/vnd.ms-excel");
		        response.setContentLength(baos.size());
		        Writer.write(response, baos);
		    }
	@RequestMapping(value="/customLookups/downloadpdf/{categoryval}" , method=RequestMethod.GET)
		    public void customdownloadPDF(HttpServletResponse response,  @ModelAttribute(value = "mainForm1")CustomLookupsForm  mainForm1
		    		,	@PathVariable("categoryval") String  CategoryType )
		        throws ColumnBuilderException, ClassNotFoundException, JRException, Exception
		    {
		        logger.debug("Downloading Pdf report");
		        System.out.println((new StringBuilder()).append(" mainForm--------->").append(CategoryType).toString());
		        List lookups = new ArrayList();
		        mainForm1.setCustomcategoryType(CategoryType);
		        mainForm1.setDispatch("report");
		        System.out.println((new StringBuilder()).append(" <------------before fetching value---->").append(mainForm1.getCustomcategoryType()).toString());
		        Lookups LookupValues = memberservice.getviewList(mainForm1);
		        System.out.println(" <------------after fetching value---->");
		        lookups = LookupValues.getMemberList();
		        System.out.println(" <------------before pass value---->");
		        net.sf.jasperreports.engine.JRDataSource ds = new JRBeanCollectionDataSource(lookups);
		        System.out.println(" <------------after pass value---->");
		        System.out.println(" <------------before report layout---->");
		        ReportLayout layout = new ReportLayout();
		        String header[] = {
		            "SNO,sNo", "Code,categoryCode", "Value,categoryName", "Description,description"
		        };
		        FastReportBuilder drb = new FastReportBuilder();
		        for(int i = 0; i < header.length; i++)
		        {
		            String val[] = header[i].split(",");
		            drb.addColumn(val[0], val[1], String.class.getName(), 50);
		        }

		        drb.setPrintColumnNames(true).setIgnorePagination(true).setMargins(0, 0, 0, 0).setTitle("CUSTOMLOOKUPS").addImageBanner("C:\\searchbutton3.png", Integer.valueOf(600), Integer.valueOf(100), (byte)2).setSubtitle((new StringBuilder()).append("This report was generated at ").append(new Date()).toString()).setUseFullPageWidth(true);
		        drb.setReportName("lookups");
		        ar.com.fdvs.dj.domain.DynamicReport dr = drb.build();
		        System.out.println(" <------------after report layout---->");
		        HashMap params = new HashMap();
		        net.sf.jasperreports.engine.JasperReport jr = DynamicJasperHelper.generateJasperReport(dr, new ClassicLayoutManager(), params);
		        net.sf.jasperreports.engine.JasperPrint jp = JasperFillManager.fillReport(jr, params, ds);
		        System.out.println(" <------------after filllayout layout---->");
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        Exporter exporter = new Exporter();
		        exporter.exportpdf(jp, baos);
		        System.out.println(" <------------after export layout---->");
		        String fileName = "LookupsReport.pdf";
		        response.setHeader("Content-Disposition", (new StringBuilder()).append("attachment; filename=\"").append(fileName).toString());
		        response.setContentType("application/pdf");
		        response.setContentLength(baos.size());
		        Writer.write(response, baos);
		    }
	
		    private static Style getHeaderStyle(){
		    	Style headerStyle = new Style();
		    	headerStyle.setFont(Font.ARIAL_MEDIUM_BOLD);
		    	headerStyle.setBorder(Border.THIN);
		    	headerStyle.setBorderColor(Color.WHITE);
		    	headerStyle.setHorizontalAlign(HorizontalAlign.LEFT);
		    	headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
		    	headerStyle.setBackgroundColor(Color.lightGray);
		    	headerStyle.setTextColor(Color.WHITE);
		    	headerStyle.setTransparency(Transparency.OPAQUE);
		    	return headerStyle;
		    	}
		    private static Style getHeaderStyle1(){
		    	Style headerStyle1 = new Style();
		    	headerStyle1.setFont(Font.VERDANA_SMALL);
		    	headerStyle1.setBorder(Border.THIN);
		    	headerStyle1.setBorderColor(Color.lightGray);
		    	headerStyle1.setHorizontalAlign(HorizontalAlign.LEFT);
		    	headerStyle1.setVerticalAlign(VerticalAlign.MIDDLE);
		    	headerStyle1.setTextColor(Color.BLACK);
		    	headerStyle1.setTransparency(Transparency.OPAQUE);
		    	return headerStyle1;
		    	}
	
	
	@RequestMapping(value="/systemLookups/downloadxls/{categoryval}" , method=RequestMethod.GET)
	public void downloadXLS(HttpServletResponse response, @ModelAttribute(value = "mainForm")MainForm  mainForm
,	@PathVariable("categoryval") String  CategoryType 
) throws ColumnBuilderException, ClassNotFoundException, JRException, Exception {

		logger.debug("Downloading Excel report");

		System.out.println(" mainForm1--------->"+CategoryType);
		List<SystemLookupsForm> lookups = new ArrayList<SystemLookupsForm>();
		mainForm.setCategotyType(CategoryType);
		mainForm.setDispatch("report");
		System.out.println(" <------------before fetching value---->"+mainForm.getCategotyType());



mainForm.setCategotyType(CategoryType);
System.out.println(" <------------before fetching value---->"+mainForm.getCategotyType());

		SystemLookupsForm systemLookupValues=memberservice.getSystemviewList(mainForm);	
		System.out.println(" <------------after fetching value---->");
		lookups=systemLookupValues.getMemberList();
		System.out.println(" <------------before pass value---->");
		JRDataSource ds = new JRBeanCollectionDataSource(lookups);	
		//JRDataSource ds = datasource.getDataSource();
		System.out.println(" <------------after pass value---->");
		// Create our report layout
		// We delegate the reporting layout to a custom ReportLayout instance
		// The ReportLayout is a wrapper class I made. Feel free to remove or modify it
		
		Style oddRowStyle = new Style();
		oddRowStyle.setBorder(Border.NO_BORDER);
		Color veryLightblue = new Color(198,216,241);
		oddRowStyle.setBackgroundColor(veryLightblue);oddRowStyle.setTransparency(Transparency.OPAQUE);
	
		ReportLayout layout = new ReportLayout();
		String[] header={"SNO,sNo", "Code,categoryCode","Value,categoryType", "Description,categoryType"};
		int[] sizeleng={10,20,30,30};
		FastReportBuilder drb = new FastReportBuilder();
		for(int i=0; i<header.length; i++)
		{
		String val[]=header[i].split(",");
		drb.addColumn(val[0], val[1],  String.class.getName(), sizeleng[i],getHeaderStyle1(), getHeaderStyle());
		
		}
		Style atStyle = new StyleBuilder(true).setFont(Font.COMIC_SANS_SMALL).setTextColor(Color.red).build();
		Style atStyle2 = new StyleBuilder(true).setFont(new Font(9, Font._FONT_TIMES_NEW_ROMAN, false, true, false)).setTextColor(Color.BLUE).build();
	  //  drb.addColumn("Description", "categoryType", String.class.getName(), 50);
		//drb.addColumn("Code", "categoryCode", String.class.getName(), 50);
		drb.setPrintColumnNames(true)
	        
         // Disables pagination
        .setIgnorePagination(true)
        
        // Experiment with this numbers to see the effect
        .setMargins(0, 0, 0, 0) 
      //  .addImageBanner("C:\\searchbutton3.png",600,50, ImageBanner.ALIGN_CENTER)
        .addFirstPageImageBanner("C:\\searchbutton3.jpg", 600, 50, ImageBanner.ALIGN_CENTER)
        // Set the title shown inside the Excel file
         // .setTitle("SYSTEMLOOKUPS") 
		
        .setPrintBackgroundOnOddRows(true)
        .setOddRowBackgroundStyle(oddRowStyle)
        	
        .addAutoText(AutoText.AUTOTEXT_CREATED_ON,
						AutoText.POSITION_FOOTER, 
						AutoText.ALIGMENT_CENTER,
						AutoText.PATTERN_DATE_DATE_TIME, 200, 50)
        // Set the subtitle shown inside the Excel file
       // .setSubtitle("This report was generated at " + new Date()) 
       
		// Set to true if you want to constrain your report within the page boundaries
		// For longer reports, set it to false
         
        .setUseFullPageWidth(true);
		drb.addAutoText("SYSTEMLOOKUPS", AutoText.POSITION_HEADER, AutoText.ALIGMENT_CENTER,100,atStyle2);
		drb.addAutoText("Copyright © 2012 Gaddiel Technologies", AutoText.POSITION_FOOTER, AutoText.ALIGMENT_CENTER,300,atStyle2);
		drb.addAutoText("This is computer generated report and doesn't need a signature", AutoText.POSITION_FOOTER, AutoText.ALIGMENT_CENTER,500,atStyle);
				  	
		  
		// Set the name of the file
        drb.setReportName("lookups");
        
        // Build the report layout
        // Note this just the layout. It doesn't have any data yet!
        DynamicReport dr = drb.build();
        System.out.println(" <------------after report layout---->");

		// params is used for passing extra parameters like when passing
		// a custom datasource, such as Hibernate datasource
		// In this application we won't utilize this parameter
		HashMap params = new HashMap(); 
		
		// Compile our report layout
		JasperReport jr = DynamicJasperHelper.generateJasperReport(dr,
				new ClassicLayoutManager(), params);

		// Creates the JasperPrint object
		// It needs a JasperReport layout and a datasource
		JasperPrint jp = JasperFillManager.fillReport(jr, params, ds);
		System.out.println(" <------------after filllayout layout---->");
		// Create our output byte stream
		// This is the stream where the data will be written
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// Export to output stream
		// The data will be exported to the ByteArrayOutputStream baos
		// We delegate the exporting  to a custom Exporter instance
		// The Exporter is a wrapper class I made. Feel free to remove or modify it
		Exporter exporter = new Exporter();
		exporter.exportxls(jp, baos);
		//exporter.exportpdf(jp, baos);
		System.out.println(" <------------after export layout---->");
		// Set our response properties
		// Here you can declare a custom filename
		String fileName = "LookupsReport.xls";
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName);
		// Make sure to set the correct content type
		// Each format has its own content type
		response.setContentType("application/vnd.ms-excel");
		//response.setContentType("application/pdf");
		response.setContentLength(baos.size());

		// Write to reponse stream
		Writer.write(response, baos);
		
	}
	@RequestMapping(value="/systemLookups/downloadpdf/{categoryval}" , method=RequestMethod.GET)
	public void downloadPDF(HttpServletResponse response, @ModelAttribute(value = "mainForm")MainForm  mainForm
			//,	@PathVariable("mainForm") MainForm  mainForm
			,	@PathVariable("categoryval") String  CategoryType , Style headerStyle
			) throws ColumnBuilderException, ClassNotFoundException, JRException, Exception {

		logger.debug("Downloading Excel report");
		
		
		System.out.println(" mainForm--------->"+CategoryType);
		List<SystemLookupsForm> lookups = new ArrayList<SystemLookupsForm>();
		mainForm.setCategotyType(CategoryType);
		mainForm.setDispatch("report");
		System.out.println(" <------------before fetching value---->"+mainForm.getCategotyType());
		SystemLookupsForm systemLookupValues=memberservice.getSystemviewList(mainForm);	
		System.out.println(" <------------after fetching value---->");
		lookups=systemLookupValues.getMemberList();
		System.out.println(" <------------before pass value---->");
		JRDataSource ds = new JRBeanCollectionDataSource(lookups);	
		//JRDataSource ds = datasource.getDataSource();
		System.out.println(" <------------after pass value---->");
		
		System.out.println(" <------------before report layout---->");
		Style oddRowStyle = new Style();
		oddRowStyle.setBorder(Border.NO_BORDER);
		Color veryLightblue = new Color(198,216,241);
		oddRowStyle.setBackgroundColor(veryLightblue);oddRowStyle.setTransparency(Transparency.OPAQUE);
	
		
		ReportLayout layout = new ReportLayout();
		String[] header={"SNO,sNo","Code,categoryCode","Value,categoryType", "Description,categoryType"};
		int[] sizeleng={10,20,30,30};
		FastReportBuilder drb = new FastReportBuilder();
		for(int i=0; i<header.length; i++)
		{
		String val[]=header[i].split(",");
		drb.addColumn(val[0], val[1],  String.class.getName(),sizeleng[i],getHeaderStyle1(), getHeaderStyle());
	
		}
		 Style atStyle = new StyleBuilder(true).setFont(Font.COMIC_SANS_SMALL).setTextColor(Color.red).build();
		Style atStyle2 = new StyleBuilder(true).setFont(new Font(12, Font._FONT_TIMES_NEW_ROMAN, false, true, false)).setTextColor(Color.BLUE).build();
		 Style atStyle3 = new StyleBuilder(true).setFont(Font.COMIC_SANS_SMALL).setTextColor(Color.black).build();
		//  drb.addColumn("Description", "categoryType", String.class.getName(), 50);
		//drb.addColumn("Code", "categoryCode", String.class.getName(), 50);
		drb.setPrintColumnNames(true)
		
         // Disables pagination
        .setIgnorePagination(false)
        
        // Experiment with this numbers to see the effect
        .setMargins(0, 0, 0, 0) 
        .addImageBanner("C:\\searchbutton3.jpg",600,50, ImageBanner.ALIGN_CENTER)
       //  .addFirstPageImageBanner("C:\\searchbutton3.jpg", 600, 50, ImageBanner.ALIGN_CENTER)
        // Set the title shown inside the Excel file
       
       // .setTitle("SYSTEMLOOKUPS") 
		
		.addAutoText(AutoText.AUTOTEXT_CREATED_ON,
						AutoText.POSITION_FOOTER, 
						AutoText.ALIGMENT_CENTER,
						AutoText.PATTERN_DATE_DATE_TIME, 200, 50)
		
		//.addAutoText("page", AutoText.POSITION_HEADER, AutoText.ALIGMENT_RIGHT)
	//	.addAutoText("PageNo", AutoText.POSITION_HEADER, AutoText.ALIGMENT_RIGHT, 100, atStyle3)
						
		
		
							

        .setPrintBackgroundOnOddRows(true)
        .setOddRowBackgroundStyle(oddRowStyle)
        .setPageSizeAndOrientation(Page.Page_A4_Portrait())
   
        // .addFirstPageImageBanner("path/logo_strip.jpg", 800, 50, ImageBanner.ALIGN_LEFT)
        // Set the subtitle shown inside the Excel file
        //.setSubtitle("This report was generated at " + new Date()) 
        
		// Set to true if you want to constrain your report within the page boundaries
		// For longer reports, set it to false
         
        .setUseFullPageWidth(true);
		drb.addAutoText("SYSTEMLOOKUPS", AutoText.POSITION_HEADER, AutoText.ALIGMENT_CENTER,100,atStyle2);
		drb.addAutoText("Copyright © 2012 Gaddiel Technologies", AutoText.POSITION_FOOTER, AutoText.ALIGMENT_CENTER,300,atStyle2);
		drb.addAutoText("This is computer generated report and doesn't need a signature", AutoText.POSITION_FOOTER, AutoText.ALIGMENT_CENTER,500,atStyle);
		drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y,AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_LEFT);	
	
		// Set the name of the file
        drb.setReportName("lookups");
        
        // Build the report layout
        // Note this just the layout. It doesn't have any data yet!
        DynamicReport dr = drb.build();
        System.out.println(" <------------after report layout---->");

		// params is used for passing extra parameters like when passing
		// a custom datasource, such as Hibernate datasource
		// In this application we won't utilize this parameter
		HashMap params = new HashMap(); 
		params.put("footer","<my footer message>");
		// Compile our report layout
		JasperReport jr = DynamicJasperHelper.generateJasperReport(dr,
				new ClassicLayoutManager(), params);

		// Creates the JasperPrint object
		// It needs a JasperReport layout and a datasource
		JasperPrint jp = JasperFillManager.fillReport(jr, params, ds);
		System.out.println(" <------------after filllayout layout---->");
		// Create our output byte stream
		// This is the stream where the data will be written
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// Export to output stream
		// The data will be exported to the ByteArrayOutputStream baos
		// We delegate the exporting  to a custom Exporter instance
		// The Exporter is a wrapper class I made. Feel free to remove or modify it
		Exporter exporter = new Exporter();
		exporter.exportpdf(jp, baos);
		
		System.out.println(" <------------after export layout---->");
		// Set our response properties
		// Here you can declare a custom filename
		String fileName = "LookupsReport.pdf";
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName);
		// Make sure to set the correct content type
		// Each format has its own content type
		
		response.setContentType("application/pdf");
		response.setContentLength(baos.size());

		// Write to reponse stream
		Writer.write(response, baos);
		
	}
}
