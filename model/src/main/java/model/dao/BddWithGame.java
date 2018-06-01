package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BddWithGame {

	private static BddConnection connection;
	/**
	 * Initialize the game database
	 */
	public BddWithGame(){
		this.connection = new BddConnection();
	}
	

	public static ResultSet procedure(String sql, int id){
		try{
			CallableStatement call = connection.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	

	public ResultSet procedure(String sql){
		try{
			CallableStatement call = connection.getConnection().prepareCall(sql);
			call.execute();
			return call.getResultSet();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
