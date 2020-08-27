package dra.demo.model.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import dra.demo.model.*;
import org.bson.Document;

/*
 * @author George 
 * 
 */
public class MongoDBManager extends MongoDB {

    private MongoCollection<Document> collection;

    //Run the MongoDB super-class constructor and build a connection with MongoDB Atlas
    public MongoDBManager(String owner, String password, String role, String db, String collection) {
        super(owner, password, role, db);
        this.collection = super.database.getCollection(collection);
    }




    

}
