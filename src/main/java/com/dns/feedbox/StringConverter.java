package com.dns.feedbox;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;
import org.springframework.util.StringUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *
 * @author Oleg Zhurakousky
 */
public class StringConverter extends MappingMongoConverter {

	public StringConverter(
			MongoDbFactory mongoDbFactory,
			MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext) {
		super(new DefaultDbRefResolver(mongoDbFactory), mappingContext);
	}

	@Override
	public void write(Object source, Bson target) {
		Document document = (Document) target;
		String strPerson = (String) source;
		String[] parsedStrPerson = StringUtils.tokenizeToStringArray(strPerson, ",");
		document.put("fname", parsedStrPerson[0]);
		document.put("lname", parsedStrPerson[1]);
		DBObject innerObject = new BasicDBObject();
		innerObject.put("city", parsedStrPerson[2]);
		innerObject.put("street", parsedStrPerson[3]);
		innerObject.put("zip", parsedStrPerson[4]);
		innerObject.put("state", parsedStrPerson[5]);
		document.put("address", innerObject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S> S read(Class<S> clazz, Bson source) {
		Document document = (Document) source;
		return (S) ((document.get("fname") + ", ")
				+ document.get("lname") + ", "
				+ document.get("city") + ", "
				+ document.get("street") + ", "
				+ document.get("zip") + ", "
				+ document.get("state") + ", ");
	}

}