/*
 * MongoDB super class setup the Mongo Atlas connection.
 */
package dra.demo.model.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
/**
 * 
 * @author George
 */
public class MongoDB {
    private MongoClientURI mongoURI;
    private MongoClient mongoClient;    
    private CodecRegistry pojoCodecRegistry;
    private String authorization;
    private final ArrayList<String> clusters = new ArrayList<>();
    protected MongoCredential credential;
    protected MongoDatabase database; //MongoDB super-class initializes and shares the MongoDatabase
    
    //Setup the connection with the MongoDB Atlas 
    public MongoDB(String owner, String password, String role, String db) {        
        
       // this.mongoURI = mongoClientURI(owner, password, role, db); //Specify the mongoURI access rules
        this.mongoClient = new MongoClient(this.mongoURI); //create a mongoClient
        this.database = this.mongoClient.getDatabase(db); //create a database from mongoClient       
        this.pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));//Register Java object for automatic mapping in Mongo Collection       
        this.database = database.withCodecRegistry(pojoCodecRegistry); //Apply the Java-object mapping to the current database
    }    

}
    
