package com.deyi.hadoop.bean;

import org.apache.poi.xssf.usermodel.XSSFFont;

import com.deyi.hadoop.contants.Constants.FormatType;


public class BeanColumn {

	private Short color;
	private XSSFFont font;
	// Headertext for the column in the sheet
	private String headertext;
	// property name = global variablename of the java bean
	private String property;
	// CellFormat
	private FormatType type;

	public BeanColumn(String property, String header, FormatType type) {
		this(property, header, type, null, null);
	}

	public BeanColumn(String property, String header, FormatType type,
			Short color) {
		this(property, header, type, null, color);
	}

	public BeanColumn(String property, String header, FormatType type,
			XSSFFont font) {
		this(property, header, type, font, null);
	}

	public BeanColumn(String property, String header, FormatType type,
			XSSFFont font, Short color) {
		this.property = property;
		this.headertext = header;
		this.type = type;
		this.font = font;
		this.color = color;
	}

	// Getter and Setter - Start

	public Short getColor() {
		return color;
	}

	public XSSFFont getFont() {
		return font;
	}

	public String getHeader() {
		return headertext;
	}

	public String getProperty() {
		return property;
	}

	public FormatType getType() {
		return type;
	}

	public void setColor(Short m_color) {
		this.color = m_color;
	}

	public void setFont(XSSFFont m_font) {
		this.font = m_font;
	}

	public void setHeader(String header) {
		this.headertext = header;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public void setType(FormatType type) {
		this.type = type;
	}
}
