package model.map;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.adapter.DB;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.InheritanceMap;

/**
 * Tableau etudiant
 *
  *  This class was autogenerated by Torque on:
  *
  * [Thu Jan 10 21:46:17 CET 2013]
  *
  */
public class EtudiantMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "model.map.EtudiantMapBuilder";

    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public synchronized void doBuild() throws TorqueException
    {
        if ( isBuilt() ) {
            return;
        }
        dbMap = Torque.getDatabaseMap("gestion");

        dbMap.addTable("etudiant");
        TableMap tMap = dbMap.getTable("etudiant");
        tMap.setJavaName("Etudiant");
        tMap.setOMClass( model.Etudiant.class );
        tMap.setPeerClass( model.EtudiantPeer.class );
        tMap.setDescription("Tableau etudiant");
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("gestion");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("etudiant_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("etudiant");
        }

        ColumnMap cMap = null;


  // ------------- Column: id --------------------
        cMap = new ColumnMap( "id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "Id" );
        cMap.setAutoIncrement(true);
        cMap.setProtected(false);
        cMap.setDescription("Etudiant Id");
        cMap.setInheritance("false");
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: nom --------------------
        cMap = new ColumnMap( "nom", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Nom" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("nom de l'etudiant");
        cMap.setInheritance("false");
        cMap.setSize( 128 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: prenom --------------------
        cMap = new ColumnMap( "prenom", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Prenom" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("prenom de l'etudiant");
        cMap.setInheritance("false");
        cMap.setSize( 128 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: groupe_id --------------------
        cMap = new ColumnMap( "groupe_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "GroupeId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Foreign Key Groupe");
        cMap.setInheritance("false");
        cMap.setForeignKey("groupe", "id");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
