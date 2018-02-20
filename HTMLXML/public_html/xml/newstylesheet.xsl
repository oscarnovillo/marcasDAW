<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : newstylesheet.xsl
    Created on : February 20, 2018, 5:55 PM
    Author     : oscar
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>newstylesheet.xsl</title>
            </head>
            <body>
                
                <xsl:value-of select="/arg/jijo/al[@s='1 45']"/>
                <br/>
                <xsl:apply-templates select="/arg/jijo"/>
                
            </body>
        </html>
    </xsl:template>

    <xsl:template match="/arg/jijo">
        <xsl:for-each select="KI">
            <xsl:sort select="."/>
            <br /> <xsl:value-of select="."/>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
