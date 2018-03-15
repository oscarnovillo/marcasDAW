<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : biblioteca.xsl
    Created on : 15 de marzo de 2018, 9:03
    Author     : user
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/biblioteca">
        <html>
            <head>
                <title>BIBLIOTECA</title>
            </head>
            <body>
                <h1>BIBLITECA <xsl:value-of select="nombre" /> </h1>
                
                <table border="1">
                    
                    <tr>
                        <td>TITULO</td>
                        
                    </tr>
          
                    
                    <xsl:for-each select="libros/libro">
                        <xsl:sort select="autor"/>
                        <tr>
              
                            <xsl:choose>
                                <xsl:when test="numpaginas equals 1000" >
                                    <td style="background:red" >
                                        <xsl:value-of select="titulo"/>
                                    </td>
                                </xsl:when>
                                <xsl:otherwise >
                                    <td >
                                        <xsl:value-of select="titulo"/>
                                    </td>
                                </xsl:otherwise>
                       
                            </xsl:choose>
               
                                       
                    
                            
                      
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
