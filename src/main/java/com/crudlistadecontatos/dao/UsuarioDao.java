package com.crudlistadecontatos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudlistadecontatos.bean.Usuario;
import com.mysql.jdbc.PreparedStatement;;


public class UsuarioDao {
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudlistadecontatos", "root", "" );
			
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		return con;
		
	}
	
	public static List<Usuario> getAllUsuarios() {
		
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				list.add(usuario);
				 				
			}
			
		} catch(Exception e) {
				System.out.println(e);
			}
		
		return list; 		
		
	}
	
	
	
	
	
	
	
	
}
