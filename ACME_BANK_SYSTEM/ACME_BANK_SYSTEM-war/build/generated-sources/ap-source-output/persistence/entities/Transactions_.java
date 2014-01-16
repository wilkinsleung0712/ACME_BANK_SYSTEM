package persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistence.entities.Savings;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-10T09:15:14")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, Integer> amount;
    public static volatile SingularAttribute<Transactions, String> tId;
    public static volatile SingularAttribute<Transactions, String> description;
    public static volatile SingularAttribute<Transactions, Savings> accnum;

}