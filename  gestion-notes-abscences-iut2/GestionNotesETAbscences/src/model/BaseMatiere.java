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
 * Tableau matiere
 *
 * This class was autogenerated by Torque on:
 *
 * [Thu Jan 10 21:46:17 CET 2013]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Matiere
 */
public abstract class BaseMatiere extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1357850777173L;

    /** The Peer class */
    private static final MatierePeer peer =
        new MatierePeer();


    /** The value for the id field */
    private int id;

    /** The value for the intitule field */
    private String intitule;


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
    public void setId(int v) throws TorqueException
    {

        if (this.id != v)
        {
            this.id = v;
            setModified(true);
        }



        // update associated Absence
        if (collAbsences != null)
        {
            for (int i = 0; i < collAbsences.size(); i++)
            {
                ((Absence) collAbsences.get(i))
                        .setMatiereId(v);
            }
        }

        // update associated Note
        if (collNotes != null)
        {
            for (int i = 0; i < collNotes.size(); i++)
            {
                ((Note) collNotes.get(i))
                        .setMatiereId(v);
            }
        }
    }

    /**
     * Get the Intitule
     *
     * @return String
     */
    public String getIntitule()
    {
        return intitule;
    }


    /**
     * Set the value of Intitule
     *
     * @param v new value
     */
    public void setIntitule(String v) 
    {

        if (!ObjectUtils.equals(this.intitule, v))
        {
            this.intitule = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collAbsences
     */
    protected List collAbsences;

    /**
     * Temporary storage of collAbsences to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initAbsences()
    {
        if (collAbsences == null)
        {
            collAbsences = new ArrayList();
        }
    }


    /**
     * Method called to associate a Absence object to this object
     * through the Absence foreign key attribute
     *
     * @param l Absence
     * @throws TorqueException
     */
    public void addAbsence(Absence l) throws TorqueException
    {
        getAbsences().add(l);
        l.setMatiere((Matiere) this);
    }

    /**
     * Method called to associate a Absence object to this object
     * through the Absence foreign key attribute using connection.
     *
     * @param l Absence
     * @throws TorqueException
     */
    public void addAbsence(Absence l, Connection con) throws TorqueException
    {
        getAbsences(con).add(l);
        l.setMatiere((Matiere) this);
    }

    /**
     * The criteria used to select the current contents of collAbsences
     */
    private Criteria lastAbsencesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getAbsences(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List getAbsences()
        throws TorqueException
    {
        if (collAbsences == null)
        {
            collAbsences = getAbsences(new Criteria(10));
        }
        return collAbsences;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere has previously
     * been saved, it will retrieve related Absences from storage.
     * If this Matiere is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getAbsences(Criteria criteria) throws TorqueException
    {
        if (collAbsences == null)
        {
            if (isNew())
            {
               collAbsences = new ArrayList();
            }
            else
            {
                criteria.add(AbsencePeer.MATIERE_ID, getId() );
                collAbsences = AbsencePeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(AbsencePeer.MATIERE_ID, getId());
                if (!lastAbsencesCriteria.equals(criteria))
                {
                    collAbsences = AbsencePeer.doSelect(criteria);
                }
            }
        }
        lastAbsencesCriteria = criteria;

        return collAbsences;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getAbsences(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getAbsences(Connection con) throws TorqueException
    {
        if (collAbsences == null)
        {
            collAbsences = getAbsences(new Criteria(10), con);
        }
        return collAbsences;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere has previously
     * been saved, it will retrieve related Absences from storage.
     * If this Matiere is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getAbsences(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collAbsences == null)
        {
            if (isNew())
            {
               collAbsences = new ArrayList();
            }
            else
            {
                 criteria.add(AbsencePeer.MATIERE_ID, getId());
                 collAbsences = AbsencePeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(AbsencePeer.MATIERE_ID, getId());
                 if (!lastAbsencesCriteria.equals(criteria))
                 {
                     collAbsences = AbsencePeer.doSelect(criteria, con);
                 }
             }
         }
         lastAbsencesCriteria = criteria;

         return collAbsences;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere is new, it will return
     * an empty collection; or if this Matiere has previously
     * been saved, it will retrieve related Absences from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Matiere.
     */
    protected List getAbsencesJoinEtudiant(Criteria criteria)
        throws TorqueException
    {
        if (collAbsences == null)
        {
            if (isNew())
            {
               collAbsences = new ArrayList();
            }
            else
            {
                criteria.add(AbsencePeer.MATIERE_ID, getId());
                collAbsences = AbsencePeer.doSelectJoinEtudiant(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(AbsencePeer.MATIERE_ID, getId());
            if (!lastAbsencesCriteria.equals(criteria))
            {
                collAbsences = AbsencePeer.doSelectJoinEtudiant(criteria);
            }
        }
        lastAbsencesCriteria = criteria;

        return collAbsences;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere is new, it will return
     * an empty collection; or if this Matiere has previously
     * been saved, it will retrieve related Absences from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Matiere.
     */
    protected List getAbsencesJoinMatiere(Criteria criteria)
        throws TorqueException
    {
        if (collAbsences == null)
        {
            if (isNew())
            {
               collAbsences = new ArrayList();
            }
            else
            {
                criteria.add(AbsencePeer.MATIERE_ID, getId());
                collAbsences = AbsencePeer.doSelectJoinMatiere(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(AbsencePeer.MATIERE_ID, getId());
            if (!lastAbsencesCriteria.equals(criteria))
            {
                collAbsences = AbsencePeer.doSelectJoinMatiere(criteria);
            }
        }
        lastAbsencesCriteria = criteria;

        return collAbsences;
    }





    /**
     * Collection to store aggregation of collNotes
     */
    protected List collNotes;

    /**
     * Temporary storage of collNotes to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initNotes()
    {
        if (collNotes == null)
        {
            collNotes = new ArrayList();
        }
    }


    /**
     * Method called to associate a Note object to this object
     * through the Note foreign key attribute
     *
     * @param l Note
     * @throws TorqueException
     */
    public void addNote(Note l) throws TorqueException
    {
        getNotes().add(l);
        l.setMatiere((Matiere) this);
    }

    /**
     * Method called to associate a Note object to this object
     * through the Note foreign key attribute using connection.
     *
     * @param l Note
     * @throws TorqueException
     */
    public void addNote(Note l, Connection con) throws TorqueException
    {
        getNotes(con).add(l);
        l.setMatiere((Matiere) this);
    }

    /**
     * The criteria used to select the current contents of collNotes
     */
    private Criteria lastNotesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getNotes(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List getNotes()
        throws TorqueException
    {
        if (collNotes == null)
        {
            collNotes = getNotes(new Criteria(10));
        }
        return collNotes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere has previously
     * been saved, it will retrieve related Notes from storage.
     * If this Matiere is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getNotes(Criteria criteria) throws TorqueException
    {
        if (collNotes == null)
        {
            if (isNew())
            {
               collNotes = new ArrayList();
            }
            else
            {
                criteria.add(NotePeer.MATIERE_ID, getId() );
                collNotes = NotePeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(NotePeer.MATIERE_ID, getId());
                if (!lastNotesCriteria.equals(criteria))
                {
                    collNotes = NotePeer.doSelect(criteria);
                }
            }
        }
        lastNotesCriteria = criteria;

        return collNotes;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getNotes(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getNotes(Connection con) throws TorqueException
    {
        if (collNotes == null)
        {
            collNotes = getNotes(new Criteria(10), con);
        }
        return collNotes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere has previously
     * been saved, it will retrieve related Notes from storage.
     * If this Matiere is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getNotes(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collNotes == null)
        {
            if (isNew())
            {
               collNotes = new ArrayList();
            }
            else
            {
                 criteria.add(NotePeer.MATIERE_ID, getId());
                 collNotes = NotePeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(NotePeer.MATIERE_ID, getId());
                 if (!lastNotesCriteria.equals(criteria))
                 {
                     collNotes = NotePeer.doSelect(criteria, con);
                 }
             }
         }
         lastNotesCriteria = criteria;

         return collNotes;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere is new, it will return
     * an empty collection; or if this Matiere has previously
     * been saved, it will retrieve related Notes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Matiere.
     */
    protected List getNotesJoinEtudiant(Criteria criteria)
        throws TorqueException
    {
        if (collNotes == null)
        {
            if (isNew())
            {
               collNotes = new ArrayList();
            }
            else
            {
                criteria.add(NotePeer.MATIERE_ID, getId());
                collNotes = NotePeer.doSelectJoinEtudiant(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(NotePeer.MATIERE_ID, getId());
            if (!lastNotesCriteria.equals(criteria))
            {
                collNotes = NotePeer.doSelectJoinEtudiant(criteria);
            }
        }
        lastNotesCriteria = criteria;

        return collNotes;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere is new, it will return
     * an empty collection; or if this Matiere has previously
     * been saved, it will retrieve related Notes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Matiere.
     */
    protected List getNotesJoinMatiere(Criteria criteria)
        throws TorqueException
    {
        if (collNotes == null)
        {
            if (isNew())
            {
               collNotes = new ArrayList();
            }
            else
            {
                criteria.add(NotePeer.MATIERE_ID, getId());
                collNotes = NotePeer.doSelectJoinMatiere(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(NotePeer.MATIERE_ID, getId());
            if (!lastNotesCriteria.equals(criteria))
            {
                collNotes = NotePeer.doSelectJoinMatiere(criteria);
            }
        }
        lastNotesCriteria = criteria;

        return collNotes;
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
            fieldNames.add("Intitule");
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
        if (name.equals("Intitule"))
        {
            return getIntitule();
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
        if (name.equals("Intitule"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setIntitule((String) value);
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
        if (name.equals(MatierePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(MatierePeer.INTITULE))
        {
            return getIntitule();
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
      if (MatierePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (MatierePeer.INTITULE.equals(name))
        {
            return setByName("Intitule", value);
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
            return getIntitule();
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
            return setByName("Intitule", value);
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
        save(MatierePeer.DATABASE_NAME);
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
                    MatierePeer.doInsert((Matiere) this, con);
                    setNew(false);
                }
                else
                {
                    MatierePeer.doUpdate((Matiere) this, con);
                }
            }


            if (collAbsences != null)
            {
                for (int i = 0; i < collAbsences.size(); i++)
                {
                    ((Absence) collAbsences.get(i)).save(con);
                }
            }

            if (collNotes != null)
            {
                for (int i = 0; i < collNotes.size(); i++)
                {
                    ((Note) collNotes.get(i)).save(con);
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
        throws TorqueException
    {
        setId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
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
    public Matiere copy() throws TorqueException
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
    public Matiere copy(Connection con) throws TorqueException
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
    public Matiere copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Matiere(), deepcopy);
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
    public Matiere copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Matiere(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Matiere copyInto(Matiere copyObj) throws TorqueException
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
    protected Matiere copyInto(Matiere copyObj, Connection con) throws TorqueException
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
    protected Matiere copyInto(Matiere copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIntitule(intitule);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List vAbsences = getAbsences();
        if (vAbsences != null)
        {
            for (int i = 0; i < vAbsences.size(); i++)
            {
                Absence obj = (Absence) vAbsences.get(i);
                copyObj.addAbsence(obj.copy());
            }
        }
        else
        {
            copyObj.collAbsences = null;
        }


        List vNotes = getNotes();
        if (vNotes != null)
        {
            for (int i = 0; i < vNotes.size(); i++)
            {
                Note obj = (Note) vNotes.get(i);
                copyObj.addNote(obj.copy());
            }
        }
        else
        {
            copyObj.collNotes = null;
        }
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
    protected Matiere copyInto(Matiere copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setIntitule(intitule);

        copyObj.setId( 0);

        if (deepcopy)
        {


        List vAbsences = getAbsences(con);
        if (vAbsences != null)
        {
            for (int i = 0; i < vAbsences.size(); i++)
            {
                Absence obj = (Absence) vAbsences.get(i);
                copyObj.addAbsence(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collAbsences = null;
        }


        List vNotes = getNotes(con);
        if (vNotes != null)
        {
            for (int i = 0; i < vNotes.size(); i++)
            {
                Note obj = (Note) vNotes.get(i);
                copyObj.addNote(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collNotes = null;
        }
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public MatierePeer getPeer()
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
        return MatierePeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Matiere:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Intitule = ")
           .append(getIntitule())
           .append("\n");
        return(str.toString());
    }
}
