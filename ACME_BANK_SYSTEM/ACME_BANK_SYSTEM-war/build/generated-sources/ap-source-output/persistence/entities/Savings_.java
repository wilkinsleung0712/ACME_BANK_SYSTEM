package persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.entities.Customer;
import persistence.entities.Transactions;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-10T09:15:14")
@StaticMetamodel(Savings.class)
public class Savings_ { 

    public static volatile SingularAttribute<Savings, Integer> balance;
    public static volatile CollectionAttribute<Savings, Transactions> transactionsCollection;
    public static volatile SingularAttribute<Savings, Customer> cId;
    public static volatile SingularAttribute<Savings, String> accnum;

}