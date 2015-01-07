package br.com.pedroHos.model.entities.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
* @author pedro-hos
* 
* Classe usada para converter Data para nova API do Java 8. 
* Converções em: http://blog.progs.be/542/date-to-java-time
* 
*/

@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {
	
	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) {
		
		if(localDate != null) {
			Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
			return Date.from(instant);
		}
		
		return null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date date) {
		
		if(date != null) {
			Instant instant = Instant.ofEpochMilli(date.getTime());
			return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		}
		
		return null;
	}

}
