package com.ddky.fms.refund.utils.xml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter {


	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class clazz) {
		return Date.class.isAssignableFrom(clazz);
	}

	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Date date = (Date) value;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		writer.setValue(formatter.format(date));
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		GregorianCalendar calendar = new GregorianCalendar();
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL);
		try {
			calendar.setTime(formatter.parse(reader.getValue()));
		} catch (Exception e) {
			try {
				throw new Exception(e.getMessage(), e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return calendar;
	}

}
