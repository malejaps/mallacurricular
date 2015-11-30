/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reportes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;


import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Maleja
 */
public class IniciarReporte1 {

    public StreamedContent getArchivoPDF(String path)  {

        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/";

        String dbName = "proyectomalla";

        String driver = "com.mysql.jdbc.Driver";

        String userName = "user";

        String password = "pass";

        try {

            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url + dbName, userName, password);

            System.out.println("Connected to the database");

        } catch (Exception e) {
        }

        InputStream inputStream = null;

        Map parameters = new HashMap();
        parameters.put("", null);
        //parameters.put("ALGUN_PARAMETRO", ID_PARAMETRO);

        try {

         /*   ByteArrayOutputStream Teste = new ByteArrayOutputStream();

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getClassLoader().getResourceAsStream(path.trim()));

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

            JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();

            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, Teste);

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);

            exporter.exportReport();

            inputStream = new ByteArrayInputStream(Teste.toByteArray());*/

        } catch (Exception ex) {
        }

        return new DefaultStreamedContent(inputStream, "application/pdf", "nombre_archivo");

    }
}
