<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:bank="http://bank-app.com"
                xmlns:xslt="http://xml.apache.org/xslt"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" encoding="UTF-8" indent="yes" xslt:indent-amount="4"/>
    <xsl:strip-space elements="*"/>
    <xsl:template match="/bank:bank">
        <html>
            <body>
                <h2>Bank</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th align="left">Name</th>
                        <th align="left">Id</th>
                        <th align="left">Depositor</th>
                        <th align="left">Country</th>
                        <th align="left">Valet</th>
                    </tr>
                    <xsl:for-each select="bank:account">
                        <tr>
                            <td><xsl:value-of select="bank:name"/></td>
                            <td><xsl:value-of select="bank:id"/></td>
                            <td><xsl:value-of select="bank:depositor"/></td>
                            <td><xsl:value-of select="bank:country"/></td>
                            <td>
                                <table border="1">
                                    <tr bgcolor="#9acd32">
                                        <th align="left">Type</th>
                                        <th align="left">Amount</th>
                                        <th align="left">Currency</th>
                                        <th align="left">AnnualPercentage</th>
                                        <th align="left">DepositTerm</th>
                                    </tr>
                                    <xsl:for-each select="bank:valet">
                                        <tr>
                                            <td><xsl:value-of select="bank:type"/></td>
                                            <td><xsl:value-of select="bank:amount"/></td>
                                            <td><xsl:value-of select="bank:currency"/></td>
                                            <td><xsl:value-of select="bank:annualPercentage"/></td>
                                            <td><xsl:value-of select="bank:depositTerm"/></td>
                                        </tr>
                                    </xsl:for-each>
                                </table>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>