<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns="http://www.w3.org/TR/REC-html40">


    <xsl:template match="/RESULTS">

        <head>
            <title>Java Homework</title>
            <meta name="title" content="Java Homework"/>
            <meta name="description" content="Java Homework"/>
            <style type="text/css">
                tr, th, td{
                font: normal small verdana, arial, helvetica, sans-serif;
                font-size: 10px;
                margin: 2px;
                padding: 2px;
                text-align: center;
                border:solid 1px #0b5361;
                background-color: 99ff33;
                }
                th{
                text-align: center;
                font-weight:bold;
                background-color: 990000;
                color: #f3f4f2;
                }
            </style>
        </head>


        <table border="1" name="final_results" width="100%">
            <tr>
                <th>Place</th>
                <th>Name</th>
                <th>Score</th>
                <th>Long Jump</th>
                <th>Shot Put</th>
                <th>High Jump</th>
                <th>400m</th>
                <th>110m hurdles</th>
                <th>Discus</th>
                <th>Pole Vault</th>
                <th>Javelin</th>
                <th>1500m</th>
            </tr>
            <xsl:apply-templates select="ATHLET"/>
        </table>


    </xsl:template>


    <xsl:template match="ATHLET">
        <tr>
            <td>
                <bold>
                    <xsl:value-of select="@PLACE"/>
                </bold>
            </td>
            <td>
                <xsl:value-of select="@NAME"/>
            </td>
            <td>
                <xsl:value-of select="@SCORE"/>
            </td>
            <td>
                <xsl:value-of select="@longJump"/>
            </td>
            <td>
                <xsl:value-of select="@shotPut"/>
            </td>
            <td>
                <xsl:value-of select="@highJump"/>
            </td>
            <td>
                <xsl:value-of select="@running400m"/>
            </td>
            <td>
                <xsl:value-of select="@running100mHurdles"/>
            </td>
            <td>
                <xsl:value-of select="@discusThrow"/>
            </td>
            <td>
                <xsl:value-of select="@poleVault"/>
            </td>
            <td>
                <xsl:value-of select="@javelinThrow"/>
            </td>
            <td>
                <xsl:value-of select="@running1500m"/>
            </td>
        </tr>

    </xsl:template>


</xsl:stylesheet>
