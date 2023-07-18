package renato.brasil.com.br.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class GasEtaDB extends SQLiteOpenHelper {

    public  static  final  String DB_NAME="gaseta.db";
    public static  final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;


    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaCombustivel = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " nomeDoCombustivel, TEXT \n" +
                " precoDoCombustivel, REAL\n " +
                "melhorOpcao, TEXT\n )"; // uma obsevaçao nao existe double no sqlLITE
                  db.execSQL(sqlTabelaCombustivel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
