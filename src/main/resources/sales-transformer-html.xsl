<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="sales">
        <h2>Sales</h2>
        <p>Payment Form: <xsl:value-of select="paymentForm" /></p>
        <xsl:apply-templates select="products" />
    </xsl:template>

    <xsl:template match="products">
        <h3>Products</h3>
        <xsl:apply-templates select="product" />
    </xsl:template>

    <xsl:template match="product">
        <h1><xsl:value-of select="name" /></h1>
        <p><xsl:value-of select="price" /></p>
        <hr />
    </xsl:template>
</xsl:stylesheet>