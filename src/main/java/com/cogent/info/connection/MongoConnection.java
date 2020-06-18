package com.cogent.info.connection;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConnection {
    public MongoClientSettings getMongoClient() {

        final ConnectionString connectionString = new ConnectionString
                ("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass%20Community&ssl=false");

        final CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder()
                                                                         .automatic(true)
                                                                         .build());

        final CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        return MongoClientSettings.builder()
                                  .applyConnectionString(connectionString)
                                  .codecRegistry(codecRegistry)
                                  .build();
    }
}
