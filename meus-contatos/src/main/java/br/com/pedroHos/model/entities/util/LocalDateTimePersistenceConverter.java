package br.com.pedroHos.model.entities.util;

import java.time.Instant;
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
public class LocalDateTimePersistenceConverter implements AttributeConverter<LocalDateTime, Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDateTime localDateTime) {

		if(localDateTime != null) {
			Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			return Date.from(instant);
		}
		
		return null;
		
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Date dbData) {
		Instant instant = Instant.ofEpochMilli(dbData.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	}
}
