<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.stimulsoft.web.enums.StiWebViewMode"%>
<%@page import="com.stimulsoft.report.dictionary.databases.StiJsonDatabase"%>
<%@page import="com.stimulsoft.report.dictionary.databases.StiXmlDatabase"%>
<%@page import="com.stimulsoft.report.dictionary.databases.StiSqlDatabase"%>
<%@page import="com.stimulsoft.report.dictionary.databases.*"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URL"%>
<%@page import="com.stimulsoft.webdesigner.enums.StiWebDesignerTheme"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.stimulsoft.web.classes.StiRequestParams"%>
<%@page import="com.stimulsoft.webdesigner.StiWebDesigerHandler"%>
<%@page import="com.stimulsoft.webdesigner.StiWebDesignerOptions"%>
<%@page import="java.io.File"%>
<%@page import="java.lang.*"%>
<%@page import="com.stimulsoft.report.utils.data.StiDataColumnsUtil"%>
<%@page import="com.stimulsoft.report.dictionary.StiDataColumnsCollection"%>
<%@page import="com.stimulsoft.report.dictionary.StiDataColumn"%>
<%@page import="com.stimulsoft.report.utils.data.StiSqlField"%>
<%@page import="com.stimulsoft.report.dictionary.dataSources.StiDataTableSource"%>
<%@page import="com.stimulsoft.report.utils.data.StiXmlTable"%>
<%@page import="com.stimulsoft.report.utils.data.*"%>
<%@page import="com.stimulsoft.report.StiSerializeManager"%>
<%@page import="com.stimulsoft.report.StiReport"%>
<%@page import="com.stimulsoft.webviewer.enums.StiWebViewerTheme"%>
<%@page import="com.stimulsoft.webviewer.enums.*"%>
<%@page import="com.stimulsoft.webviewer.StiWebViewerOptions"%>
<%@page import="com.stimulsoft.report.utils.data.StiXmlTableFieldsRequest"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@page import="com.stimulsoft.base.drawing.StiColorEnum"%>
<%@taglib uri="http://stimulsoft.com/webdesigner"
	prefix="stiwebdesigner"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Stimulsoft Webdesigner for Java</title>
<style type="text/css">
</style>
</head>
<body>
	<%
	/*response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
	response.setHeader("Pragma","no-cache"); //HTTP 1.0
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
	//response.reset();
	/*HttpSession httpsession = request.getSession();
	httpsession.getCreationTime();
    RequestDispatcher reqDisp =  request.getRequestDispatcher("REGISTRATION_PAGE");
	System.out.println(httpsession.getCreationTime());
	System.out.println(reqDisp.toString());*/
	
	System.out.println("1 "+request.getSession().getServletContext().toString());
	System.out.println("2 "+request.getSession().getServletContext().getContextPath());
	//System.out.println(request.getSession().toString());
	    final String reportPath = request.getSession().getServletContext().getRealPath("/reports/Master-Detail.mrt");
	    final String savePath = request.getSession().getServletContext().getRealPath("\\/reports\\/");
        final String xmlPath = request.getSession().getServletContext().getRealPath("/data/Demo.xml");
        final String xsdPath = request.getSession().getServletContext().getRealPath("/data/Demo.xsd");
        //final String savePath = request.getSession().getServletContext().getRealPath("/save/");
	    com.stimulsoft.base.licenses.StiLicense.setKey("ff");
	    StiWebDesignerOptions options = new StiWebDesignerOptions();
	    options.setLocalization(request.getSession().getServletContext().getRealPath("/localization/en.xml"));
	    options.setTheme(StiWebDesignerTheme.Office2013DarkGrayBlue);		    
	    StiWebDesigerHandler handler = new StiWebDesigerHandler() {
	        //Occurred on loading webdesinger. Must return edited StiReport
	        public StiReport getEditedReport(HttpServletRequest request) {
	            try {
	            	StiReport report = StiSerializeManager.deserializeReport(new FileInputStream(reportPath));
	            	 report.getDictionary().getDatabases().add(new StiXmlDatabase("Demo", xsdPath, xmlPath));
	            	 //System.out.println(report.getDatabases().add(new StiPostgreSQLDatabase(""));
	                return report;
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return null;
	        }
	        //Occurred on opening StiReport. Method intended for populate report data.
	        public void onOpenReportTemplate(StiReport report, HttpServletRequest request) {	
	        	report.getDictionary().getDatabases().add(new StiXmlDatabase("Demo", xsdPath, xmlPath));
	        	  //report = StiSerializeManager.deserializeDocument(new File(reportPath)).getReport();
	               report.render();
	                StiWebViewerOptions options1 = new StiWebViewerOptions();
	                options1.getAppearance().setBackgroundColor(StiColorEnum.Gray.color());
	               
	        	
	        }
	        //Occurred on new StiReport. Method intended for populate report data.
	        public void onNewReportTemplate(StiReport report, HttpServletRequest request) {
	        	report.getDictionary().getDatabases().add(new StiXmlDatabase("Demo", xsdPath, xmlPath));
	        	try{
                    StiXmlTableFieldsRequest tables = StiDataColumnsUtil.parceXSDSchema(new FileInputStream(xsdPath));
                    for (StiXmlTable table : tables.getTables()){
                        StiDataTableSource tableSource = new StiDataTableSource(
                            "Demo." + table.getName(), table.getName(), table.getName());
                        tableSource.setColumns(new StiDataColumnsCollection());
                        for (StiSqlField field : table.getColumns()){
                            StiDataColumn column = new StiDataColumn(
                                field.getName(), field.getName(), field.getSystemType());
                            tableSource.getColumns().add(column);
                        }
                        tableSource.setDictionary(report.getDictionary());
                        report.getDictionary().getDataSources().add(tableSource); 
                    } 
                } catch (Exception e){
                    e.printStackTrace(); 
                } 

	        }
	        //Occurred on save StiReport. Method must implement saving StiReport
	        public void onSaveReportTemplate(StiReport report, StiRequestParams requestParams, HttpServletRequest request) {
	        	/*try {
	                FileOutputStream fos = new FileOutputStream(savePath + requestParams.designer.fileName);
	             	
	                if (requestParams.designer.password != null) {
	                    StiSerializeManager.serializeReport(report, fos, requestParams.designer.password);
	                    System.out.println("NOT NULL");
						fos.write(500000);
	                } else {
	                    StiSerializeManager.serializeReport(report, fos, true);
	                }
	                fos.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }*/
	        	try{
                    FileOutputStream fos = new FileOutputStream(savePath+"\\" +requestParams.designer.fileName);
                   // System.out.println(savePath+"\\" +requestParams.designer.fileName);
                        StiSerializeManager.serializeReport(report, fos);
                        fos.close();
              } catch (Exception e){
                  e.printStackTrace();
              }
	        }
	    };
	    pageContext.setAttribute("handler", handler);
	    pageContext.setAttribute("options", options);
	%>

	<stiwebdesigner:webdesigner handler="${handler}" options="${options}" />
</body>
</html>