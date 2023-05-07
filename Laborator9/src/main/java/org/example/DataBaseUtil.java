package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBaseUtil {
    String PERSISTENCE_UNIT_NAME = "ExamplePU";
    private static DataBaseUtil instance;
    private final EntityManagerFactory entityManagerFactory;

    private DataBaseUtil(){
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
    public static DataBaseUtil getInstance(){
        if(instance == null){
            instance=new DataBaseUtil();
        }
        return instance;
    }
    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
