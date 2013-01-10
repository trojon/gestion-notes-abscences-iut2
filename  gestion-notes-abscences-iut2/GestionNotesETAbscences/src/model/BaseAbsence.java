package model;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;





/**
 * Tableau absence
 *
 * This class was autogenerated by Torque on:
 *
 * [Thu Jan 10 21:46:17 CET 2013]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Absence
 */
public abstract class BaseAbsence extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1357850777173L;

    /** The Peer class */
    private static final AbsencePeer peer =
        new AbsencePeer();


    /** The value for the id field */
    private int id;

    /** The value for the nbheures field */
    private int nbheures;

    /** The value for the etudiantId field */
    private int etudiantId;

    /** The value for the matiereId field */
    private int matiereId;


    /**
     * Get the Id
     *
     * @return int
     */
    public int getId()
    {
        return id;
    }


    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(int v) 
    {

        if (this.id != v)
        {
            this.id = v;
            setModified(true);
        }


    }

    /**
     * Get the Nbheures
     *
     * @return int
     */
    public int getNbheures()
    {
        return nbheures;
    }


    /**
     * Set the value of Nbheures
     *
     * @param v new value
     */
    public void setNbheures(int v) 
    {

        if (this.nbheures != v)
        {
            this.nbheures = v;
            setModified(true);
        }


    }

    /**
     * Get the EtudiantId
     *
     * @return int
     */
    public int getEtudiantId()
    {
        return etudiantId;
    }


    /**
     * Set the value of EtudiantId
     *
     * @param v new value
     */
    public void setEtudiantId(int v) throws TorqueException
    {

        if (this.etudiantId != v)
        {
            this.etudiantId = v;
            setModified(true);
        }


        if (aEtudiant != null && !(aEtudiant.getId() == v))
        {
            aEtudiant = null;
        }

    }

    /**
     * Get the MatiereId
     *
     * @return int
     */
    public int getMatiereId()
    {
        return matiereId;
    }


    /**
     * Set the value of MatiereId
     *
     * @param v new value
     */
    public void setMatiereId(int v) throws TorqueException
    {

        if (this.matiereId != v)
        {
            this.matiereId = v;
            setModified(true);
        }


        if (aMatiere != null && !(aMatiere.getId() == v))
        {
            aMatiere = null;
        }

    }

    



    private Etudiant aEtudiant;

    /**
     * Declares an association between this object and a Etudiant object
     *
     * @param v Etudiant
     * @throws TorqueException
     */
    public void setEtudiant(Etudiant v) throws TorqueException
    {
        if (v == null)
        {
            setEtudiantId( 0);
        }
        else
        {
            setEtudiantId(v.getId());
        }
        aEtudiant = v;
    }


    /**
     * Returns the associated Etudiant object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Etudiant object
     * @throws TorqueException
     */
    public Etudiant getEtudiant()
        throws TorqueException
    {
        if (aEtudiant == null && (this.etudiantId != 0))
        {
            aEtudiant = EtudiantPeer.retrieveByPK(SimpleKey.keyFor(this.etudiantId));
        }
        return aEtudiant;
    }

    /**
     * Return the associated Etudiant object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Etudiant object
     * @throws TorqueException
     */
    public Etudiant getEtudiant(Connection connection)
        throws TorqueException
    {
        if (aEtudiant == null && (this.etudiantId != 0))
        {
            aEtudiant = EtudiantPeer.retrieveByPK(SimpleKey.keyFor(this.etudiantId), connection);
        }
        return aEtudiant;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setEtudiantKey(ObjectKey key) throws TorqueException
    {

        setEtudiantId(((NumberKey) key).intValue());
    }




    private Matiere aMatiere;

    /**
     * Declares an association between this object and a Matiere object
     *
     * @param v Matiere
     * @throws TorqueException
     */
    public void setMatiere(Matiere v) throws TorqueException
    {
        if (v == null)
        {
            setMatiereId( 0);
        }
        else
        {
            setMatiereId(v.getId());
        }
        aMatiere = v;
    }


    /**
     * Returns the associated Matiere object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Matiere object
     * @throws TorqueException
     */
    public Matiere getMatiere()
        throws TorqueException
    {
        if (aMatiere == null && (this.matiereId != 0))
        {
            aMatiere = MatierePeer.retrieveByPK(SimpleKey.keyFor(this.matiereId));
        }
        return aMatiere;
    }

    /**
     * Return the associated Matiere object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Matiere object
     * @throws TorqueException
     */
    public Matiere getMatiere(Connection connection)
        throws TorqueException
    {
        if (aMatiere == null && (this.matiereId != 0))
        {
            aMatiere = MatierePeer.retrieveByPK(SimpleKey.keyFor(this.matiereId), connection);
        }
        return aMatiere;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setMatiereKey(ObjectKey key) throws TorqueException
    {

        setMatiereId(((NumberKey) key).intValue());
    }
   
        
    private static List fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList();
            fieldNames.add("Id");
            fieldNames.add("Nbheures");
            fieldNames.add("EtudiantId");
            fieldNames.add("MatiereId");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("Id"))
        {
            return new Integer(getId());
        }
        if (name.equals("Nbheures"))
        {
            return new Integer(getNbheures());
        }
        if (name.equals("EtudiantId"))
        {
            return new Integer(getEtudiantId());
        }
        if (name.equals("MatiereId"))
        {
            return new Integer(getMatiereId());
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("Id"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Nbheures"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNbheures(((Integer) value).intValue());
            return true;
        }
        if (name.equals("EtudiantId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setEtudiantId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MatiereId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMatiereId(((Integer) value).intValue());
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(AbsencePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(AbsencePeer.NBHEURES))
        {
            return new Integer(getNbheures());
        }
        if (name.equals(AbsencePeer.ETUDIANT_ID))
        {
            return new Integer(getEtudiantId());
        }
        if (name.equals(AbsencePeer.MATIERE_ID))
        {
            return new Integer(getMatiereId());
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (AbsencePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (AbsencePeer.NBHEURES.equals(name))
        {
            return setByName("Nbheures", value);
        }
      if (AbsencePeer.ETUDIANT_ID.equals(name))
        {
            return setByName("EtudiantId", value);
        }
      if (AbsencePeer.MATIERE_ID.equals(name))
        {
            return setByName("MatiereId", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getId());
        }
        if (pos == 1)
        {
            return new Integer(getNbheures());
        }
        if (pos == 2)
        {
            return new Integer(getEtudiantId());
        }
        if (pos == 3)
        {
            return new Integer(getMatiereId());
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("Id", value);
        }
    if (position == 1)
        {
            return setByName("Nbheures", value);
        }
    if (position == 2)
        {
            return setByName("EtudiantId", value);
        }
    if (position == 3)
        {
            return setByName("MatiereId", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws Exception
     */
    public void save() throws Exception
    {
        save(AbsencePeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    AbsencePeer.doInsert((Absence) this, con);
                    setNew(false);
                }
                else
                {
                    AbsencePeer.doUpdate((Absence) this, con);
                }
            }

            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key id ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        
    {
        setId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
    {
        setId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Absence copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public Absence copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public Absence copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Absence(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public Absence copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Absence(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Absence copyInto(Absence copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected Absence copyInto(Absence copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected Absence copyInto(Absence copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setNbheures(nbheures);
        copyObj.setEtudiantId(etudiantId);
        copyObj.setMatiereId(matiereId);

        copyObj.setId( 0);

        if (deepcopy)
        {
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected Absence copyInto(Absence copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setNbheures(nbheures);
        copyObj.setEtudiantId(etudiantId);
        copyObj.setMatiereId(matiereId);

        copyObj.setId( 0);

        if (deepcopy)
        {
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public AbsencePeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return AbsencePeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Absence:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Nbheures = ")
           .append(getNbheures())
           .append("\n");
        str.append("EtudiantId = ")
           .append(getEtudiantId())
           .append("\n");
        str.append("MatiereId = ")
           .append(getMatiereId())
           .append("\n");
        return(str.toString());
    }
}
